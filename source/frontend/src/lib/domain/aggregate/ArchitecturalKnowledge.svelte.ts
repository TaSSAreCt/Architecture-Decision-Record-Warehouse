import {ArchitectureDecision} from "$lib/domain/aggregate/ArchitectureDecision.svelte";
import {Constraint} from "$lib/domain/entity/ar/Constraint.svelte";
import {Influence} from "$lib/domain/entity/ad/Influence.svelte.js";

export class ArchitecturalKnowledge {

    constraintList = $state<Constraint[]>([]);
    influenceList = $state<Influence[]>([]);

    architecturalDecisions = $state<ArchitectureDecision[]>([]);

    constructor() {}

    static create = () : ArchitecturalKnowledge => {
        return new ArchitecturalKnowledge();
    }
}