<script lang="ts">
    import SystemComponent from "$lib/components/SystemComponent.svelte";
    import Self from "$lib/components/Systems.svelte";
    import {SystemOfSystems} from "$lib/domain/aggregate/SystemOfSystems.svelte";
    import {FormManager} from "$lib/domain/manager/FormManager.svelte.js";
    import {getContext} from "svelte";
    import {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte.js";
    import SystemElementAggregateListComponent from "$lib/components/SystemElementAggregateListComponent.svelte";
    import ArchitecturalDecisionsComponent from "$lib/components/ArchitecturalDecisionsComponent.svelte";
    import NonFunctionalRequirementsComponent from "$lib/components/NonFunctionalRequirementsComponent.svelte";

    let { systemOfSystems, root } : { systemOfSystems : SystemOfSystems, root : boolean} = $props();

    const formManager : FormManager = getContext("formManager");
    const selectionManager : SelectionManager = getContext("selectionManager");

</script>

<div class="">

    {#if root}
        <SystemComponent systemOfSystems={systemOfSystems} />
    {/if}

    {#if systemOfSystems.nonFunctionalRequirements.length !== 0}
        <NonFunctionalRequirementsComponent systemOfSystems={systemOfSystems} nonFunctionalRequirements={systemOfSystems.nonFunctionalRequirements} />
    {/if}

    {#if systemOfSystems.systemElementAggregates.length !== 0}
        <SystemElementAggregateListComponent systemElementAggregates={systemOfSystems.systemElementAggregates} />
    {/if}

    {#if systemOfSystems.architecturalDecisions.length !== 0}
        <ArchitecturalDecisionsComponent architecturalDecisions={systemOfSystems.architecturalDecisions} />
    {/if}

    {#if systemOfSystems.childSystems.length !== 0}

        {#each systemOfSystems.childSystems as childSystem}
            <div class="w3-container w3-margin w3-border">
                <p class="">
                    System <button class="w3-button w3-border-bottom" onclick={() => {
                        selectionManager.selectedSystemOfSystems = childSystem;
                        formManager.toggle("updateSystem");
                    }}>{childSystem.system.title}</button> part of system {systemOfSystems.system.title}
                </p>
                <Self systemOfSystems={childSystem} root={false} />
            </div>
        {/each}

    {/if}

</div>