<script lang="ts">
    import {getContext} from "svelte";
    import { enhance } from "$app/forms";
    import {FormManager} from "$lib/domain/manager/FormManager.svelte.js";
    import {SystemOfSystems} from "$lib/domain/aggregate/SystemOfSystems.svelte";
    import {AdrWarehouse} from "$lib/domain/aggregate/AdrWarehouse.svelte.js";

    const formManager : FormManager = getContext('formManager');
    const adrWarehouse : AdrWarehouse = getContext('adrWarehouse');

    let isChecked = $state(false);
</script>

<div class="">

    <h5>Create a new system:</h5>
    <form method="POST" action="actions/sos/systems?/createSystem" use:enhance={({formData}) => {

    let sos : SystemOfSystems = SystemOfSystems.create();

    sos.system.id = crypto.randomUUID();
    formData.set('id', sos.system.id);
    sos.system.title = String(formData.get('title'));

    if (isChecked) {
        formData.set('parentSystemClassId', String(formData.get('parentSystemId')));
    }

    return async ({result}) => {

        if (result) {

            if (isChecked) {
                const systemOfSystems = adrWarehouse.getSystemOfSystems(String(formData.get('parentSystemId')));
                systemOfSystems?.childSystems.push(sos);
            } else {
                adrWarehouse.systemsOfSystems.push(sos);
            }
            console.log("SystemComponent is created.");

            formManager.reset();
        }

    };
}}>

        <input class="w3-input" placeholder="Title" id="title" type="text" name="title"><br>

        <label>
            <input type="checkbox" style="margin-right:5px" bind:checked={isChecked} />
            part of
        </label><br>

        {#if isChecked}
            <select class="w3-input" name="parentSystemId" id ="parentSystemId">
                {#each adrWarehouse.getSystems() as systemOfSystems}
                    <option value={systemOfSystems.system.id}>{systemOfSystems.system.title}</option>
                {/each}
            </select><br>
        {/if}


        <button class="w3-button w3-border" style="margin-top: 20px" type="submit">create</button>
    </form>
</div>


