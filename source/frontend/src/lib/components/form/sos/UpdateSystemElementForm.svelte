<script lang="ts">
  import { getContext } from "svelte";
  import { enhance } from "$app/forms";
  import type { SelectionManager } from "$lib/domain/manager/SelectionManager.svelte";
  import type { ArchitecturalKnowledge } from "$lib/domain/aggregate/ArchitecturalKnowledge.svelte";
  import TagComponent from "$lib/components/TagComponent.svelte";
  import CreateConstraintByRelationship from "$lib/model/constraint/form/CreateConstraintByRelationship.svelte";

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
    <CreateConstraintByRelationship />
  </div>
</div>
