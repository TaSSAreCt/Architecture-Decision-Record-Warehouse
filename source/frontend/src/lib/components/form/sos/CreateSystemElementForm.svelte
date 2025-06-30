<script lang="ts">
    import {getContext} from "svelte";
    import { enhance } from "$app/forms";
    import {SystemOfSystems} from "$lib/domain/aggregate/SystemOfSystems.svelte";
    import {SystemElementAggregate} from "$lib/domain/aggregate/SystemElementAggregate.svelte";
    import type {FormManager} from "$lib/domain/manager/FormManager.svelte";
    import type {AdrWarehouse} from "$lib/domain/aggregate/AdrWarehouse.svelte";

    const formManager : FormManager = getContext('formManager');
    const adrWarehouse : AdrWarehouse = getContext('adrWarehouse');


</script>

<div class="">
    <h5>Create a new system element:</h5>

    <form method="post" action="actions/sos/system-elements?/createSystemElement" use:enhance={({ formData }) => {

        let systemElementAggregate = SystemElementAggregate.create();

        systemElementAggregate.id = crypto.randomUUID();
        systemElementAggregate.title = String(formData.get('title'));

        formData.set('id', systemElementAggregate.id);

        let systemOfSystems : SystemOfSystems = adrWarehouse.getSystemOfSystems(String(formData.get('systemId'))) ?? SystemOfSystems.create();

        formData.set('systemId', systemOfSystems.system.id);

        return async ({ result }) => {
            systemOfSystems?.systemElementAggregates.push(systemElementAggregate);
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
                    {#each adrWarehouse.getSystems() as systemOfSystems}
                        <option value={systemOfSystems.system.id}>{systemOfSystems.system.title}</option>
                    {/each}
                </select>
            </div>
        </div>

        <button class="w3-button w3-border" style="margin-top: 20px;" type="submit">create</button>
    </form>
</div>