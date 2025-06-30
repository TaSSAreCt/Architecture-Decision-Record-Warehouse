import {Issue} from "$lib/domain/entity/ad/Issue.svelte.js";
import {AlternativeAggregate } from "$lib/domain/aggregate/AlternativeAggregate.svelte.js";

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
    getRanking = () => {

        if (this.alternatives.length === 0) {
            return { positive: undefined, neutral: undefined, negative: undefined };
        }

        let positive = {
            alternative: this.alternatives[0],
            sum: -1000
        };

        let neutral = {
            alternative: this.alternatives[0],
            sum: 0
        };
        let negative = {
            alternative: this.alternatives[0],
            sum: 1000
        };

        this.alternatives.forEach(alternative => {
            const sum = alternative.forcedBy.reduce((acc, x) => acc += x.impact, 0);

            if (sum > positive.sum) {
                positive.sum = sum;
                positive.alternative = alternative;
            }

            if (sum < negative.sum) {
                negative.sum = sum;
                negative.alternative = alternative;
            }

        })
        return { positive, neutral, negative };
    };

    static create = () : ArchitectureDecision => {
        return new ArchitectureDecision();
    }
}