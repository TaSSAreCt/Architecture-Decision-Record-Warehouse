<script lang="ts">

    import {getContext} from "svelte";
    import type {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte";

    const selectionManager : SelectionManager = getContext("selectionManager");
    let selectedRationale = selectionManager.selectedRationale;

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

<button class="w3-button w3- w3-border w3-margin-bottom" style="width: 100%" onclick={() => toggle(selectedRationale.id)}
>{selectedRationale.title}</button><br>

<div id={selectedRationale.id} style="display: none;">
    <p>Title: {selectedRationale.title}</p>
    <p>Context: {selectedRationale.context}</p>
    <p>Decision: {selectedRationale.decision}</p>
    <p>Status: {selectedRationale.status}</p>
    <p>Consequences: {selectedRationale.consequences}</p>
</div>