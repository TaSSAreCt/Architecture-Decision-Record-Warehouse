import {NonFunctionalRequirement} from "$lib/domain/entity/ar/NonFunctionalRequirement.svelte";
import {Constraint} from "$lib/domain/entity/ar/Constraint.svelte";
import {Intention} from "$lib/domain/entity/ar/Intention.svelte";
import {ArchitecturePrinciple} from "$lib/domain/entity/ar/ArchitecturePrinciple.svelte";

export type ArchitectureRequirementType =
    | { type: 'nonFunctionalRequirement', value : NonFunctionalRequirement }
    | { type: 'constraint', value : Constraint }
    | { type: 'intention', value : Intention }
    | { type: 'architecturePrinciple', value : ArchitecturePrinciple };

export class Influence {

    id : string = $state<string>("");
    architectureRequirement : ArchitectureRequirementType | undefined = $state<ArchitectureRequirementType>();
    value: number = $state<number>(0.0);

    constructor() {
    }

    static create() : Influence {
        return new Influence();
    }
}