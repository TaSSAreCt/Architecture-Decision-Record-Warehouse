<script lang="ts">

    import {getContext} from "svelte";
    import type {AiResponseType} from "$lib/agent/ai-response.svelte";

    const aiResponse : AiResponseType = getContext("aiResponse");


</script>

<div class="">

    {#if aiResponse }
        {#each aiResponse.issueList as issue}
            <p>{issue.title}</p>

            {#each issue.alternativeList as alternative}
                <p>{alternative.title}</p>
            {/each}
        {/each}
    {/if}

</div>
