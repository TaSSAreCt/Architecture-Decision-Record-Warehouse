import {Issue} from "$lib/domain/entity/ad/Issue.svelte";
import {ArchitecturalRequirements} from "$lib/domain/entity/ar/ArchitecturalRequirements.svelte.js";

export class ArchitecturalKnowledge {

    issueList : Issue[] = $state<Issue[]>([]);
    architecturalRequirements : ArchitecturalRequirements = $state<ArchitecturalRequirements>(new ArchitecturalRequirements());

    constructor() {}

    static create = () : ArchitecturalKnowledge => {
        return new ArchitecturalKnowledge();
    }
}