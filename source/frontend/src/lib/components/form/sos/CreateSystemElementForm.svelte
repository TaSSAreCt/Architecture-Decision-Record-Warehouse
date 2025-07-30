<script lang="ts">
    import {getContext} from "svelte";
    import { enhance } from "$app/forms";
    import {FormManager} from "$lib/domain/manager/FormManager.svelte";
    import {SystemElement} from "$lib/domain/entity/sos/SystemElement.svelte";
    import {System} from "$lib/domain/entity/sos/System.svelte";
    import {getSystemOfSystems, getSystems} from "$lib/utils/getSystemOfSystems";

    const formManager : FormManager = getContext('formManager');
    const cpsos : System[] = getContext('cpsos');


</script>

<div class="">
    <h5>Create a new system element:</h5>

    <form method="post" action="actions/sos/system-elements?/createSystemElement" use:enhance={({ formData }) => {

        let systemElement = SystemElement.create();

        systemElement.id = crypto.randomUUID();
        systemElement.title = String(formData.get('title'));

        formData.set('id', systemElement.id);

        let system : System = getSystemOfSystems(cpsos, String(formData.get('systemId'))) ?? System.create();

        formData.set('systemId', system.id ?? "");

        return async ({ result }) => {
            system?.systemElementList.push(systemElement);
            formManager.reset();
        }
    }}>
        <input class="w3-input" placeholder="Title" type="text" id="title" name="title"><br>

        <div class="w3-row">
            <div class="w3-left" style="width:100px; padding:8px 0px 8px 0px;">
                <label for="systemId">belongs to</label><br>
            </div>

            <div class="w3-rest">
                <select class="w3-input" name="systemId" id ="systemId">
                    {#each getSystems(cpsos) as system}
                        <option value={system.id}>{system.title}</option>
                    {/each}
                </select>
            </div>
        </div>

        <button class="w3-button w3-border" style="margin-top: 20px;" type="submit">create</button>
    </form>
</div>