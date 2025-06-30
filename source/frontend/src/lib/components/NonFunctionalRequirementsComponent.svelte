<script lang="ts">
    import {NonFunctionalRequirement} from "$lib/domain/entity/ar/NonFunctionalRequirement.svelte.js";
    import {SystemOfSystems} from "$lib/domain/aggregate/SystemOfSystems.svelte.js";
    import type {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte";
    import {getContext} from "svelte";

    const { systemOfSystems, nonFunctionalRequirements } : { systemOfSystems : SystemOfSystems, nonFunctionalRequirements : NonFunctionalRequirement[] } = $props();

    const selectionManager : SelectionManager = getContext('selectionManager');

</script>

<div>
    <p>
        {systemOfSystems.system.title} requires {#each nonFunctionalRequirements as nonFunctionalRequirement}{nonFunctionalRequirement.title},{/each}
    </p>
</div>
