<script lang="ts">
  import { getContext } from "svelte";
  import { enhance } from "$app/forms";
  import { ArchitecturalRequirements } from "$lib/domain/entity/ar/ArchitecturalRequirements.svelte.js";
  import { Constraint } from "$lib/domain/entity/ar/Constraint.svelte";
  import type { SelectionManager } from "$lib/domain/manager/SelectionManager.svelte";
  import type { ArchitecturalKnowledge } from "$lib/domain/aggregate/ArchitecturalKnowledge.svelte";
  import TagComponent from "$lib/components/TagComponent.svelte";

  const selectionManager: SelectionManager = getContext("selectionManager");
  const architecturalKnowledge: ArchitecturalKnowledge = getContext(
    "architecturalKnowledge",
  );
</script>

<div>
  <h2>
    <u>{selectionManager.selectedSystemElement.title}</u>
    <TagComponent isCyber={selectionManager.selectedSystemElement?.isCyber} />
  </h2>
  <hr />

  <h4>Constraints:</h4>

  {#each selectionManager.selectedSystemElement.constraintList as constraint}
    <p>{constraint.title} <TagComponent isCyber={constraint.isCyber} /></p>
  {/each}
  <hr />

  <div>
    <h4>Actions:</h4>

    <div id="">
      <form
        method="POST"
        action="actions/ar/constraint?/constrainedByConstraint"
        use:enhance={({ formData }) => {
          formData.set(
            "systemElementId",
            selectionManager.selectedSystemElement.id,
          );

          return async ({ result }) => {
            if (result) {
              const constraint =
                architecturalKnowledge.architecturalRequirements.constraintList.find(
                  (constraint) =>
                    constraint.id === String(formData.get("constrainedId")),
                ) ?? Constraint.create();
              selectionManager.selectedSystemElement.constraintList.push(
                constraint,
              );
            }
          };
        }}
      >
        <div class="w3-row">
          <div class="w3-third">
            <button class="w3-button w3-border" type="submit"
              >constrained by</button
            >
          </div>

          <div class="w3-twothird">
            <select class="w3-input" name="constrainedId" id="constrainedId">
              {#each architecturalKnowledge.architecturalRequirements.constraintList as constraint}
                {#if !selectionManager.selectedSystemElement.constraintList.some((item) => item.id === constraint.id)}
                  <option value={constraint.id}
                    >{constraint.title} (<TagComponent
                      isCyber={constraint.isCyber}
                    />)</option
                  >
                {/if}
              {/each}
            </select>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
