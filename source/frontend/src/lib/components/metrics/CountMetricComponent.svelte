<script lang="ts">
    import {getContext, onMount, setContext} from 'svelte';
    import {System} from "$lib/domain/entity/sos/System.svelte";
    import {getSystems} from "$lib/utils/getSystemOfSystems";

    const cpsos : System[] = getContext('cpsos');

    let data = $derived.by(() => {

        const architectureRequirementIds = new Set<string>();
        const alternativeIds = new Set<string>();
        const rationaleIds = new Set<string>();

        let result = {
            countSystems: 0,
            countSystemElements: 0,
            countIssues: 0,
            countAlternatives: 0,
            countRationales: 0,
            countArchitecturalRequirements: 0
        }

        getSystems(cpsos).forEach(childCpsos => {
            result.countSystems += 1;
            result.countSystemElements += childCpsos.systemElementList.length;

            childCpsos.rationaleList.forEach(rationale => {
                rationaleIds.add(rationale.id);
            })

            childCpsos.issueList.forEach(issue => {
                result.countIssues += 1;

                issue.alternativeList.forEach(alternative => {
                    alternativeIds.add(alternative.id);

                   alternative.influenceList.forEach(influence => {
                       architectureRequirementIds.add(influence.architectureRequirement.id);
                   });

                });
            })

        });

        result.countRationales = rationaleIds.size;
        result.countAlternatives = alternativeIds.size;
        result.countArchitecturalRequirements = architectureRequirementIds.size;

        return result;
    });

    let canvas;
    let chart;

    onMount(async () => {

        const ctx = canvas.getContext('2d');

        chart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: [''],
                datasets: [
                    {
                        label: "Systems",
                        data: [data.countSystems],
                        backgroundColor: [
                            'rgb(255, 99, 132)',
                        ],
                        borderWidth: 1
                    },
                    {
                        label: "System Elements",
                        data: [data.countSystemElements],
                        backgroundColor: [
                            'rgb(54, 162, 235)',
                        ],
                        borderWidth: 1
                    },
                    {
                        label: 'Issues',
                        data: [data.countIssues],
                        backgroundColor: [
                            'rgb(255, 205, 86)',
                        ],
                        borderWidth: 1
                    },
                    {
                        label: "Alternatives",
                        data: [data.countAlternatives],
                        backgroundColor: [
                            'rgb(255, 99, 132)',
                        ],
                        borderWidth: 1
                    },
                    {
                        label: "Rationales",
                        data: [data.countRationales],
                        backgroundColor: [
                            'rgb(54, 162, 235)',
                        ],
                        borderWidth: 1
                    },
                    {
                        label: "Architectural Requirements",
                        data: [data.countArchitecturalRequirements],
                        backgroundColor: [
                            'rgb(255, 205, 86)',
                        ],
                        borderWidth: 1
                    }
                ]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
            }
        });

        return () => chart.destroy();
    });

    $effect(() => {
        chart.data.datasets[0].data[0] = data.countSystems;
        chart.data.datasets[1].data[0] = data.countSystemElements;
        chart.data.datasets[2].data[0] = data.countIssues;
        chart.data.datasets[3].data[0] = data.countAlternatives;
        chart.data.datasets[4].data[0] = data.countRationales;
        chart.data.datasets[5].data[0] = data.countArchitecturalRequirements;
        chart.update();
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
