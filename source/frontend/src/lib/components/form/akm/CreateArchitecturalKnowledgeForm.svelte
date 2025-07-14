<script lang="ts">
    import { enhance } from "$app/forms";
    import {getContext} from "svelte";
    import {FormManager} from "$lib/domain/manager/FormManager.svelte";
    import CreateIssueForm from "$lib/components/form/ad/CreateIssueForm.svelte";
    import type {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte";
    import CreateAlternativeForm from "$lib/components/form/ad/CreateAlternativeForm.svelte";
    import CreateArchitectureRequirementForm from "$lib/components/form/akm/CreateArchitectureRequirementForm.svelte";

    // get runes
    const formManager : FormManager = getContext('formManager');
    const selectionManager : SelectionManager = getContext('selectionManager');

    // helper function to toggle the correct alternative component
    function toggle(elementId : string) {

        // Close alternatives
        architectureDecision.alternatives.forEach(alternativeAggregate => {
            var x = document.getElementById(alternativeAggregate.alternative.id);
            if (x !== null) {
                x.style.display = "none";
            }
        });

        // Open the right alternatives
        var x = document.getElementById(elementId);
        if (x !== null) {
            x.style.display = "block";
        }
    }

</script>

<div>
    <h5>Create architectural knowledge:</h5>

    {#if selectionManager.selectedIssue}

        <hr>

        <p>Issue: {selectionManager.selectedIssue.title}</p>

        <CreateAlternativeForm />

        <hr>

        {#if selectionManager.selectedIssue}
            {#each selectionManager.selectedIssue.alternativeList as alternative}

                <div>
                    <!-- Alternatives -->
                    <button class="w3-button w3-border w3-left-align" type="button" style="width: 100%" onclick={() => {
                        toggle(alternative.id);
                    }}>
                        Alternative: {alternative.title}
                    </button>

                    <div id={alternative.id} style="display: none" class="w3-padding-top-24 w3-margin-bottom">
                        <CreateArchitectureRequirementForm {alternative} />
                    </div>
                </div>
            {/each}
        {/if}



    {:else}
        <CreateIssueForm />
    {/if}

    <hr>
</div>

