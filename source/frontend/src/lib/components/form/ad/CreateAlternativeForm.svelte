<script lang="ts">
    import {getContext} from "svelte";
    import { enhance } from "$app/forms";
    import {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte";
    import {AlternativeAggregate} from "$lib/domain/aggregate/AlternativeAggregate.svelte";

    const selectionManager : SelectionManager = getContext('selectionManager');
</script>

<div class="">
    <form id="alternativeForm" method="POST" action="actions/ad/alternative?/createAlternativeWithIssue" use:enhance={({formData}) => {
        const alternative : AlternativeAggregate = AlternativeAggregate.create();

        alternative.alternative.id = crypto.randomUUID();
        formData.set("id", alternative.alternative.id);
        alternative.alternative.title = String(formData.get("title"));
        formData.set("issueId", selectionManager.selectedArchitecturalDecision.issue.id);

        return async ({result}) => {
            if (result) {
                console.log("Alternative is created.");
                document.getElementById("alternativeForm").reset();
                selectionManager.selectedArchitecturalDecision.alternatives.push(alternative);
            }
        }

    }}>
        <div class="w3-row">

            <div class="w3-left" style="width: 400px">
                <input class="w3-input" placeholder="Alternative title" id="title" type="text" name="title"><br>
            </div>

            <div class="w3-rest">
                <button class="w3-button w3-border" style="margin-left: 20px" type="submit">+</button>
            </div>
        </div>

    </form>

</div>
