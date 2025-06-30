<script lang="ts">
    import {getContext, onMount} from 'svelte';
    import {AdrWarehouse} from "$lib/domain/aggregate/AdrWarehouse.svelte.js";

    const adrWarehouse : AdrWarehouse = getContext('adrWarehouse');


    let data = $derived.by(() => {

        let result = {
            positive : 0,
            neutral : 0,
            negative : 0,
        }

        adrWarehouse.getSystems().forEach(sos => {
            sos.architecturalDecisions.forEach(ad => {
                if (ad.isJustified()) {

                    const { positive, negative } = ad.getRanking();

                    const alternative = ad.getSelectedAlternative();

                    if (positive !== undefined && alternative === positive.alternative) {
                        result.positive += 1;
                    } else if (negative !== undefined && alternative === negative.alternative) {
                        result.negative += 1;
                    } else {
                        result.neutral += 1;
                    }
                }
            });


        });

        return result;
    });

    let chart;
    let canvas : HTMLCanvasElement;

    onMount(async () => {

        const ctx = canvas.getContext('2d');

        chart = new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: [
                    'Positive',
                    'Neutral',
                    'Negative'
                ],
                datasets: [
                    {
                        label: 'My First Dataset',
                        data: [data.positive, data.neutral, data.negative],
                        backgroundColor: [
                            'rgb(75, 192, 192)',
                            'rgb(255, 205, 86)',
                            'rgb(255, 99, 132)'
                        ],
                        hoverOffset: 4
                    }
                ]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false
            }
        });

        return () => chart.destroy();
    });

    $effect(() => {
        chart.data.datasets[0].data[0] = data.positive;
        chart.data.datasets[0].data[1] = data.neutral;
        chart.data.datasets[0].data[2] = data.negative;
        chart.update();
    })

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
