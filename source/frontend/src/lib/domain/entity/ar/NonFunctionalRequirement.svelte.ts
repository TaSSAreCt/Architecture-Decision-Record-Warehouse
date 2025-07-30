import type {
    ArchitectureRequirement,
    ArchitectureRequirementInterface
} from "$lib/domain/entity/ar/ArchitectureRequirement.svelte";

export class NonFunctionalRequirement implements ArchitectureRequirementInterface {

    id :  string = $state("");
    title : string = $state("");
    type : "nonFunctionalRequirement" | "constraint" | "intention" | "architecturePrinciple" | undefined = $state();

    constructor() {
    }

    static create() {
        return new NonFunctionalRequirement();
    }
}