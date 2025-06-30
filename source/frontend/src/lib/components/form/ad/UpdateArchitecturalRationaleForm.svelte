<script lang="ts">

    import {getContext} from "svelte";
    import type {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte";

    const selectionManager : SelectionManager = getContext("selectionManager");

    let selectedAlternative = selectionManager.selectedArchitecturalDecision.getSelectedAlternative();

    function toggle(id : string) {
        var x = document.getElementById(id);

        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }
</script>

<h2><u>Architecture Decision Record</u></h2>
<hr>
<p>{selectionManager.selectedArchitecturalDecision.issue.title} is solved by {selectionManager.selectedArchitecturalDecision.getSelectedAlternative()?.alternative.title}.</p>

{#if selectedAlternative}

    <div>
        {#each selectedAlternative.architectureRationales as architectureRationale}
            <button class="w3-button w3- w3-border w3-margin-bottom" style="width: 100%" onclick={() => {
                toggle(architectureRationale.id);
            }}>{architectureRationale.title}</button><br>

            <div id={architectureRationale.id} style="display: none;">
                <p>Title: {architectureRationale.title}</p>
                <p>Context: {architectureRationale.context}</p>
                <p>Decision: {architectureRationale.decision}</p>
                <p>Status: {architectureRationale.status}</p>
                <p>Consequences: {architectureRationale.consequences}</p>
            </div>
        {/each}
    </div>


{/if}
