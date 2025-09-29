<script lang="ts">

    import {enhance} from "$app/forms";
    import {getContext} from "svelte";
    import type {ArchitecturalKnowledge} from "$lib/domain/aggregate/ArchitecturalKnowledge.svelte";
    import {ArchitectureRequirement} from "$lib/domain/entity/ar/ArchitectureRequirement.svelte";

    const architecturalKnowledge : ArchitecturalKnowledge = getContext('architecturalKnowledge');

    let selectedType: "nonFunctionalRequirement" | "constraint" | "intention" | "architecturePrinciple" | undefined;

</script>

<div>

    <!-- Architectural Requirements -->
    <h6>Create new architectural requirements:</h6>

    <form id="architectureRequirement" method="POST" action="actions/akm?/createArchitectureRequirement" use:enhance={({formData, formElement}) => {

        const id = crypto.randomUUID();
        formData.set("id", id);
        const title = String(formData.get("title"));

        let architectureRequirement = ArchitectureRequirement.create(id, title);
        architectureRequirement.type = selectedType;

         return async ({result}) => {
            if (result) {
                architecturalKnowledge.architecturalRequirements.add(architectureRequirement);
                console.log("Architecture requirement is created.");
                formElement.reset();

            }
        }

    }}>

        <div class="">
            <input type="text" class="w3-input" name="title" id="title" placeholder="Architecture Requirement Title" required>
        </div>

        <div>
            <select class="w3-input w3-margin-top" name="architectureRequirementType" id ="architectureRequirementType" bind:value={selectedType} required>
                <option value="constraint">Constraint</option>
                <option value="intention">Intention</option>
                <option value="architecturePrinciple">Architecture Principle</option>
                <option value="nonFunctionalRequirement">Non-Functional Requirement</option>
            </select><br>
        </div>

        <button class="w3-button w3-border" style="margin-top: 20px;" type="submit">create</button>
    </form>
</div>