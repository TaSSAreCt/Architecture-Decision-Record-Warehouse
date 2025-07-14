import {NonFunctionalRequirement} from "$lib/domain/entity/ar/NonFunctionalRequirement.svelte";
import {Constraint} from "$lib/domain/entity/ar/Constraint.svelte";
import {Intention} from "$lib/domain/entity/ar/Intention.svelte";
import {ArchitecturePrinciple} from "$lib/domain/entity/ar/ArchitecturePrinciple.svelte";

export type ArchitectureRequirement =
    | { type: 'nonFunctionalRequirement', value : NonFunctionalRequirement, weight : number }
    | { type: 'constraint', value : Constraint, weight : number }
    | { type: 'intention', value : Intention, weight : number }
    | { type: 'architecturePrinciple', value : ArchitecturePrinciple, weight : number };

export class Influence {

    id : string = $state<string>("");
    architectureRequirement : ArchitectureRequirement | undefined = $state<ArchitectureRequirement>();
    value: number = $state<number>(0.0);

    constructor() {
    }

    static create() : Influence {
        return new Influence();
    }
}