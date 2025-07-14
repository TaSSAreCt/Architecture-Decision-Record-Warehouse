<script lang="ts">
    import { enhance } from "$app/forms";
    import {getContext} from "svelte";
    import {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte";
    import {Madr} from "$lib/domain/entity/ad/M-adr.svelte";

    const selectionManager : SelectionManager = getContext('selectionManager');

    const date = new Date();

    const rationale = Madr.create();

    rationale.title = `${date.getFullYear()}-${date.getMonth()}-${date.getDay()}_${selectionManager.selectedSystem?.title}`;
    rationale.context = ``;
    rationale.decision = ``;
    rationale.status = ``;
    rationale.consequences = ``;

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


        return async ({result}) => {
            /*
            const alternative : Alternative = issue.alternatives.find(item => item.alternative.id === String(formData.get('alternativeId'))) ?? AlternativeAggregate.create();
            alternative.architectureRationales.push(architectureRationale);
            console.log("Architecture Rationale is created.");
            */
        };
    }}>
        <div class="option-group">

            <!--

            {#each architectureDecision.alternatives as alternative}



                <p>
                    {#if alternative.getRanked(constraint, nfr) > 0}
                        <input type="radio" name="alternativeId" id={alternative.alternative.id} class="option w3-border-green" value={alternative.alternative.id} required>
                        <label for={alternative.alternative.id} class="w3-center option-label tooltip w3-border-green"><span class="tooltiptext">Force:<br>

                        {#each alternative.forcedBy as forcedBy}
                            {forcedBy.architectureRequirement.value.title} ({forcedBy.impact})<br>
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

            -->
        </div>

        <input class="w3-input" placeholder="Title" id="title" type="text" name="title" value={rationale.title}><br>
        <input class="w3-input" placeholder="Context" id="context" type="text" name="context" value={rationale.context}><br>
        <input class="w3-input" placeholder="Decision" id="decision" type="text" name="decision" value={rationale.decision}><br>
        <input class="w3-input" placeholder="Status" id="status" type="text" name="status" value={rationale.status}><br>
        <input class="w3-input" placeholder="Consequence" id="consequences" type="text" name="consequences" value={rationale.consequences}><br>

        <button class="w3-button" type="submit">justify</button>
    </form>
</div>
