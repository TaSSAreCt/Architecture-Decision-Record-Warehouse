<script lang="ts">

    import {System} from "$lib/domain/entity/sos/System.svelte";
    import {FormManager} from "$lib/domain/manager/FormManager.svelte";
    import {getContext} from "svelte";
    import {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte";

    const formManager : FormManager = getContext("formManager");
    const selectionManager : SelectionManager = getContext("selectionManager");

    const { system } : { system : System } = $props();

</script>

<div>


    {#each system.rationaleList as rationale}
        {@const issue = system.issueList.find(issue => issue.alternativeList.some(alt => alt.id === rationale.justifies)) }
        {@const alternative = issue?.alternativeList.find(alt => alt.id === rationale.justifies)}

        <p>Architecture Decision: <button class="w3-button w3-border-bottom" onclick={() => {
           selectionManager.selectedIssue = issue;
           formManager.toggle("updateArchitectureDecision");
       }}>{issue?.title}</button> is solved by <button class="w3-button w3-border-bottom" onclick={() => {
            selectionManager.selectedIssue = issue;
            formManager.toggle("updateAlternative");
       }}>{alternative?.title}</button> justified by <button class="w3-button w3-border-bottom" onclick={() => {
            selectionManager.selectedRationale = rationale;
            formManager.toggle("updateArchitecturalRationale");
       }}>{rationale.title}</button></p>

    {/each}
</div>