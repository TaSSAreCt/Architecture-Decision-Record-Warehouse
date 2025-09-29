<script lang="ts">
    import {getContext, onMount} from 'svelte';
    import {AdrWarehouse} from "$lib/domain/aggregate/AdrWarehouse.svelte.js";
    import type {System} from "$lib/domain/entity/sos/System.svelte";
    import {getSystems} from "$lib/utils/getSystemOfSystems";
    import type {Ranking} from "$lib/domain/entity/ad/Alternative.svelte";

    const cpsos : System[] = getContext('cpsos');

    let data = $derived.by(() => {

        let result = {
            positive : 0,
            neutral : 0,
            negative : 0,
        }


        getSystems(cpsos).forEach(childCpsos => {

            const justifiedAlternatives = childCpsos.issueList
                .flatMap(issue => issue.alternativeList)
                .filter(alt => childCpsos.rationaleList.some(r => r.justifies === alt.id));

            justifiedAlternatives.forEach(alternative => {
                let ranking : Ranking = alternative.getRanking(childCpsos.nonFunctionalRequirementList, childCpsos.systemElementList.flatMap(systemElement => systemElement.constraintList));

                if (ranking.value > 0) {
                    result.positive += 1;
                } else if (ranking.value === 0) {
                    result.neutral += 1;
                } else if (ranking.value < 0 ) {
                    result.negative += 1;
                }
            })

        });

        /*

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

         */

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
