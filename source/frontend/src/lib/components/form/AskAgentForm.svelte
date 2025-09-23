<script lang="ts">
  import { getContext, onDestroy, onMount } from "svelte";
  import SearchBar from "$lib/components/search-bar/SearchBar.svelte";
  import { ArchitecturalKnowledge } from "$lib/domain/aggregate/ArchitecturalKnowledge.svelte";
  import { enhance } from "$app/forms";
  import { fromIssueListResponseDto } from "$lib/dto/response/entity/IssueResponseDto";
  import { FormManager } from "$lib/domain/manager/FormManager.svelte";

  // Initialise architecturalKnowledge
  const architecturalKnowledge: ArchitecturalKnowledge = getContext(
    "architecturalKnowledge",
  );

  // Initialise FormManager
  const formManager: FormManager = getContext("formManager");

  // initialise architectural knowledge object to map import data to internal structure
  let importArchitecturalKnowledge: ArchitecturalKnowledge =
    $state<ArchitecturalKnowledge>(ArchitecturalKnowledge.create());

  onMount(() => {
    // increase default width
    const div = document.getElementById("div-forms");
    const subDiv = document.getElementById("subdiv-forms");

    if (div !== null && subDiv !== null) {
      div.style.width = "1500px";
      subDiv.style.width = "1400px";
    }
  });

  onDestroy(() => {
    // decrease default width
    const subDiv = document.getElementById("subdiv-forms");
    if (subDiv !== null) {
      subDiv.style.width = "500px";
    }
  });

  let uploaded: boolean = $state<boolean>(false);
  let filename: string = $state<string>("");

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
    <input
      type="file"
      name="file"
      accept="application/json"
      onchange={parseAiResponse}
    />
  {:else}
    <form
      method="POST"
      action="actions/import?/architecturalKnowledge"
      use:enhance={({ formData }) => {
        formData.set(
          "architecturalKnowledge",
          JSON.stringify(importArchitecturalKnowledge.toJson()),
        );

        return async ({ result }) => {
          architecturalKnowledge.issueList.push(
            ...importArchitecturalKnowledge.issueList,
          );
          formManager.reset();
        };
      }}
    >
      <div class="">
        <!-- New rationale -->
        <div class="w3-row">
          <h5>Import architectural decision record: {filename}</h5>
        </div>

<<<<<<< HEAD
        <!-- New issue -->
=======
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
                            Issue
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
                                                    <option selected={influence.value > 0}>Positive</option>
                                                    <option selected={influence.value === 0}>Neutral</option>
                                                    <option selected={influence.value < 0}>Negative</option>
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
>>>>>>> a94e8c1a403a9065ca783ec9e32815e4d351c5d2

        {#each importArchitecturalKnowledge.issueList as issue, i}
          <div class="w3-row w3-section">
            <div class="w3-third">
              Influence
              <SearchBar
                index={i}
                id={issue.title + i}
                value={issue.title}
                list={architecturalKnowledge.issueList}
                bind:callback={importArchitecturalKnowledge.issueList}
              />
              is solved by
            </div>

            <div class="w3-twothird">
              <div class="w3-row">
                {#each issue.alternativeList as alternative, index_alternative}
                  <div class="w3-half">
                    Alternative
                    <SearchBar
                      index={index_alternative}
                      id={alternative.title + index_alternative}
                      value={alternative.title}
                      list={architecturalKnowledge.getAlternativesByIssue(
                        importArchitecturalKnowledge.issueList[i].id,
                      )}
                      callback={issue.alternativeList}
                    />
                    is influenced by
                  </div>

                  <div class="w3-half">
                    {#each alternative.influenceList as influence}
                      <div style="margin-bottom: 20px">
                        Architecture Requirement
                        <SearchBar
                          index={i}
                          id={influence.architectureRequirement.title + i}
                          value={influence.architectureRequirement.title}
                          list={architecturalKnowledge.issueList}
                          callback={issue}
                        />
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
          <div
            class=""
            style="height: 2px; background-color: lightgray; width: 100%"
          ></div>
        {/each}

        <button
          class="w3-button w3-border-bottom"
          onclick={() => console.log("Import function")}>import</button
        >
      </div>
    </form>
  {/if}
</div>
