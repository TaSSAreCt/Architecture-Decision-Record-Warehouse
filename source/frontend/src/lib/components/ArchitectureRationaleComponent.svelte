<script lang="ts">
    import {ArchitectureRationale} from "$lib/domain/entity/ad/Rationale.svelte.js";

    const architectureRationale = $props();

</script>

<div>
    <p>Title: {architectureRationale.title}</p>
    <p>Context: {architectureRationale.context}</p>
    <p>Decision: {architectureRationale.decision}</p>
    <p>Status: {architectureRationale.status}</p>
    <p>Consequences: {architectureRationale.consequences}</p>
</div>