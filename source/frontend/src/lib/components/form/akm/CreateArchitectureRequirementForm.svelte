<script lang="ts">

    import {Constraint} from "$lib/domain/entity/ar/Constraint.svelte";
    import {Intention} from "$lib/domain/entity/ar/Intention.svelte";
    import {NonFunctionalRequirement} from "$lib/domain/entity/ar/NonFunctionalRequirement.svelte";
    import {ArchitecturePrinciple} from "$lib/domain/entity/ar/ArchitecturePrinciple.svelte";
    import {enhance} from "$app/forms";
    import {getContext} from "svelte";
    import {ArchitecturalRequirements} from "$lib/domain/entity/ar/ArchitecturalRequirements.svelte.js";
    import {Alternative} from "$lib/domain/entity/ad/Alternative.svelte";
    import {Influence} from "$lib/domain/entity/ad/Influence.svelte";

    const { alternative } : { alternative : Alternative } = $props();

    const architecturalRequirements : ArchitecturalRequirements = getContext('architecturalRequirements');


</script>

<div>

    <!-- Architectural Requirements -->
    <h6>Add architectural requirement:</h6>

    <form id="architectureRequirement" method="POST" action="actions/akm?/createArchitectureRequirement" use:enhance={({formData}) => {

        const id = crypto.randomUUID();
        formData.set("id", id);

        if (alternative.id) {
            formData.set("alternative", alternative.id);
        }

        const value = formData.get("impact");
        const architectureRequirementType = String(formData.get("architectureRequirementType"));
        const title = String(formData.get("title"));

         let architectureRequirement;

         if (architectureRequirementType === "constraint") {
            architectureRequirement = Constraint.create();

            architectureRequirement.id = id;
            architectureRequirement.title = title;
            architecturalRequirements.constraintList.push(architectureRequirement);

         } else if (architectureRequirementType === "intention") {
            architectureRequirement = Intention.create();
            architectureRequirement.id = id;
            architectureRequirement.title = title;
            architecturalRequirements.intentionList.push(architectureRequirement);

         } else if (architectureRequirementType === "architecturePrinciple") {
            architectureRequirement = ArchitecturePrinciple.create();
            architectureRequirement.id = id;
            architectureRequirement.title = title;
            architecturalRequirements.architecturePrincipleList.push(architectureRequirement);

         } else {
            architectureRequirement = NonFunctionalRequirement.create();
            architectureRequirement.id = id;
            architectureRequirement.title = title;
            architecturalRequirements.nonFunctionalRequirementList.push(architectureRequirement);
         }

         return async ({result}) => {
            if (result) {
                console.log("Architecture requirement is created.");

                const influence : Influence = Influence.create();

                alternative.influenceList.push(Influence.create());

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

                        <input list="architectureRequirementList" class="w3-input" placeholder="Architecture requirement title" id="title" type="text" name="title" required><br>

                        <datalist id="architectureRequirementList">

                            {#each architecturalRequirements.constraintList as constraint}
                                <option value={constraint.title}></option>
                            {/each}

                            {#each architecturalRequirements.intentionList as intention}
                                <option value={intention.title}></option>
                            {/each}

                            {#each architecturalRequirements.architecturePrincipleList as architecturePrinciple}
                                <option value={architecturePrinciple.title}></option>
                            {/each}

                            {#each architecturalRequirements.nonFunctionalRequirementList as nfr}
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
    <!--
    {#if alternative.influenceList.length !== 0}
        <div class="w3-border w3-border-green">
            {#each alternative.influenceList as influence}
                <p style="padding-left: 20px"> + {influence.architectureRequirement.value.title}</p>
            {/each}
        </div>

        <hr style="height:1px;border:none;color:#333;background-color:#333;">

    {/if}
    -->
</div>