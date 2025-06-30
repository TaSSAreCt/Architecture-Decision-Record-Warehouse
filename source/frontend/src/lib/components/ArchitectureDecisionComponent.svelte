<script lang="ts">

    import {ArchitectureDecision} from "$lib/domain/aggregate/ArchitectureDecision.svelte";
    import {FormManager} from "$lib/domain/manager/FormManager.svelte.js";
    import {getContext} from "svelte";
    import {SelectionManager, } from "$lib/domain/manager/SelectionManager.svelte.js";

    const { architectureDecision } : { architectureDecision : ArchitectureDecision } = $props();

    const formManager : FormManager = getContext("formManager");
    const selectionManager : SelectionManager = getContext("selectionManager");


</script>

<div>

    {#each architectureDecision.alternatives as alternative}
        {#if alternative.architectureRationales.length !== 0}
           <p>Architecture Decision: <button class="w3-button w3-border-bottom" onclick={() => {
               selectionManager.selectedArchitecturalDecision = architectureDecision;
               formManager.toggle("updateArchitectureDecision");
           }}>{architectureDecision.issue.title}</button> is solved by <button class="w3-button w3-border-bottom" onclick={() => {
                selectionManager.selectedArchitecturalDecision = architectureDecision;
                formManager.toggle("updateAlternative");
           }}>{alternative.alternative.title}</button> justified by <button class="w3-button w3-border-bottom" onclick={() => {
                selectionManager.selectedArchitecturalDecision = architectureDecision;
                formManager.toggle("updateArchitecturalRationale");
           }}>{alternative.architectureRationales[0].title}</button></p>
        {/if}
    {/each}
</div>