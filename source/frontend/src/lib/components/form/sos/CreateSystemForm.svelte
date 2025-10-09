<script lang="ts">
  import { getContext } from "svelte";
  import { enhance } from "$app/forms";
  import { FormManager } from "$lib/domain/manager/FormManager.svelte.js";
  import { System } from "$lib/domain/entity/sos/System.svelte";
  import {
    getSystemOfSystems,
    getSystems,
  } from "$lib/utils/getSystemOfSystems";

  const formManager: FormManager = getContext("formManager");
  const cpsos: System[] = getContext("cpsos");

  let isChecked = $state(false);
</script>

<div class="">
  <h5>Create a new system:</h5>
  <form
    method="POST"
    action="actions/sos/systems?/createSystem"
    use:enhance={({ formData }) => {
      let system: System = System.create();

      system.id = crypto.randomUUID();
      formData.set("id", system.id);
      system.title = String(formData.get("title"));

      if (isChecked) {
        formData.set(
          "parentSystemClassId",
          String(formData.get("parentSystemId")),
        );
      }
      const isCyber = formData.get("isCyber") === "true";

      system.isCyber = isCyber;

      return async ({ result }) => {
        if (result) {
          if (isChecked) {
            const systemOfSystems = getSystemOfSystems(
              cpsos,
              String(formData.get("parentSystemId")),
            );
            systemOfSystems?.systemList.push(system);
          } else {
            cpsos.push(system);
          }
          console.log("System is created.");

          formManager.reset();
        }
      };
    }}
  >
    <input
      class="w3-input"
      placeholder="Title"
      id="title"
      type="text"
      name="title"
    /><br />

    <label for="isCyber">Type:</label>
    <select name="isCyber" id="isCyber">
      <option value="true">Cyber</option>
      <option value="false">Physical</option>
    </select><br />

    <label>
      <input
        type="checkbox"
        style="margin-right:5px"
        bind:checked={isChecked}
      />
      part of
    </label><br />

    {#if isChecked}
      <select class="w3-input" name="parentSystemId" id="parentSystemId">
        {#each getSystems(cpsos) as system}
          <option value={system.id}>{system.title}</option>
        {/each}
      </select><br />
    {/if}

    <button class="w3-button w3-border" style="margin-top: 20px" type="submit"
      >create</button
    >
  </form>
</div>
