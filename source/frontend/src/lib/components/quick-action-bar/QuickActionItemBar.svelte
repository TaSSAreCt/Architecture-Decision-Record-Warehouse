<script lang="ts">
  import { getContext } from "svelte";
  import { FormManager } from "$lib/domain/manager/FormManager.svelte.js";

  const formManager: FormManager = getContext("formManager");

  let props = $props();
</script>

<div class="qab-tooltip">
  <button
    class="w3-button"
    onclick={() => {
      formManager.toggle(props.form);
    }}
    >{props.icon}
  </button>
  <span class="qab-tooltiptext">{props.tooltip}</span>
</div>

<style>
  .qab-tooltip {
    position: relative;
    display: inline-block;
  }

  .qab-tooltiptext {
    visibility: hidden;
    width: 240px;
    background-color: rgb(35, 115, 46);
    color: #ffffff;
    position: absolute;
    top: 10px;
    right: 105%;
    padding-left: 20px;
    padding-top: 10px;
    padding-bottom: 10px;
  }

  .qab-tooltip .qab-tooltiptext::after {
    content: "";
    position: absolute;
    top: 10px;
    right: 105%;
  }

  .qab-tooltip:hover .qab-tooltiptext {
    visibility: visible;
    opacity: 1;
  }
</style>

