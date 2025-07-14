<script lang="ts">

    const data = $props();

</script>

<div>

    {#if alternative.get}


    {#if alternative.getRanked(constraint, nfr) > 0}
        <input type="radio" name="alternativeId" id={alternative.alternative.id} class="option w3-border-green" value={alternative.alternative.id} required>
        <label for={alternative.alternative.id} class="w3-center option-label tooltip w3-border-green"><span class="tooltiptext">Force:
                        <br><br>
        {#each alternative.forcedBy as forcedBy}
           <p>{forcedBy.architectureRequirement.value.title} ({forcedBy.impact})</p>
        {/each}
        </span>{alternative.alternative.title}</label>
    {/if}
</div>
