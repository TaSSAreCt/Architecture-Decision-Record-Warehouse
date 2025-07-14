<script lang="ts">

    import ArchitectureDecisionComponent from "$lib/components/ArchitectureDecisionComponent.svelte";
    import {Issue} from "$lib/domain/entity/ad/Issue.svelte";

    const { issueList } : { issueList : Issue[] } = $props();

</script>

<div>
    {#each issueList as issue}
        <ArchitectureDecisionComponent issue={issue} />
    {/each}
</div>
