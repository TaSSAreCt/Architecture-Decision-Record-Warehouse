import {ArchitectureRequirement} from "$lib/domain/entity/ar/ArchitectureRequirement.svelte";

export class Influence {

    id : string = $state<string>("");
    value: number = $state<number>(0.0);
    architectureRequirement : ArchitectureRequirement | undefined = $state<ArchitectureRequirement>();

    constructor() {
    }

    static create() : Influence {
        return new Influence();
    }
}