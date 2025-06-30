<script lang="ts">

    import ArchitectureDecisionComponent from "$lib/components/ArchitectureDecisionComponent.svelte";
    import type {ArchitectureDecision} from "$lib/domain/aggregate/ArchitectureDecision.svelte";

    const { architecturalDecisions } : { architecturalDecisions : ArchitectureDecision[] } = $props();

</script>

<div>
    {#each architecturalDecisions as architectureDecision}
        <ArchitectureDecisionComponent architectureDecision={architectureDecision} />
    {/each}
</div>
