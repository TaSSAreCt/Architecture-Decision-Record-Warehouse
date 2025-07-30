import {NonFunctionalRequirement} from "$lib/domain/entity/ar/NonFunctionalRequirement.svelte";
import {Constraint} from "$lib/domain/entity/ar/Constraint.svelte";
import {Intention} from "$lib/domain/entity/ar/Intention.svelte";
import {ArchitecturePrinciple} from "$lib/domain/entity/ar/ArchitecturePrinciple.svelte";

export type ArchitectureRequirementType =
    | { type: 'nonFunctionalRequirement', value : NonFunctionalRequirement }
    | { type: 'constraint', value : Constraint }
    | { type: 'intention', value : Intention }
    | { type: 'architecturePrinciple', value : ArchitecturePrinciple };

export interface ArchitectureRequirementInterface {
    id : string;
    title : string;
    type : "nonFunctionalRequirement" | "constraint" | "intention" | "architecturePrinciple" | undefined;

}

export class ArchitectureRequirement implements ArchitectureRequirementInterface {
    id: string;
    title: string;
    type: "constraint" | "nonFunctionalRequirement" | "intention" | "architecturePrinciple" | undefined;

    constructor(id : string, title : string) {
        this.id = id;
        this.title = title;
    }

    static create(id : string, title : string) {
        return new ArchitectureRequirement(id, title);
    }

}