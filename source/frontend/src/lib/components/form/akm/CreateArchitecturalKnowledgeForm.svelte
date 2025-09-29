<script lang="ts">

    import {Issue} from "$lib/domain/entity/ad/Issue.svelte";
    import {enhance} from "$app/forms";
    import {getContext} from "svelte";
    import {ArchitecturalKnowledge} from "$lib/domain/aggregate/ArchitecturalKnowledge.svelte";
    import {Alternative} from "$lib/domain/entity/ad/Alternative.svelte";
    import {ArchitectureRequirement} from "$lib/domain/entity/ar/ArchitectureRequirement.svelte";
    import {Influence} from "$lib/domain/entity/ad/Influence.svelte";

    let issue : Issue | undefined = $state(undefined);

    const architecturalKnowledge: ArchitecturalKnowledge = getContext("architecturalKnowledge");

    let selectedArchitecturalRequirements : string[] = $state<string[]>([]);
    let values : number[] = $state<number[]>([]);

    let architectureRequirementFlatMap : ArchitectureRequirement[] = [
        ...architecturalKnowledge.architecturalRequirements.nonFunctionalRequirementList,
        ...architecturalKnowledge.architecturalRequirements.intentionList,
        ...architecturalKnowledge.architecturalRequirements.architecturePrincipleList,
        ...architecturalKnowledge.architecturalRequirements.constraintList
    ];

</script>

<div>

    <h5>Create a architectural knowledge:</h5>

    {#if issue}

        <p>{issue.title}</p>

        <form id="alternativeForm" method="POST" action="actions/ad/alternative?/createAlternativeWithIssueAndArchitecturalRequirements" use:enhance={({formData, formElement}) => {

            const alternative : Alternative = Alternative.create();

            alternative.id = crypto.randomUUID();
            formData.set("id", alternative.id);
            alternative.title = String(formData.get("title"));
            formData.set("issueId", issue.id);

            const influenceIds = Array.from({ length: selectedArchitecturalRequirements.length }, () => crypto.randomUUID());

            formData.set("influenceIds", influenceIds.join(","));
            formData.set("selectedArchitecturalRequirements", selectedArchitecturalRequirements.join(","));
            formData.set("values", values.join(","));

            return async ({result}) => {

                selectedArchitecturalRequirements.forEach(((architectureRequirementId, index) => {
                    let architectureRequirement : ArchitectureRequirement | undefined = architectureRequirementFlatMap.find(item => item.id === architectureRequirementId);

                    let influence : Influence = Influence.create();

                    influence.id = influenceIds[index];
                    influence.value = values[index];
                    influence.architectureRequirement = architectureRequirement

                    alternative.influenceList.push(influence);

                }));

                issue.alternativeList.push(alternative);
                formElement.reset();
            }
        }}>

            <div class="w3-left" style="width: 400px">
                <input class="w3-input" placeholder="Alternative title" id="title" type="text" name="title"><br>
            </div>

            <div class="" style="width: 400px">
                <label for="architecturalRequirements">Choose architectural requirements:</label>
                <select name="architecturalRequirements" id="architecturalRequirements" bind:value={selectedArchitecturalRequirements} multiple>

                    {#each architectureRequirementFlatMap as architectureRequirement}
                        <option value={architectureRequirement.id}>{architectureRequirement.title}</option>
                    {/each}
                </select>
            </div>

            {#each { length : selectedArchitecturalRequirements.length }, i}
                <input type="number" min="-1" max="1" step="0.1" bind:value={values[i]} /><br>
            {/each}

            <div class="">
                <button class="w3-button w3-border" style="margin-left: 20px" type="submit">+</button>
            </div>

        </form>

        {#each issue.alternativeList as alternative}

            <div class="w3-container">
                <p>{alternative.title}</p>
            </div>


        {/each}

    {:else if !issue}

        <form id="issueForm" method="POST" action="actions/ad/issue?/createIssue" use:enhance={({formData, formElement}) => {

        issue = Issue.create();

        issue.id = crypto.randomUUID();
        formData.set("id", issue.id);
        issue.title = String(formData.get("title"));

        return async ({result}) => {
            if (result) {
                console.log("Issue is created.");

                if (issue) {
                    architecturalKnowledge.issueList.push(issue);
                }
                formElement.reset();

            }
        }

    }}>
            <div class="w3-row">
                <div class="w3-left" style="width: 400px">
                    <input class="w3-input" placeholder="Issue title" id="title" type="text" name="title"><br>
                </div>

                <div class="w3-rest">
                    <button class="w3-button w3-border" style="margin-left: 20px" type="submit">+</button>
                </div>
            </div>

        </form>
    {/if}
</div>