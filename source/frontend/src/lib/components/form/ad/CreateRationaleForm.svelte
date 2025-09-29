<script lang="ts">
    import { enhance } from "$app/forms";
    import {getContext} from "svelte";
    import {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte";
    import type {Issue} from "$lib/domain/entity/ad/Issue.svelte";
    import type {Alternative} from "$lib/domain/entity/ad/Alternative.svelte";
    import {Rationale} from "$lib/domain/entity/ad/Rationale.svelte";

    const selectionManager : SelectionManager = getContext('selectionManager');

    const { issue } : { issue : Issue } = $props();

    let selectedAlternativeId : string = $state("");

    const date = new Date();

    const rationale = Rationale.create();

    let selectedAlternative : Alternative | undefined = $derived(issue.alternativeList.find(alternative => alternative.id === selectedAlternativeId));

</script>

<div class="w3-border" style="">
    <form method="POST" action="actions/ad/architecture-rationale?/createArchitectureRationale" use:enhance={({ formData }) => {

        rationale.id = crypto.randomUUID();
        formData.set('id', rationale.id);

        if (selectionManager.selectedSystem) {
            formData.set('systemId', selectionManager.selectedSystem.id);
        }

        rationale.title = String(formData.get('title'));
        rationale.consequences = String(formData.get('consequences'));
        rationale.context = String(formData.get('context'));
        rationale.status = String(formData.get('status'));
        rationale.decision = String(formData.get('decision'));
        rationale.justifies = selectedAlternativeId;

        return async ({result}) => {

            selectionManager.selectedSystem.rationaleList.push(rationale);

            // selectedAlternative.rationaleList.push(rationale);
            console.log("Architecture Rationale is created.");

        };
    }}>

        <div class="option-group">

            {#each issue.alternativeList as alternative}

                {@const ranking = alternative.getRanking(selectionManager.selectedSystem.nonFunctionalRequirementList, selectionManager.selectedSystem.systemElementList.flatMap(systemElement => systemElement.constraintList))}

                <p>

                        <input type="radio" name="alternativeId" id={alternative.id} class="option w3-border-{ranking.color}" value={alternative.id} required bind:group={selectedAlternativeId}>
                        <label for={alternative.id} class="w3-center option-label tooltip w3-border-{ranking.color}"><span class="tooltiptext">Influences:<br>

                        {#each alternative.influenceList as influence}
                            {influence.architectureRequirement.title} ({influence.value})<br>
                        {/each}

                    </span>{alternative.title} ({ranking.value})</label>

                </p>

            {/each}

        </div>

        {#if selectedAlternative}

            {@const categorised = selectedAlternative.categoriseInfluenceList(selectionManager.selectedSystem.nonFunctionalRequirementList, selectionManager.selectedSystem.systemElementList.flatMap(systemElement => systemElement.constraintList))}

            <input class="w3-input" placeholder="Title" id="title" type="text" name="title" value={`${date.getFullYear()}-${date.getMonth()}-${date.getDay()}_ADR-1_${selectedAlternative.title} for ${selectionManager.selectedSystem?.title}`}><br>
            <input class="w3-input" placeholder="Context" id="context" type="text" name="context" value={`The ${selectionManager.selectedSystem?.title} ...`}><br>
            <input class="w3-input" placeholder="Decision" id="decision" type="text" name="decision" value={`Accepted`}><br>
            <input class="w3-input" placeholder="Status" id="status" type="text" name="status" value={`We will implement ${selectedAlternative.title} to solve ${issue.title} to address the architectural requirements ${categorised.positive.map(influence => influence.architectureRequirement?.title).join(', ')}.`}><br>
            <input class="w3-input" placeholder="Consequence" id="consequences" type="text" name="consequences" value={`We accept that ${categorised.negative.map(influence => influence.architectureRequirement?.title).join(', ')} are neglected.`}><br>
        {/if}
        <button class="w3-button" type="submit">create</button>
    </form>
</div>
