<script lang="ts">

    import {SystemElement} from "$lib/domain/entity/sos/SystemElement.svelte";

    const { systemElement } : { systemElement : SystemElement } = $props();

</script>

<div class="">
    <p>
        {systemElement.title} is constrained by {#each systemElement.constraintList as constraint} {constraint.title}, {/each}
    </p>
</div>