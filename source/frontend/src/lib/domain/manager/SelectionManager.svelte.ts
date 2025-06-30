import {SystemOfSystems} from "$lib/domain/aggregate/SystemOfSystems.svelte.js";
import {SystemElementAggregate} from "$lib/domain/aggregate/SystemElementAggregate.svelte.js";
import {ArchitectureDecision} from "$lib/domain/aggregate/ArchitectureDecision.svelte.js";
import type {NonFunctionalRequirement} from "$lib/domain/entity/ar/NonFunctionalRequirement.svelte";

export class SelectionManager {

    selectedSystemOfSystems  : SystemOfSystems = $state(SystemOfSystems.create());
    selectedSystemElementAggregate : SystemElementAggregate = $state(SystemElementAggregate.create());
    selectedArchitecturalDecision : ArchitectureDecision | null = $state(null);

    constructor() {}

    reset = () => {
        this.selectedArchitecturalDecision = null;
    }

    static create() {
        return new SelectionManager();
    }
}