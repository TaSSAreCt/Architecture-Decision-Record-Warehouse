import {Rationale} from "$lib/domain/entity/ad/Rationale.svelte";
import {Influence} from "$lib/domain/entity/ad/Influence.svelte";
import {NonFunctionalRequirement} from "$lib/domain/entity/ar/NonFunctionalRequirement.svelte";
import {Constraint} from "$lib/domain/entity/ar/Constraint.svelte";

export type Ranking = {
    value : number;
    color : "green" | "orange" | "red" | "gray"
}

export class Alternative {

    id : string | undefined = $state<string | undefined>();
    title : string | undefined = $state<string | undefined>();
    rationaleList : Rationale[] = $state<Rationale[]>([]);
    influenceList : Influence[] = $state<Influence[]>([]);

    constructor() {
    }

    getRanking(nonFunctionalRequirementList : NonFunctionalRequirement[], constraintList : Constraint[]) : Ranking {

        let value : number = 0;
        let color : "green" | "orange" | "red" | "gray";

        this.influenceList.forEach(influence => {
            if (influence.architectureRequirement?.type == "intention" || influence.architectureRequirement?.type == "architecturePrinciple") {
                value += influence.value;
            }

            if (influence.architectureRequirement?.type == "nonFunctionalRequirement"  && nonFunctionalRequirementList.some(nonFunctionalRequirement => nonFunctionalRequirement.id === influence.architectureRequirement?.id)) {
                value += influence.value;
            }

            if (influence.architectureRequirement?.type == "constraint"  && constraintList.some(constraint => constraint.id === influence.architectureRequirement?.id)) {
                value += influence.value;
            }

        });

        if (value > 0) {
            color = "green";
        } else if (value == 0) {
            color = "orange";
        } else  if (value < 0) {
            color = "red";
        } else {
            color = "gray";
        }

        return {
            value: value,
            color: color,
        };
    }

    categoriseInfluenceList(nonFunctionalRequirementList : NonFunctionalRequirement[], constraintList : Constraint[]) : {positive: Influence[], negative : Influence[]} {

        const categorised = {
            positive : [],
            negative : [],
        }

        this.influenceList.forEach(influence => {

            if (influence.architectureRequirement?.type == "intention" || influence.architectureRequirement?.type == "architecturePrinciple") {
                if (influence.value >= 0) {
                    categorised.positive.push(influence);
                }  else {
                    categorised.negative.push(influence);
                }
            }

            if (influence.architectureRequirement?.type == "nonFunctionalRequirement"  && nonFunctionalRequirementList.some(nonFunctionalRequirement => nonFunctionalRequirement.id === influence.architectureRequirement?.id)) {
                if (influence.value >= 0) {
                    categorised.positive.push(influence);
                }  else {
                    categorised.negative.push(influence);
                }
            }

            if (influence.architectureRequirement?.type == "constraint"  && constraintList.some(constraint => constraint.id === influence.architectureRequirement?.id)) {
                if (influence.value >= 0) {
                    categorised.positive.push(influence);
                }  else {
                    categorised.negative.push(influence);
                }
            }
        });

        return categorised

    }

    static create() : Alternative {
        return new Alternative();
    }
}