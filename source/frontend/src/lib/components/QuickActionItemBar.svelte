<script lang="ts">
    import {getContext} from "svelte";
    import {FormManager} from "$lib/domain/manager/FormManager.svelte.js";

    const formManager : FormManager = getContext("formManager");

    let props = $props();

</script>

<div class="">
    <button class="w3-button" onclick={() => {formManager.toggle(props.form);}}>{props.icon}</button>
</div>