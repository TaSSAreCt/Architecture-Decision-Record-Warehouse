<script lang="ts">

    import { enhance } from "$app/forms";
    import {getContext} from "svelte";
    import {ArchitecturalRequirements} from "$lib/domain/entity/ar/ArchitecturalRequirements.svelte.js";
    import {NonFunctionalRequirement} from "$lib/domain/entity/ar/NonFunctionalRequirement.svelte.js";
    import {ArchitecturalKnowledge} from "$lib/domain/aggregate/ArchitecturalKnowledge.svelte";
    import {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte";
    import CreateRationaleForm from "$lib/components/form/ad/CreateRationaleForm.svelte";
    import {Issue} from "$lib/domain/entity/ad/Issue.svelte";

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

{#if selectionManager.selectedSystem}
    <div class="">

        <h2><u>{selectionManager.selectedSystem.title}</u></h2>
        <hr>

        <!-- List of all non-functional requirement -->
        <h4>Non-Functional Requirements:</h4>
        {#each selectionManager.selectedSystem.nonFunctionalRequirementList as nonFunctionalRequirement}
            <p>{nonFunctionalRequirement.title}</p>
        {/each}
        <hr>

        <h4>Architecture Decision Records:</h4>
        <!--
        {#each selectionManager.selectedSystemOfSystems.architecturalDecisions as architecturalDecision}
            {#if architecturalDecision.alternatives.some(alternative => alternative.architectureRationales.length !== 0)}
                <p>{architecturalDecision.issue.title}</p>
            {/if}
        {/each}
        -->
        <hr>

        <h4>Issues:</h4>
        {#each selectionManager.selectedSystem.issueList as issue}
            {#if issue.alternativeList.every(alternative => alternative.rationaleList.length === 0)}
                <p><button class="w3-button w3-border" onclick={() => {
                    toggle(issue.id);
                    selectionManager.selectedIssue = issue;
                }}>
                justify</button> {issue.title}</p>
                <div id={issue.id} style="display: none">
                    <CreateRationaleForm />
                </div>
            {/if}
        {/each}
        <hr>

        <div>
            <h4>Architectural Knowledge:</h4>
            <div id="raiseIssue" class="" style="">

                <form method="POST" action="actions/sos/systems?/raiseIssue" use:enhance={({formData}) => {

                    if (selectionManager.selectedSystem?.id !== undefined) {
                        formData.set("systemId", selectionManager.selectedSystem.id);
                    }

                    return async ({result}) => {

                        if (result) {

                            const architectureDecision = architecturalKnowledge.issueList.find(issue => issue.id === String(formData.get('issueId'))) ?? Issue.create();

                            if (selectionManager.selectedSystem?.id !== undefined) {
                                selectionManager.selectedSystem.issueList.push(architectureDecision);
                            }

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
                                {#each architecturalKnowledge.issueList as issue}
                                    {#if !selectionManager.selectedSystem.issueList.some(item => item.id === issue.id)}
                                        <option value={issue.id}>{issue.title}</option>
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

                    formData.set("systemId", selectionManager.selectedSystem.id);

                    return async ({result}) => {
                        if (result) {
                            const nonFunctionalRequirement = architecturalRequirements.nonFunctionalRequirementList.find(nonFunctionalRequirement => nonFunctionalRequirement.id === String(formData.get('nonFunctionalRequirementId'))) ?? NonFunctionalRequirement.create();
                            selectionManager.selectedSystem.nonFunctionalRequirementList.push(nonFunctionalRequirement);
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
                                {#each architecturalRequirements.nonFunctionalRequirementList as nonFunctionalRequirement}
                                    {#if !selectionManager.selectedSystem.nonFunctionalRequirementList.some(item => item.id === nonFunctionalRequirement.id)}
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
{/if}