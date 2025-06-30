<script lang="ts">


    import {getContext} from "svelte";
    import {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte";

    const selectionManager : SelectionManager = getContext("selectionManager");
    const selectedAlternative = selectionManager.selectedArchitecturalDecision.getSelectedAlternative();

</script>

{#if selectedAlternative}

    <div>
        <h2><u>{selectedAlternative.alternative.title} (Rating: {selectedAlternative.getRanked()})</u></h2>
        <hr>

        {#each selectedAlternative.forcedBy as force}
            <p>{force.architectureRequirement.value.title} ({force.architectureRequirement.type}) ({force.impact})</p>
        {/each}

    </div>
{/if}
