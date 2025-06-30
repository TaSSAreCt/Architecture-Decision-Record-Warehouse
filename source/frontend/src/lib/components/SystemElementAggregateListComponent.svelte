<script lang="ts">

    import {SystemElementAggregate} from "$lib/domain/aggregate/SystemElementAggregate.svelte";
    import SystemElementAggregateComponent from "$lib/components/SystemElementAggregateComponent.svelte";
    import {getContext} from "svelte";
    import {FormManager} from "$lib/domain/manager/FormManager.svelte.js";
    import {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte.js";

    const { systemElementAggregates } : { systemElementAggregates : SystemElementAggregate[]} = $props();

    const formManager : FormManager = getContext("formManager");
    const selectionManager : SelectionManager = getContext("selectionManager");

</script>

<div>

    <p>
        System Elements:
        {#each systemElementAggregates as item, index}
            <button class="w3-button w3-border-bottom" onclick={() => {
                selectionManager.selectedSystemElementAggregate = item;
                formManager.toggle("updateSystemElement");
            }}>{item.title}</button>{index < systemElementAggregates.length - 1 ? ', ' : ''}
        {/each}
    </p>

    {#each systemElementAggregates as systemElementAggregate}
        {#if systemElementAggregate.constraints.length !== 0}
            <SystemElementAggregateComponent systemElementAggregate={systemElementAggregate} />
        {/if}
    {/each}

</div>