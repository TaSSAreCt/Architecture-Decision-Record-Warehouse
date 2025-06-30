<script lang="ts">

    import {setContext} from "svelte";
    import {FormManager} from "$lib/domain/manager/FormManager.svelte.js";
    import QuickActionBar from "$lib/components/QuickActionBar.svelte";
    import {AdrWarehouse } from "$lib/domain/aggregate/AdrWarehouse.svelte.js";
    import { fromAdrWarehouseResponseDto } from "$lib/dto/response/aggregate/adrWarehouseResponseDto";
    import {SelectionManager} from "$lib/domain/manager/SelectionManager.svelte.js";
    import {ArchitecturalKnowledge } from "$lib/domain/aggregate/ArchitecturalKnowledge.svelte";
    import {fromArchitecturalKnowledgeResponseDto} from "$lib/dto/response/aggregate/ArchitecturalKnowledgeResponseDto";
    import {ArchitecturalRequirements} from "$lib/domain/aggregate/ArchitecturalRequirements.svelte";
    import {
        fromArchitecturalRequirementsResponseDto
    } from "$lib/dto/response/aggregate/ArchitecturalRequirementsResponseDto";

    let { data, children } = $props();

    // Initialise Architectural Knowledge for CPSoS
    const adrWarehouse : AdrWarehouse = fromAdrWarehouseResponseDto(data.adrWarehouse);
    setContext('adrWarehouse', adrWarehouse);

    // Initialise Architectural Knowledge
    const architecturalKnowledge : ArchitecturalKnowledge = fromArchitecturalKnowledgeResponseDto(data.architecturalKnowledge);
    setContext('architecturalKnowledge', architecturalKnowledge);

    // Initialise Architectural Requirements
    const architecturalRequirements : ArchitecturalRequirements = fromArchitecturalRequirementsResponseDto(data.architecturalRequirements);
    setContext('architecturalRequirements', architecturalRequirements);

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

