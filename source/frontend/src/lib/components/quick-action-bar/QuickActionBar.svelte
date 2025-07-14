<script lang="ts">
    import {getContext} from "svelte";
    import CreateSystemForm from "$lib/components/form/sos/CreateSystemForm.svelte";
    import QuickActionItemBar from "$lib/components/quick-action-bar/QuickActionItemBar.svelte";
    import CreateSystemElementForm from "$lib/components/form/sos/CreateSystemElementForm.svelte";
    import CreateAlternativeForm from "$lib/components/form/ad/CreateAlternativeForm.svelte";
    import CreateArchitecturePrincipleForm from "$lib/components/form/ar/CreateArchitecturePrincipleForm.svelte";
    import CreateIntentionForm from "$lib/components/form/ar/CreateIntentionForm.svelte";
    import CreateIssueForm from "$lib/components/form/ad/CreateIssueForm.svelte";
    import CreateConstraintForm from "$lib/components/form/ar/CreateConstraintForm.svelte";
    import CreateNonFunctionalRequirementForm from "$lib/components/form/ar/CreateNonFunctionalRequirementForm.svelte";
    import UpdateSystemForm from "$lib/components/form/sos/UpdateSystemForm.svelte";
    import {FormManager} from "$lib/domain/manager/FormManager.svelte.js";
    import UpdateAlternativeForm from "$lib/components/form/ad/UpdateAlternativeForm.svelte";
    import UpdateSystemElementForm from "$lib/components/form/sos/UpdateSystemElementForm.svelte";
    import CreateArchitecturalKnowledgeForm from "$lib/components/form/akm/CreateArchitecturalKnowledgeForm.svelte";
    import {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte.js";
    import UpdateRationaleForm from "$lib/components/form/ad/UpdateRationaleForm.svelte";

    const formManager : FormManager = getContext('formManager');
    const selectionManager : SelectionManager = getContext('selectionManager');
</script>

<!-- list of all quick action bar items-->
<div class="w3-margin w3-round-xlarge quick-action-bar">

    <!-- Quick action items -->
    <QuickActionItemBar form="createSystem" icon="S+"/>
    <QuickActionItemBar form="createSystemElement" icon="SE+" />
    <QuickActionItemBar form="createArchitecturalKnowledge" icon="AK+" />

    <!-- Switch views -->
    <a target="_blank" href="http://localhost:7474" class="w3-button" style="position:fixed; bottom:40px">AKM</a>

</div>

<!-- List of all forms -->
<div class="w3-sidebar form-style w3-right w3-bar-block w3-animate-right padding-16 w3-round-xlarge w3-margin" style="display: {formManager.overlay ? 'block' : 'none'};width: 600px;">

    <button class="w3-button w3-xlarge" on:click={() => {
        formManager.reset();
        selectionManager.reset();
    }}>&times;</button>

    <div class="w3-container" style="margin-right: 40px; width: 500px">
        {#if formManager.createSystem}
            <CreateSystemForm />
        {:else if formManager.updateSystem}
            <UpdateSystemForm />
        {:else if formManager.createSystemElement}
            <CreateSystemElementForm />
        {:else if formManager.updateSystemElement}
            <UpdateSystemElementForm />
        {:else if formManager.createAlternative}
            <CreateAlternativeForm />
        {:else if formManager.updateAlternative}
            <UpdateAlternativeForm />
        {:else if formManager.createArchitecturePrinciple}
            <CreateArchitecturePrincipleForm />
        {:else if formManager.createIntention}
            <CreateIntentionForm />
        {:else if formManager.createIssue}
            <CreateIssueForm />
        {:else if formManager.createConstraint}
            <CreateConstraintForm />
        {:else if formManager.createNonFunctionalRequirement}
            <CreateNonFunctionalRequirementForm />
        {:else if formManager.updateArchitecturalRationale}
            <UpdateRationaleForm />
        {:else if formManager.createArchitecturalKnowledge}
            <CreateArchitecturalKnowledgeForm />
        {/if}
    </div>

</div>