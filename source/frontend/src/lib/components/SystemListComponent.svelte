<script lang="ts">
    import SystemComponent from "$lib/components/SystemComponent.svelte";
    import Self from "$lib/components/SystemListComponent.svelte";
    import {FormManager} from "$lib/domain/manager/FormManager.svelte.js";
    import {getContext} from "svelte";
    import {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte.js";
    import ArchitecturalDecisionsComponent from "$lib/components/ArchitecturalDecisionsComponent.svelte";
    import NonFunctionalRequirementsComponent from "$lib/components/NonFunctionalRequirementsComponent.svelte";
    import {System} from "$lib/domain/entity/sos/System.svelte";
    import SystemElementListComponent from "$lib/components/SystemElementListComponent.svelte";

    let { system, root } : { system : System, root : boolean} = $props();

    const formManager : FormManager = getContext("formManager");
    const selectionManager : SelectionManager = getContext("selectionManager");

</script>

<div class="">

    {#if root}
        <SystemComponent system={system} />
    {/if}

    {#if system.nonFunctionalRequirementList.length !== 0}
        <NonFunctionalRequirementsComponent system={system} nonFunctionalRequirements={system.nonFunctionalRequirementList} />
    {/if}

    {#if system.systemElementList.length !== 0}
        <SystemElementListComponent systemElementList={system.systemElementList} />
    {/if}

    {#if system.issueList.length !== 0}
        <ArchitecturalDecisionsComponent system={system} />
    {/if}

    {#if system.systemList.length !== 0}

        {#each system.systemList as childSystem}
            <div class="w3-container w3-margin w3-border">
                <p class="">
                    System <button class="w3-button w3-border-bottom" onclick={() => {
                        selectionManager.selectedSystem = childSystem;
                        formManager.toggle("updateSystem");
                    }}>{childSystem.title}</button> part of system {system.title}
                </p>
                <Self system={childSystem} root={false} />
            </div>
        {/each}

    {/if}

</div>