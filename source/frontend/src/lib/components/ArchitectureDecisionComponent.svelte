<script lang="ts">

    import {FormManager} from "$lib/domain/manager/FormManager.svelte.js";
    import {getContext} from "svelte";
    import {SelectionManager, } from "$lib/domain/manager/SelectionManager.svelte.js";
    import {Issue} from "$lib/domain/entity/ad/Issue.svelte";

    const { issue } : { issue : Issue } = $props();

    const formManager : FormManager = getContext("formManager");
    const selectionManager : SelectionManager = getContext("selectionManager");


</script>

<div>

    {#each issue.alternativeList as alternative}
        {#if alternative.rationaleList.length !== 0 && alternative.rationaleList.some(rationale =>
            selectionManager.selectedSystem.rationaleList.some(
                sysRationale => sysRationale.id === rationale.id
            )
        )}
           <p>Architecture Decision: <button class="w3-button w3-border-bottom" onclick={() => {
               selectionManager.selectedIssue = issue;
               formManager.toggle("updateArchitectureDecision");
           }}>{issue.title}</button> is solved by <button class="w3-button w3-border-bottom" onclick={() => {
                selectionManager.selectedIssue = issue;
                formManager.toggle("updateAlternative");
           }}>{alternative.title}</button> justified by <button class="w3-button w3-border-bottom" onclick={() => {
                selectionManager.selectedRationale = alternative.rationaleList.at(0);
                formManager.toggle("updateArchitecturalRationale");
           }}>{alternative.rationaleList.at(0)?.title}</button></p>
        {/if}
    {/each}
</div>