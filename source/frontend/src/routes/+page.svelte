<script lang="ts">

    import {getContext} from "svelte";
    import MetricsComponent from "$lib/components/metrics/MetricsComponent.svelte";
    import SystemListComponent from "$lib/components/SystemListComponent.svelte";
    import {System} from "$lib/domain/entity/sos/System.svelte";

    const cpsos : System[] = getContext('cpsos');

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
    {#each cpsos as system}
        <div class="w3-container w3-margin w3-border" style="">
            <SystemListComponent system={system} root={true}/>
        </div>
    {/each}
</div>
