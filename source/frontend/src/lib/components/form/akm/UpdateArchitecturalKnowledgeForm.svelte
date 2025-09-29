<script lang="ts">

    import {getContext} from "svelte";
    import {ArchitecturalKnowledge} from "$lib/domain/aggregate/ArchitecturalKnowledge.svelte";
    import {ArchitectureRequirement} from "$lib/domain/entity/ar/ArchitectureRequirement.svelte";
    import {enhance} from "$app/forms";
    import {Influence} from "$lib/domain/entity/ad/Influence.svelte";

    const architecturalKnowledge : ArchitecturalKnowledge = getContext("architecturalKnowledge");

    let architectureRequirementFlatMap : ArchitectureRequirement[] = [
        ...architecturalKnowledge.architecturalRequirements.nonFunctionalRequirementList,
        ...architecturalKnowledge.architecturalRequirements.intentionList,
        ...architecturalKnowledge.architecturalRequirements.architecturePrincipleList,
        ...architecturalKnowledge.architecturalRequirements.constraintList
    ];

</script>

<div>
    <h5>Update architectural knowledge:</h5>

    <form method="post" action="actions/akm?/createInfluence" use:enhance={({formData, formElement}) =>{

        const id = crypto.randomUUID();
        formData.set("id", id);

        const influence : Influence = Influence.create();

        influence.value = Number(formData.get("value"));
        influence.id = id;
        influence.architectureRequirement = architectureRequirementFlatMap.find(architectureRequirement => architectureRequirement.id === String(formData.get("architectureRequirementId")));

        return async ({result}) => {
            architecturalKnowledge.issueList.flatMap(issue => issue.alternativeList).forEach(alternative => {
                if (alternative.id === String(formData.get("alternativeId"))) {
                    alternative.influenceList.push(influence);
                }
            })
            formElement.reset();
        }
    }}>

        <select class="w3-input w3-margin-top" name="architectureRequirementId" id ="architectureRequirementId" required>
            {#each architectureRequirementFlatMap as architectureRequirement}
                <option value={architectureRequirement.id}>{architectureRequirement.title}</option>
            {/each}
        </select><br>

        <select class="w3-input w3-margin-top" name="alternativeId" id ="alternativeId" required>
            {#each architecturalKnowledge.issueList.flatMap(issue => issue.alternativeList) as alternative}
                <option value={alternative.id}>{alternative.title}</option>

            {/each}
        </select><br>

        <input id="value" name="value" type="number" min="-1" max="1" step="0.1" /><br>

        <button class="w3-button w3-border" style="margin-top: 20px;" type="submit">create</button>
    </form>


</div>