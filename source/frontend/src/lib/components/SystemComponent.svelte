<script lang="ts">
  import { FormManager } from "$lib/domain/manager/FormManager.svelte.js";
  import { getContext } from "svelte";
  import { SelectionManager } from "$lib/domain/manager/SelectionManager.svelte.js";
  import { System } from "$lib/domain/entity/sos/System.svelte";

  let { system }: { system: System } = $props();

  const formManager: FormManager = getContext("formManager");
  const selectionManager: SelectionManager = getContext("selectionManager");
</script>

<p>
  System
  <button
    class="w3-button w3-border-bottom"
    onclick={() => {
      selectionManager.selectedSystem = system;
      formManager.toggle("updateSystem");
    }}
  >
    {system.title}
  </button>
  <span
    class="w3-round-xlarge {system.isCyber ? 'w3-green' : 'w3-red'}"
    style="padding-right: 8px; padding-left: 8px;"
    >{system.isCyber ? "Cyber" : "Physical"}</span
  >
</p>
