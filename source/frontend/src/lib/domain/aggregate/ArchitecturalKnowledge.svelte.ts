import {ArchitectureDecision} from "$lib/domain/aggregate/ArchitectureDecision.svelte";

export class ArchitecturalKnowledge {

    architecturalDecisions = $state<ArchitectureDecision[]>([]);

    constructor() {}

    static create = () : ArchitecturalKnowledge => {
        return new ArchitecturalKnowledge();
    }
}