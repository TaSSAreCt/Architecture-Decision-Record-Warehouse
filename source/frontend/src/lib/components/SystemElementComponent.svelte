<script lang="ts">

    import {FormManager} from "$lib/domain/manager/FormManager.svelte.js";
    import {getContext} from "svelte";
    import {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte.js";
    import {SystemElement} from "$lib/domain/entity/sos/SystemElement.svelte";

    const { systemElement } : { systemElement : SystemElement } = $props();

    const formManager : FormManager = getContext("formManager");
    const selectionManager : SelectionManager = getContext("settings");

</script>

<div class="">
    <p>
        {systemElement.title} is constrained by {#each systemElement.constraints as constraint} {constraint.title}, {/each}
    </p>
</div>