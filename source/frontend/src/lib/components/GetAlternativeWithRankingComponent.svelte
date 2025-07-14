<script lang="ts">

</script>

{#if alternative.getRanked(constraint, nfr) > 0}
    <input type="radio" name="alternativeId" id={alternative.alternative.id} class="option w3-border-green" value={alternative.alternative.id} required>
    <label for={alternative.alternative.id} class="w3-center option-label tooltip w3-border-green"><span class="tooltiptext">Force:<br>

        {#each alternative.forcedBy as forcedBy}
                            {forcedBy.architectureRequirement.value.title} ({forcedBy.impact})<br>
                        {/each}

                    </span>{alternative.alternative.title}</label>
{/if}