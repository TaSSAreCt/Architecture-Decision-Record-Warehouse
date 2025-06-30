<script lang="ts">

    import { enhance } from "$app/forms";
    import {getContext, setContext} from "svelte";
    import {ArchitectureDecision} from "$lib/domain/aggregate/ArchitectureDecision.svelte";
    import CreateArchitectureRationaleForm from "$lib/components/form/ad/CreateArchitectureRationaleForm.svelte";
    import {ArchitecturalRequirements} from "$lib/domain/aggregate/ArchitecturalRequirements.svelte";
    import {NonFunctionalRequirement} from "$lib/domain/entity/ar/NonFunctionalRequirement.svelte.js";
    import {ArchitecturalKnowledge} from "$lib/domain/aggregate/ArchitecturalKnowledge.svelte";
    import {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte";

    const architecturalRequirements : ArchitecturalRequirements = getContext('architecturalRequirements');
    const architecturalKnowledge : ArchitecturalKnowledge = getContext('architecturalKnowledge');
    const selectionManager : SelectionManager = getContext("selectionManager");

    function toggle(elementId : string) {
        var x = document.getElementById(elementId);
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }

</script>

<div class="">

    <h2><u>{selectionManager.selectedSystemOfSystems.system.title}</u></h2>
    <hr>

    <!-- List of all non-functional requirement -->
    <h4>Non-Functional Requirements:</h4>
    {#each selectionManager.selectedSystemOfSystems.nonFunctionalRequirements as nonFunctionalRequirement}
        <p>{nonFunctionalRequirement.title}</p>
    {/each}
    <hr>

    <h4>Architecture Decision Records:</h4>
    {#each selectionManager.selectedSystemOfSystems.architecturalDecisions as architecturalDecision}
        {#if architecturalDecision.alternatives.some(alternative => alternative.architectureRationales.length !== 0)}
            <p>{architecturalDecision.issue.title}</p>
        {/if}
    {/each}
    <hr>

    <h4>Issues:</h4>
    {#each selectionManager.selectedSystemOfSystems.architecturalDecisions as architectureDecision}
        {#if architectureDecision.alternatives.every(alternative => alternative.architectureRationales.length === 0)}
            <p><button class="w3-button w3-border" onclick={() => {
                toggle(architectureDecision.issue.id);
                selectionManager.selectedArchitecturalDecision = architectureDecision;
            }}>
            justify</button> {architectureDecision.issue.title}</p>
            <div id={architectureDecision.issue.id} style="display: none">
                <CreateArchitectureRationaleForm architectureDecision={architectureDecision} />
            </div>
        {/if}
    {/each}
    <hr>

    <div>
        <h4>Architectural Knowledge:</h4>
        <div id="raiseIssue" class="" style="">
            <form method="POST" action="actions/sos/systems?/raiseIssue" use:enhance={({formData}) => {

                formData.set("systemId", selectionManager.selectedSystemOfSystems.system.id);

                return async ({result}) => {

                    if (result) {

                        const architectureDecision = architecturalKnowledge.architecturalDecisions.find(architectureDecision => architectureDecision.issue.id === String(formData.get('issueId'))) ?? ArchitectureDecision.create();

                        selectionManager.selectedSystemOfSystems.architecturalDecisions.push(architectureDecision);

                        console.log("Issue is raised.");
                    }
                };
        }}>
                <div class="w3-row">
                    <div class="w3-third">
                        <button class="w3-button w3-border" type="submit">raise</button>
                    </div>
                    <div class="w3-twothird">
                        <select class="w3-input" name="issueId" id ="issueId">
                            {#each architecturalKnowledge.architecturalDecisions as architectureDecision}
                                {#if !selectionManager.selectedSystemOfSystems.architecturalDecisions.some(item => item.issue.id === architectureDecision.issue.id)}
                                    <option value={architectureDecision.issue.id}>{architectureDecision.issue.title}</option>
                                {/if}
                            {/each}
                        </select>
                    </div>
                </div>
            </form>
        </div>

        <hr>

        <div id="requireNonFunctionalRequirement" class="" style="">
            <form method="POST" action="actions/ar/nfr?/require" use:enhance={({formData}) => {

                formData.set("systemId", selectionManager.selectedSystemOfSystems.system.id);

                return async ({result}) => {
                    if (result) {
                        const nonFunctionalRequirement = architecturalRequirements.nonFunctionalRequirements.find(nonFunctionalRequirement => nonFunctionalRequirement.id === String(formData.get('nonFunctionalRequirementId'))) ?? NonFunctionalRequirement.create();
                        selectionManager.selectedSystemOfSystems.nonFunctionalRequirements.push(nonFunctionalRequirement);
                        console.log("NFR is required.");
                    }
                };
        }}>
                <div class="w3-row">
                    <div class="w3-third">
                        <button class="w3-button w3-border" type="submit">require</button>
                    </div>
                    <div class="w3-twothird">
                        <select class="w3-input" name="nonFunctionalRequirementId" id ="nonFunctionalRequirementId">
                            {#each architecturalRequirements.nonFunctionalRequirements as nonFunctionalRequirement}
                                {#if !selectionManager.selectedSystemOfSystems.nonFunctionalRequirements.some(item => item.id === nonFunctionalRequirement.id)}
                                    <option value={nonFunctionalRequirement.id}>{nonFunctionalRequirement.title}</option>
                                {/if}
                            {/each}
                        </select>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>