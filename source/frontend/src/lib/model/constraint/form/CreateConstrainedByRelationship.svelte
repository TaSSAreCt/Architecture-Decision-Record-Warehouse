<script lang="ts">
  import { getContext } from "svelte";
  import { ArchitecturalKnowledge } from "$lib/domain/aggregate/ArchitecturalKnowledge.svelte";
  import { Constraint } from "$lib/domain/entity/ar/Constraint.svelte";
  import { SystemElement } from "$lib/domain/entity/sos/SystemElement.svelte";

  let { systemElement }: { systemElement: SystemElement } = $props();

  const architecturalKnowledge: ArchitecturalKnowledge = getContext(
    "architecturalKnowledge",
  );
</script>

<div id="">
  <form
    method="POST"
    action="actions/relationship?/constrainedByConstraint"
    use:enhance={({ formData }) => {
      // set element id
      formData.set("systemElementID", systemElement.id);
      const constraintID = String(formData.get("constraintID"));
      return async ({ result }) => {
        if (result) {
          const constraint =
            architecturalKnowledge.architecturalRequirements.constraintList.find(
              (constraint) => constraint.id === constraintID,
            ) ?? Constraint.create();
          selectionManager.selectedSystemElement.constraintList.push(
            constraint,
          );
        }
      };
    }}
  >
    <div class="w3-row">
      <!-- Submit button -->
      <div class="w3-third">
        <button class="w3-button w3-border" type="submit">constrained by</button
        >
      </div>

      <!-- Select constraint -->
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
