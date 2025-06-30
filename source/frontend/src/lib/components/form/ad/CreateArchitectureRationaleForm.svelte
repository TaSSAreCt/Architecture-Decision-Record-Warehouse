<script lang="ts">
    import { enhance } from "$app/forms";
    import {ArchitectureDecision} from "$lib/domain/aggregate/ArchitectureDecision.svelte";
    import {ArchitectureRationale} from "$lib/domain/entity/ad/ArchitectureRationale.svelte.js";
    import {AlternativeAggregate} from "$lib/domain/aggregate/AlternativeAggregate.svelte";
    import {getContext} from "svelte";
    import {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte";
    import {AdrWarehouse} from "$lib/domain/aggregate/AdrWarehouse.svelte";
    import type {Constraint} from "$lib/domain/entity/ar/Constraint.svelte.js";
    import type {NonFunctionalRequirement} from "$lib/domain/entity/ar/NonFunctionalRequirement.svelte";

    const { architectureDecision } : { architectureDecision : ArchitectureDecision } = $props();

    const selectionManager : SelectionManager = getContext('selectionManager');
    const adrWarehouse : AdrWarehouse = getContext('adrWarehouse');

    const constraint : Constraint[] = selectionManager.selectedSystemOfSystems.systemElementAggregates.flatMap(systemElement => systemElement.constraints);
    const nfr : NonFunctionalRequirement[] = selectionManager.selectedSystemOfSystems.nonFunctionalRequirements;

</script>

<div class="w3-border" style="">
    <form method="POST" action="actions/ad/architecture-rationale?/createArchitectureRationale" use:enhance={({ formData }) => {

        let architectureRationale : ArchitectureRationale = ArchitectureRationale.create();

        architectureRationale.id = crypto.randomUUID();
        formData.set('id', architectureRationale.id);
        formData.set('systemId', selectionManager.selectedSystemOfSystems.system.id);

        architectureRationale.title = String(formData.get('title'));
        architectureRationale.consequences = String(formData.get('consequences'));
        architectureRationale.context = String(formData.get('context'));
        architectureRationale.status = String(formData.get('status'));
        architectureRationale.decision = String(formData.get('decision'));


        return async ({result}) => {

            const alternative : AlternativeAggregate = architectureDecision.alternatives.find(item => item.alternative.id === String(formData.get('alternativeId'))) ?? AlternativeAggregate.create();
            alternative.architectureRationales.push(architectureRationale);
            console.log("Architecture Rationale is created.");

        };
    }}>
        <div class="option-group">

            {#each architectureDecision.alternatives as alternative}
                <p>
                    {#if alternative.getRanked(constraint, nfr) > 0}
                        <input type="radio" name="alternativeId" id={alternative.alternative.id} class="option w3-border-green" value={alternative.alternative.id} required>
                        <label for={alternative.alternative.id} class="w3-center option-label tooltip w3-border-green"><span class="tooltiptext">Force:
                        <br><br>
                            {#each alternative.forcedBy as forcedBy}
                            <p>{forcedBy.architectureRequirement.value.title} ({forcedBy.impact})</p>
                        {/each}
                    </span>{alternative.alternative.title}</label>
                    {/if}

                    {#if alternative.getRanked(constraint, nfr) === 0}
                        <input type="radio" name="alternativeId" id={alternative.alternative.id} class="option w3-border-orange" value={alternative.alternative.id} required>
                        <label for={alternative.alternative.id} class="w3-center option-label tooltip w3-border-orange"><span class="tooltiptext">Forces:
                        <br><br>
                            {#each alternative.forcedBy as forcedBy}
                            <p>{forcedBy.architectureRequirement.value.title} ({forcedBy.impact})</p>
                        {/each}
                    </span>{alternative.alternative.title}</label>
                    {/if}

                    {#if alternative.getRanked(constraint, nfr) < 0}
                        <input type="radio" name="alternativeId" id={alternative.alternative.id} class="option w3-border-red" value={alternative.alternative.id} required>
                        <label for={alternative.alternative.id} class="w3-center option-label tooltip w3-border-red"><span class="tooltiptext">Forces:
                        <br><br>
                            {#each alternative.forcedBy as forcedBy}
                            <p>{forcedBy.architectureRequirement.value.title} ({forcedBy.impact})</p>
                        {/each}
                    </span>{alternative.alternative.title}</label>
                    {/if}
                </p>



            {/each}
        </div>

        <input class="w3-input" placeholder="Title" id="title" type="text" name="title"><br>
        <input class="w3-input" placeholder="Context" id="context" type="text" name="context"><br>
        <input class="w3-input" placeholder="Decision" id="decision" type="text" name="decision"><br>
        <input class="w3-input" placeholder="Status" id="status" type="text" name="status"><br>
        <input class="w3-input" placeholder="Consequences" id="consequences" type="text" name="consequences"><br>

        <button class="w3-button" type="submit">justify</button>
    </form>
</div>
