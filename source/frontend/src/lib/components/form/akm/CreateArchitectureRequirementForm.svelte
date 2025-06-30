<script lang="ts">

    import {AlternativeAggregate} from "$lib/domain/aggregate/AlternativeAggregate.svelte";
    import {Constraint} from "$lib/domain/entity/ar/Constraint.svelte";
    import {Intention} from "$lib/domain/entity/ar/Intention.svelte";
    import {NonFunctionalRequirement} from "$lib/domain/entity/ar/NonFunctionalRequirement.svelte";
    import {ArchitecturePrinciple} from "$lib/domain/entity/ar/ArchitecturePrinciple.svelte";
    import {ForcedBy} from "$lib/domain/aggregate/ForcedBy.svelte";
    import {enhance} from "$app/forms";
    import {getContext} from "svelte";
    import {ArchitecturalRequirements} from "$lib/domain/aggregate/ArchitecturalRequirements.svelte.js";

    const { alternativeAggregate } : { alternativeAggregate : AlternativeAggregate } = $props();

    const architecturalRequirements : ArchitecturalRequirements = getContext('architecturalRequirements');


</script>

<div>

    <!-- Architectural Requirements -->
    <h6>Add architectural requirement:</h6>

    <form id="architectureRequirement" method="POST" action="actions/akm?/createArchitectureRequirement" use:enhance={({formData}) => {

        const id = crypto.randomUUID();
        formData.set("id", id);
        formData.set("alternativeId", alternativeAggregate.alternative.id)

        const value = formData.get("impact");
        const architectureRequirementType = String(formData.get("architectureRequirementType"));
        const title = formData.get("title");

         let architectureRequirement;

         if (architectureRequirementType === "constraint") {
            architectureRequirement = Constraint.create();

            architectureRequirement.id = id;
            architectureRequirement.title = title;
            architecturalRequirements.constraints.push(architectureRequirement);

         } else if (architectureRequirementType === "intention") {
            architectureRequirement = Intention.create();
            architectureRequirement.id = id;
            architectureRequirement.title = title;
            architecturalRequirements.intentions.push(architectureRequirement);

         } else if (architectureRequirementType === "architecturePrinciple") {
            architectureRequirement = ArchitecturePrinciple.create();
            architectureRequirement.id = id;
            architectureRequirement.title = title;
            architecturalRequirements.architecturalPrinciples.push(architectureRequirement);

         } else {
            architectureRequirement = NonFunctionalRequirement.create();
            architectureRequirement.id = id;
            architectureRequirement.title = title;
            architecturalRequirements.nonFunctionalRequirements.push(architectureRequirement);
         }

         return async ({result}) => {
            if (result) {
                console.log("Architecture requirement is created.");
                document.getElementById("architectureRequirement").reset();

                alternativeAggregate.forcedBy.push(ForcedBy.create({
                    value: architectureRequirement,
                    type: architectureRequirementType
                 }, value));

            }
        }

    }}>
        <div>
            <select class="w3-input w3-margin-top" name="architectureRequirementType" id ="architectureRequirementType">
                <option value="constraint">Constraint</option>
                <option value="intention">Intention</option>
                <option value="architecturePrinciple">Architecture Principle</option>
                <option value="nonFunctionalRequirement">Non-Functional Requirement</option>
            </select><br>
        </div>

        <div class="w3-row">
            <div class="w3-left w3-center" style="width: 100px;">
                <p style=" margin-bottom: 0px; margin-top: 10px;">Impact:</p>
            </div>

            <div class="w3-rest">
                <input type="number" class="w3-input" name="impact" id="impact" value="0" min="-1" max="1" step="0.1">
            </div>
        </div>

        <div class="w3-row">

            <div class="w3-section">
                <div class="w3-left" style="width: 400px">
                    <div class="w3-left" style="width: 400px;">

                        <input list="architectureRequirementList" class="w3-input" placeholder="Architecture requirement title" id="title" type="text" name="title"><br>

                        <datalist id="architectureRequirementList">

                            {#each architecturalRequirements.constraints as constraint}
                                <option value={constraint.title}></option>
                            {/each}

                            {#each architecturalRequirements.intentions as intention}
                                <option value={intention.title}></option>
                            {/each}

                            {#each architecturalRequirements.architecturalPrinciples as architecturePrinciple}
                                <option value={architecturePrinciple.title}></option>
                            {/each}

                            {#each architecturalRequirements.nonFunctionalRequirements as nfr}
                                <option value={nfr.title}></option>
                            {/each}
                        </datalist>
                    </div>
                </div>

                <div class="w3-rest">
                    <button class="w3-button w3-border" style="margin-left: 20px" type="submit">+</button>
                </div>
            </div>

        </div>

    </form>

    {#if alternativeAggregate.forcedBy.length !== 0}
        <div class="w3-border w3-border-green">
            {#each alternativeAggregate.forcedBy as force}
                <p style="padding-left: 20px"> + {force.architectureRequirement.value.title}</p>
            {/each}
        </div>

        <hr style="height:1px;border:none;color:#333;background-color:#333;">

    {/if}

</div>