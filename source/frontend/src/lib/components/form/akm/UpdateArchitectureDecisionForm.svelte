<script lang="ts">
    import {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte.js";
    import {getContext} from "svelte";

    const selectionManager : SelectionManager = getContext("selectionManager");

</script>

<div>
    <h2><u>{selectionManager.selectedArchitecturalDecision.issue.title}</u></h2>
    <hr>

    {#each selectionManager.selectedArchitecturalDecision.alternatives as alternative}
        <p>{alternative.alternative.title} ({alternative.getRanked()})</p>
    {/each}
</div>