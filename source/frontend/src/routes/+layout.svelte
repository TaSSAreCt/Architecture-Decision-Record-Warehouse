<script lang="ts">

    import {setContext} from "svelte";
    import {FormManager} from "$lib/domain/manager/FormManager.svelte.js";
    import QuickActionBar from "$lib/components/quick-action-bar/QuickActionBar.svelte";
    import {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte.js";
    import {ArchitecturalKnowledge } from "$lib/domain/aggregate/ArchitecturalKnowledge.svelte";
    import {
        fromArchitecturalRequirementsResponseDto
    } from "$lib/dto/response/entity/ArchitecturalRequirementsResponseDto";
    import {fromSystemListResponseDto} from "$lib/dto/response/entity/SystemResponseDto";
    import type {System} from "$lib/domain/entity/sos/System.svelte";
    import {fromIssueListResponseDto} from "$lib/dto/response/entity/IssueResponseDto";

    let { data, children } = $props();

    // Initialise Architectural Knowledge for CPSoS
    const cpsos = $state<System[]>(fromSystemListResponseDto(data.adrWarehouse));
    setContext('cpsos', cpsos);

    // Initialise Architectural Knowledge
    const architecturalKnowledge : ArchitecturalKnowledge = ArchitecturalKnowledge.create();
    architecturalKnowledge.issueList = fromIssueListResponseDto(data.architecturalKnowledge.issueList);
    architecturalKnowledge.architecturalRequirements = fromArchitecturalRequirementsResponseDto(data.architecturalKnowledge.architectureRequirementList);
    setContext('architecturalKnowledge', architecturalKnowledge);

    // Initialise form
    const formManager = FormManager.create();
    setContext('formManager', formManager);

    // Initialise settings
    const selectionManager = SelectionManager.create();
    setContext('selectionManager', selectionManager);

</script>

<div id="background" class="">

    <!-- Overlay -->
    <div class="w3-overlay" style="display: {formManager.overlay ? 'block' : 'none'}; z-index: 4;" id="myOverlay"></div>

    <!-- View -->
    <div class="w3-row">

        <!-- Quick Action Bar -->
        <div class="w3-col w3-right w3-container" style="width: 100px">
            <QuickActionBar />
        </div>

        <!-- Content -->
        <div class="w3-rest w3-container">
            {@render children()}
        </div>

    </div>

</div>

