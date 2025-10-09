<script lang="ts">
  import { getContext } from "svelte";
  import { FormManager } from "$lib/domain/manager/FormManager.svelte.js";
  import { SelectionManager } from "$lib/domain/manager/SelectionManager.svelte.js";
  import { SystemElement } from "$lib/domain/entity/sos/SystemElement.svelte";
  import SystemElementComponent from "$lib/components/SystemElementComponent.svelte";

  const { systemElementList }: { systemElementList: SystemElement[] } =
    $props();

  const formManager: FormManager = getContext("formManager");
  const selectionManager: SelectionManager = getContext("selectionManager");

  console.log(systemElementList);

  systemElementList.forEach((se) => {
    console.log(se.constraintList);
  });
</script>

<div>
  <p>
    System Elements:
    {#each systemElementList as item, index}
      <button
        class="w3-button w3-border-bottom"
        onclick={() => {
          selectionManager.selectedSystemElement = item;
          formManager.toggle("updateSystemElement");
        }}>{item.title}</button
      >
      <span
        class="w3-round-xlarge {item.isCyber ? 'w3-green' : 'w3-red'}"
        style="padding-right: 8px; padding-left: 8px;"
        >{item.isCyber ? "Cyber" : "Physical"}</span
      >
      {index < systemElementList.length - 1 ? ", " : ""}
    {/each}
  </p>

  {#each systemElementList as systemElement}
    {#if systemElement.constraintList.length !== 0}
      <SystemElementComponent {systemElement} />
    {/if}
  {/each}
</div>

