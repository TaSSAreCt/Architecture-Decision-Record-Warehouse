<script lang="ts">
  import { getContext } from "svelte";
  import { ArchitecturalKnowledge } from "$lib/domain/aggregate/ArchitecturalKnowledge.svelte";
  import { ArchitectureRequirement } from "$lib/domain/entity/ar/ArchitectureRequirement.svelte";
  import { enhance } from "$app/forms";
  import { Influence } from "$lib/domain/entity/ad/Influence.svelte";
  import type { FormManager } from "$lib/domain/manager/FormManager.svelte";

  const architecturalKnowledge: ArchitecturalKnowledge = getContext(
    "architecturalKnowledge",
  );
  const formManager: FormManager = getContext("formManager");

  let architectureRequirementFlatMap: ArchitectureRequirement[] = [
    ...architecturalKnowledge.architecturalRequirements
      .nonFunctionalRequirementList,
    ...architecturalKnowledge.architecturalRequirements.intentionList,
    ...architecturalKnowledge.architecturalRequirements
      .architecturePrincipleList,
    ...architecturalKnowledge.architecturalRequirements.constraintList,
  ];
</script>

<div>
  <h5>Update architectural knowledge:</h5>

  <form
    method="post"
    action="actions/akm?/createInfluence"
    use:enhance={({ formData, formElement }) => {
      const id = crypto.randomUUID();
      formData.set("id", id);

      const influence: Influence = Influence.create();

      influence.value = Number(formData.get("value"));
      influence.id = id;
      influence.architectureRequirement = architectureRequirementFlatMap.find(
        (architectureRequirement) =>
          architectureRequirement.id ===
          String(formData.get("architectureRequirementId")),
      );

      return async ({ result }) => {
        architecturalKnowledge.issueList
          .flatMap((issue) => issue.alternativeList)
          .forEach((alternative) => {
            if (alternative.id === String(formData.get("alternativeId"))) {
              alternative.influenceList.push(influence);
            }
          });
        formElement.reset();
        formManager.reset();
      };
    }}
  >
    <div class="w3-row">
      <div class="w3-half">
        <h6>Architecture requirement</h6>
      </div>

      <div class="w3-half">
        <select
          class="w3-input"
          name="architectureRequirementId"
          id="architectureRequirementId"
          required
        >
          {#each architectureRequirementFlatMap as architectureRequirement}
            <option value={architectureRequirement.id}
              >{architectureRequirement.title}
            </option>
          {/each}
        </select><br />
      </div>
    </div>

    <div class="w3-row">
      <div class="w3-half">
        <select class="w3-input" name="value" id="value">
          <option value="1">positively</option>
          <option value="0">neutrally</option>
          <option value="-1">negatively</option>
        </select>
      </div>

      <div class="w3-half">
        <h6 class="w3-margin-left">influences</h6>
        <br />
      </div>
    </div>

    <div class="w3-row">
      <div class="w3-half">
        <h6>Alternative</h6>
      </div>

      <div class="w3-half">
        <select
          class="w3-input"
          name="alternativeId"
          id="alternativeId"
          required
        >
          {#each architecturalKnowledge.issueList.flatMap((issue) => issue.alternativeList) as alternative}
            <option value={alternative.id}>{alternative.title}</option>
          {/each}
        </select><br />
      </div>
    </div>
    <!--<input id="value" name="value" type="number" min="-1" max="1" step="0.1" /><br>-->

    <button class="w3-button w3-border" style="margin-top: 20px;" type="submit"
      >create</button
    >
  </form>
</div>
