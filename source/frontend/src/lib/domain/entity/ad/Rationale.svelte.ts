import {Issue} from "$lib/domain/entity/ad/Issue.svelte";
import {System} from "$lib/domain/entity/sos/System.svelte";
import {Alternative} from "$lib/domain/entity/ad/Alternative.svelte";

export type Ranking = {
    alternative : Alternative;
    value : number;
}

export class Rationale {

    system : System | undefined = $state<System>();
    issue : Issue | undefined = $state<Issue>();
    designDecision : Alternative | undefined = $state<Alternative>();

    constructor() {}

    getRanking = () : Ranking[] => {
        const ranking : Ranking[] = [];

        this.issue?.alternativeList.forEach((alternative : Alternative) => {
            const sum = alternative.influenceList.reduce((acc, x) => acc += x.value, 0);

            ranking.push({
                alternative: alternative,
                value: sum
            });
        });

        return ranking
    }
}