<script lang="ts">
    import { enhance } from "$app/forms";
    import {Issue} from "$lib/domain/entity/ad/Issue.svelte";
    import {ArchitectureDecision} from "$lib/domain/aggregate/ArchitectureDecision.svelte";
    import {getContext} from "svelte";
    import {ArchitecturalKnowledge} from "$lib/domain/aggregate/ArchitecturalKnowledge.svelte";
    import {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte";

    const architecturalKnowledge : ArchitecturalKnowledge = getContext('architecturalKnowledge');
    const selectionManager : SelectionManager = getContext('selectionManager');

    const architectureDecision : ArchitectureDecision = ArchitectureDecision.create();

</script>

<div class="">
    <form id="issueForm" method="POST" action="actions/ad/issue?/createIssue" use:enhance={({formData}) => {
        const issue : Issue = Issue.create();

        issue.id = crypto.randomUUID();
        formData.set("id", issue.id);
        issue.title = String(formData.get("title"));

        architectureDecision.issue = issue;

        return async ({result}) => {
            if (result) {
                console.log("Issue is created.");
                document.getElementById("issueForm").reset();
                selectionManager.selectedArchitecturalDecision = architectureDecision;
                architecturalKnowledge.architecturalDecisions.push(architectureDecision);

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

</div>
