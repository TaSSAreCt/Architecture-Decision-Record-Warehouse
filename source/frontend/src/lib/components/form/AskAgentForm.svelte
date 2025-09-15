<script lang="ts">

    import {getContext, onDestroy, onMount} from "svelte";
    import SearchBar from "$lib/components/search-bar/SearchBar.svelte";
    import {ArchitecturalKnowledge} from "$lib/domain/aggregate/ArchitecturalKnowledge.svelte";
    import { enhance } from "$app/forms";
    import {fromIssueListResponseDto} from "$lib/dto/response/entity/IssueResponseDto";
    import type {FormManager} from "$lib/domain/manager/FormManager.svelte";

    const architecturalKnowledge : ArchitecturalKnowledge = getContext("architecturalKnowledge");
    const formManager : FormManager = getContext("formManager");

    let importArchitecturalKnowledge : ArchitecturalKnowledge = $state<ArchitecturalKnowledge>(ArchitecturalKnowledge.create());

    onMount(() => {
        document.getElementById("div-forms").style.width = "1500px";
        document.getElementById("subdiv-forms").style.width = "1400px";
    });

    onDestroy(() => {
        document.getElementById("subdiv-forms").style.width = "500px";
    })

    let uploaded : boolean = $state<boolean>(false);
    let filename : string = $state<string>("");


    async function parseAiResponse(e: Event) {

        const file = (e.target as HTMLInputElement).files?.[0];

        if (file) {
            const text = await file.text();
            filename = file.name;
            const json = JSON.parse(text);

            importArchitecturalKnowledge.issueList = fromIssueListResponseDto(json);

            uploaded = true;
        }
    }

</script>

<div class="w3-container">

    {#if !uploaded}
         <input type="file" name="file" accept="application/json" onchange={parseAiResponse} />
    {:else}

        <form method="POST" action="actions/import?/architecturalKnowledge" use:enhance={({ formData }) => {

            formData.set("architecturalKnowledge", JSON.stringify(importArchitecturalKnowledge.toJson()));

             return async ({ result }) => {
                architecturalKnowledge.issueList.push(...importArchitecturalKnowledge.issueList);
                formManager.reset();
            }
        }}>
            <div class="">

                <!-- New rationale -->
                <div class="w3-row">
                    <h5>Import architectural decision record: {filename}</h5>
                </div>

                <!-- New issue -->

                {#each importArchitecturalKnowledge.issueList as issue, i}

                    <div class="w3-row w3-section">

                        <div class="w3-third">
                            Influence
                            <SearchBar index={i} id={issue.title + i} value={issue.title} list={architecturalKnowledge.issueList} bind:callback={importArchitecturalKnowledge.issueList} />
                            is solved by
                        </div>

                        <div class="w3-twothird">
                            <div class="w3-row">
                                {#each issue.alternativeList as alternative, index_alternative}
                                    <div class="w3-half">
                                        Alternative
                                        <SearchBar index={index_alternative} id={alternative.title + index_alternative} value={alternative.title} list={architecturalKnowledge.getAlternativesByIssue(importArchitecturalKnowledge.issueList[i].id)} callback={issue.alternativeList}/>
                                        is influenced by
                                    </div>

                                    <div class="w3-half">


                                        {#each alternative.influenceList as influence}
                                            <div style="margin-bottom: 20px">
                                                Architecture Requirement
                                                <SearchBar index={i} id={influence.architectureRequirement.title + i} value={influence.architectureRequirement.title} list={architecturalKnowledge.issueList} callback={issue}/>
                                                <select>
                                                    <option>Positive</option>
                                                    <option>Neutral</option>
                                                    <option>Negative</option>
                                                </select>
                                            </div>
                                        {/each}

                                    </div>
                                {/each}
                            </div>
                        </div>
                    </div>


                    <!-- Divider -->
                    <div class="" style="height: 2px; background-color: lightgray; width: 100%"></div>

                {/each}

                <button class="w3-button  w3-border-bottom" onclick={() => console.log("Import function")}>import</button>

            </div>
        </form>

    {/if}

</div>