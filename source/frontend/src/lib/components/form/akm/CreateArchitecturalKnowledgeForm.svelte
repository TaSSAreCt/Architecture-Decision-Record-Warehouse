<script lang="ts">
    import { enhance } from "$app/forms";
    import {getContext} from "svelte";
    import {ArchitectureDecision} from "$lib/domain/aggregate/ArchitectureDecision.svelte";
    import {AlternativeAggregate} from "$lib/domain/aggregate/AlternativeAggregate.svelte";
    import { ForcedBy} from "$lib/domain/aggregate/ForcedBy.svelte";
    import {Constraint} from "$lib/domain/entity/ar/Constraint.svelte";
    import {Intention} from "$lib/domain/entity/ar/Intention.svelte.js";
    import {NonFunctionalRequirement} from "$lib/domain/entity/ar/NonFunctionalRequirement.svelte.js";
    import {ArchitecturePrinciple} from "$lib/domain/entity/ar/ArchitecturePrinciple.svelte.js";
    import {ArchitecturalKnowledge} from "$lib/domain/aggregate/ArchitecturalKnowledge.svelte";
    import {toAlternativeAggregateRequestDto} from "$lib/dto/request/aggregate/AlternativeAggregateRequestDto";
    import {FormManager} from "$lib/domain/manager/FormManager.svelte";
    import type {ArchitecturalRequirements} from "$lib/domain/aggregate/ArchitecturalRequirements.svelte";
    import CreateIssueForm from "$lib/components/form/ad/CreateIssueForm.svelte";
    import type {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte";
    import CreateAlternativeForm from "$lib/components/form/ad/CreateAlternativeForm.svelte";
    import CreateArchitectureRequirementForm from "$lib/components/form/akm/CreateArchitectureRequirementForm.svelte";

    // get runes
    const formManager : FormManager = getContext('formManager');
    const selectionManager : SelectionManager = getContext('selectionManager');

    // create architectural knowledge
    let architectureDecision : ArchitectureDecision = ArchitectureDecision.create();

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

    {#if selectionManager.selectedArchitecturalDecision}

        <hr>

        <p>Issue: {selectionManager.selectedArchitecturalDecision.issue.title}</p>

        <CreateAlternativeForm />

        <hr>

        {#each selectionManager.selectedArchitecturalDecision.alternatives as alternativeAggregate}

            <div>
                <!-- Alternatives -->
                <button class="w3-button w3-border w3-left-align" type="button" style="width: 100%" onclick={() => {
                        toggle(alternativeAggregate.alternative.id);
                    }}>
                    Alternative: {alternativeAggregate.alternative.title}
                </button>

                <div id={alternativeAggregate.alternative.id} style="display: none" class="w3-padding-top-24 w3-margin-bottom">
                    <CreateArchitectureRequirementForm {alternativeAggregate} />
                </div>
            </div>
        {/each}

    {:else}
        <CreateIssueForm />
    {/if}

    <hr>
</div>

