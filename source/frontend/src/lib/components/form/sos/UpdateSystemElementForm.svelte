<script lang="ts">
    import {getContext} from "svelte";
    import { enhance } from "$app/forms";
    import {ArchitecturalRequirements} from "$lib/domain/aggregate/ArchitecturalRequirements.svelte";
    import {Constraint} from "$lib/domain/entity/ar/Constraint.svelte";
    import type {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte";

    const selectionManager : SelectionManager = getContext('selectionManager');
    const architecturalRequirements : ArchitecturalRequirements = getContext('architecturalRequirements');

</script>

<div>

    <h2><u>{selectionManager.selectedSystemElementAggregate.title}</u></h2>
    <hr>

    <h4>Constraints:</h4>

    {#each selectionManager.selectedSystemElementAggregate.constraints as constraint}
        <p>{constraint.title}</p>
    {/each}
    <hr>

    <div>
        <h4>Actions:</h4>

        <div id="">

            <form method="POST" action="actions/ar/constraint?/constrainedByConstraint" use:enhance={({ formData }) => {

                formData.set("systemElementId", selectionManager.selectedSystemElementAggregate.id);

                return async ({ result }) => {
                    if (result) {

                        const constraint = architecturalRequirements.constraints.find(constraint => constraint.id === String(formData.get('constrainedId'))) ?? Constraint.create();
                        selectionManager.selectedSystemElementAggregate.constraints.push(constraint);
                    }
                };
            }}>

                <div class="w3-row">

                    <div class="w3-third">
                        <button class="w3-button w3-border" type="submit">constrained by</button>
                    </div>

                    <div class="w3-twothird">

                        <select class="w3-input" name="constrainedId" id="constrainedId">

                            {#each architecturalRequirements.constraints as constraint}
                                {#if !selectionManager.selectedSystemElementAggregate.constraints.some(item => item.id === constraint.id)}
                                    <option value={constraint.id}>{constraint.title}</option>
                                {/if}
                            {/each}
                        </select>

                    </div>

                </div>

            </form>

        </div>

    </div>

</div>
