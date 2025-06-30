<script lang="ts">
    import type {Settings} from "$lib/domain/manager/SelectionManager.svelte.js";
    import {getContext} from "svelte";

    const settings : Settings = getContext("settings");

</script>

<div>
    <p>{settings.selectedArchitecturalDecision.issue.title}</p>
    <hr>
    {#each settings.selectedArchitecturalDecision.alternatives as alternative}
        <p>{alternative.alternative.title}</p>
    {/each}
</div>