<script lang="ts">

    import type {NonFunctionalRequirement} from "$lib/domain/entity/ar/NonFunctionalRequirement.svelte.js";

    const { nonFunctionalRequirement } : { nonFunctionalRequirement : NonFunctionalRequirement } = $props();

</script>

<div>
    <p>|... requires <button>{nonFunctionalRequirement.title}</button></p>
</div>