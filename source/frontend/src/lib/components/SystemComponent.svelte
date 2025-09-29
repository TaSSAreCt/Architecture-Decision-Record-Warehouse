<script lang="ts">
    import {FormManager} from "$lib/domain/manager/FormManager.svelte.js";
    import {getContext} from "svelte";
    import {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte.js";
    import {System} from "$lib/domain/entity/sos/System.svelte";

    let { system } : { system : System } = $props();

    const formManager : FormManager = getContext("formManager");
    const selectionManager : SelectionManager = getContext("selectionManager");

</script>
<p>
    System
    <button class="w3-button w3-border-bottom" onclick={() => {
        selectionManager.selectedSystem = system;
        formManager.toggle("updateSystem");
    }}>
        {system.title}
    </button>

</p>