<script lang="ts">

    import Systems from "$lib/components/Systems.svelte";
    import {AdrWarehouse} from "$lib/domain/aggregate/AdrWarehouse.svelte.js";
    import {getContext} from "svelte";
    import MetricsComponent from "$lib/components/metrics/MetricsComponent.svelte";

    const adrWarehouse : AdrWarehouse = getContext('adrWarehouse');

</script>

<!-- Content -->
<div class="w3-rest w3-container">

    <!-- Header -->
    <div class="w3-center">
        <hr style="height:2px;border:none;color:#333;background-color:#333;">
        <h1>Architecture Decision Record Warehouse</h1>
        <hr style="height:2px;border:none;color:#333;background-color:#333;">
    </div>

    <!-- Metrics -->
    <div class="w3-container w3-margin">
        <MetricsComponent />
    </div>
    <hr style="height:1px;border:none;color:#333;background-color:#333;">

    <!-- Systems of Systems -->
    {#each adrWarehouse.systemsOfSystems as systemOfSystems}
        <div class="w3-container w3-margin w3-border" style="">
            <Systems systemOfSystems={systemOfSystems} root={true}/>
        </div>
    {/each}
</div>
