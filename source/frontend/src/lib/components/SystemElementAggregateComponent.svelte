<script lang="ts">

    import {SystemElementAggregate} from "$lib/domain/aggregate/SystemElementAggregate.svelte";
    import {FormManager} from "$lib/domain/manager/FormManager.svelte.js";
    import {getContext} from "svelte";
    import {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte.js";

    const { systemElementAggregate } : { systemElementAggregate : SystemElementAggregate } = $props();

    const formManager : FormManager = getContext("formManager");
    const selectionManager : SelectionManager = getContext("settings");

</script>

<div class="">
    <p>
        {systemElementAggregate.title} is constrained by {#each systemElementAggregate.constraints as constraint} {constraint.title}, {/each}
    </p>
</div>