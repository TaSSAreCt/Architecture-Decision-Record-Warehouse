import {NonFunctionalRequirement} from "$lib/domain/entity/ar/NonFunctionalRequirement.svelte.js";
import {Constraint} from "$lib/domain/entity/ar/Constraint.svelte";
import {Intention} from "$lib/domain/entity/ar/Intention.svelte.js";
import {ArchitecturePrinciple} from "$lib/domain/entity/ar/ArchitecturePrinciple.svelte.js";

export type ArchitectureRequirementType =
    | { type: 'nonFunctionalRequirement', value : NonFunctionalRequirement }
    | { type: 'constraint', value : Constraint }
    | { type: 'intention', value : Intention }
    | { type: 'architecturePrinciple', value : ArchitecturePrinciple };


export class ForcedBy {
    architectureRequirement : ArchitectureRequirementType;
    impact : number = 0;

    constructor(architectureRequirement : ArchitectureRequirementType, impact : number) {
        this.architectureRequirement = architectureRequirement;
        this.impact = impact;
    }

    static create(architectureRequirement : ArchitectureRequirementType, impact : number) {
        return new ForcedBy(architectureRequirement, impact);
    }
}