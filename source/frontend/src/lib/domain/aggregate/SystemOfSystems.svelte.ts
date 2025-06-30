import {System} from "$lib/domain/entity/sos/System.svelte.js";
import {NonFunctionalRequirement} from "$lib/domain/entity/ar/NonFunctionalRequirement.svelte.js";
import {ArchitectureDecision } from "$lib/domain/aggregate/ArchitectureDecision.svelte.js";
import {SystemElementAggregate} from "$lib/domain/aggregate/SystemElementAggregate.svelte.js";

export class SystemOfSystems {

    system = $state<System>(System.create());
    systemElementAggregates = $state<SystemElementAggregate[]>([]);
    childSystems = $state<SystemOfSystems[]>([]);
    nonFunctionalRequirements = $state<NonFunctionalRequirement[]>([]);
    architecturalDecisions = $state<ArchitectureDecision[]>([]);

    constructor() {}

    static create = () : SystemOfSystems => {
        return new SystemOfSystems();
    }

}