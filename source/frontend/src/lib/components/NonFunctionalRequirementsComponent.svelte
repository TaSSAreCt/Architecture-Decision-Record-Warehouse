<script lang="ts">
  import { NonFunctionalRequirement } from "$lib/domain/entity/ar/NonFunctionalRequirement.svelte.js";
  import { System } from "$lib/domain/entity/sos/System.svelte";
  import TagComponent from "./TagComponent.svelte";

  const {
    system,
    nonFunctionalRequirements,
  }: { system: System; nonFunctionalRequirements: NonFunctionalRequirement[] } =
    $props();
</script>

<div>
  <p>
    {system.title} requires {#each nonFunctionalRequirements as nonFunctionalRequirement}{nonFunctionalRequirement.title}
      <TagComponent isCyber={nonFunctionalRequirement.isCyber} />,{/each}
  </p>
</div>
