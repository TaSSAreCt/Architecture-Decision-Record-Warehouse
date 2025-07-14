<script lang="ts">

    import {getContext} from "svelte";
    import {FormManager} from "$lib/domain/manager/FormManager.svelte.js";
    import {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte.js";
    import {SystemElement} from "$lib/domain/entity/sos/SystemElement.svelte";
    import SystemElementComponent from "$lib/components/SystemElementComponent.svelte";

    const { systemElementList } : { systemElementList : SystemElement[]} = $props();

    const formManager : FormManager = getContext("formManager");
    const selectionManager : SelectionManager = getContext("selectionManager");

</script>

<div>

    <p>
        System Elements:
        {#each systemElementList as item, index}
            <button class="w3-button w3-border-bottom" onclick={() => {
                selectionManager.selectedSystemElement = item;
                formManager.toggle("updateSystemElement");
            }}>{item.title}</button>{index < systemElementList.length - 1 ? ', ' : ''}
        {/each}
    </p>

    {#each systemElementList as systemElement}
        {#if systemElement.constraints.length !== 0}
            <SystemElementComponent systemElement={systemElement} />
        {/if}
    {/each}

</div>