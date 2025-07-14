import {Issue} from "$lib/domain/entity/ad/Issue.svelte.js";
import {AlternativeAggregate } from "$lib/domain/aggregate/AlternativeAggregate.svelte.js";

export type AlternativeRanking = {
    alternative : AlternativeAggregate
    ranking : number
}

export class ArchitectureDecision {
    issue = $state<Issue>(Issue.create());
    alternatives = $state<AlternativeAggregate[]>([]);

    constructor() {}

    isJustified = () => {
        return this.alternatives.some(item => item.architectureRationales.length !== 0);
    }

    getSelectedAlternative = () => {
        return this.alternatives.find(item => item.architectureRationales.length !== 0);
    }

    getRanking = () : AlternativeRanking[] => {

        const alternativeRanking : AlternativeRanking[] = [];

        this.alternatives.forEach(alternative => {
            
            const sum = alternative.forcedBy.reduce((acc, x) => acc += x.impact, 0);

            alternativeRanking.push({
                alternative: alternative,
                ranking: sum
            });

        })
        return alternativeRanking;
    };

    static create = () : ArchitectureDecision => {
        return new ArchitectureDecision();
    }
}