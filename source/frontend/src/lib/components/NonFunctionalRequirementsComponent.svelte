<script lang="ts">
    import {NonFunctionalRequirement} from "$lib/domain/entity/ar/NonFunctionalRequirement.svelte.js";
    import {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte";
    import {getContext} from "svelte";
    import {System} from "$lib/domain/entity/sos/System.svelte";

    const { system, nonFunctionalRequirements } : { system : System, nonFunctionalRequirements : NonFunctionalRequirement[] } = $props();

    const selectionManager : SelectionManager = getContext('selectionManager');

</script>

<div>
    <p>
        {system.title} requires {#each nonFunctionalRequirements as nonFunctionalRequirement}{nonFunctionalRequirement.title},{/each}
    </p>
</div>
