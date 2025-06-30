<script lang="ts">

    import ImpactMetricComponent from "$lib/components/metrics/ImpactMetricComponent.svelte";
    import CountMetricComponent from "$lib/components/metrics/CountMetricComponent.svelte";
    import OpenIssuesMetricComponent from "$lib/components/metrics/OpenIssuesMetricComponent.svelte";
</script>

<div class="w3-row">
    <div class="w3-third">
        <div class="w3-margin w3-border">
            <CountMetricComponent />
        </div>
    </div>

    <div class="w3-third">
        <div class="w3-margin w3-border">
            <OpenIssuesMetricComponent />
        </div>
    </div>

    <div class="w3-third">
        <div class="w3-margin w3-border">
            <ImpactMetricComponent />
        </div>

    </div>
</div>