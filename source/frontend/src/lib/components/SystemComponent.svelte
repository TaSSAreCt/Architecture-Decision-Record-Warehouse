<script lang="ts">
    import {FormManager} from "$lib/domain/manager/FormManager.svelte.js";
    import {getContext} from "svelte";
    import {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte.js";
    import {SystemOfSystems} from "$lib/domain/aggregate/SystemOfSystems.svelte";

    let {systemOfSystems} : { systemOfSystems:SystemOfSystems } = $props();

    const formManager : FormManager = getContext("formManager");
    const selectionManager : SelectionManager = getContext("selectionManager");

</script>
<p>
    System
    <button class="w3-button w3-border-bottom" onclick={() => {
        selectionManager.selectedSystemOfSystems = systemOfSystems;
        formManager.toggle("updateSystem");
    }}>
        {systemOfSystems.system.title}
    </button>

</p>