<script lang="ts">
    import {getContext, onMount} from 'svelte';
    import type {System} from "$lib/domain/entity/sos/System.svelte";
    import {getSystems} from "$lib/utils/getSystemOfSystems";

    const cpsos : System[] = getContext('cpsos');

    let data = $derived.by(() => {

        let result = {
            openIssues: 0,
            architectureDecisionRecords: 0
        }


        getSystems(cpsos).forEach(childCpsos => {

            result.openIssues += childCpsos.getOpenIssues().length
            result.architectureDecisionRecords += childCpsos.rationaleList.length;

        });

        return result;
    });

    let canvas : HTMLCanvasElement;
    let chart;

    onMount(async () => {

        const ctx = canvas.getContext('2d');

        chart = new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: [
                    'Open Issue',
                    'Architectural Decision Records',
                ],
                datasets: [{
                    label: 'Relation raised Issues vs ADRs',
                    data: [data.openIssues, data.architectureDecisionRecords],
                    backgroundColor: [
                        'rgb(255, 99, 132)',
                        'rgb(75, 192, 192)'
                    ],
                    hoverOffset: 4
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false
            }
        });

        return () => chart.destroy();
    });

    $effect(() => {

        chart.data.datasets[0].data[0] = data.openIssues;
        chart.data.datasets[0].data[1] = data.architectureDecisionRecords;
        chart.update()

    });

</script>

<div class="chart-container">
    <canvas bind:this={canvas}></canvas>
</div>

<style>
    .chart-container {
        width: 100%;
        height: 400px;
        position: relative;
    }
</style>
