import {Alternative} from "$lib/domain/entity/ad/Alternative.svelte.js";
import {Rationale} from "$lib/domain/entity/ad/Rationale.svelte.js";
import {ForcedBy} from "$lib/domain/aggregate/ForcedBy.svelte";
import {Constraint} from "$lib/domain/entity/ar/Constraint.svelte";
import {NonFunctionalRequirement} from "$lib/domain/entity/ar/NonFunctionalRequirement.svelte";

export class AlternativeAggregate {

    alternative = $state<Alternative>(Alternative.create());
    architectureRationales = $state<Rationale[]>([]);
    forcedBy = $state<ForcedBy[]>([]);

    constructor() {}

    static create() : AlternativeAggregate {
        return new AlternativeAggregate();
    }

    getRanked = (constraints : Constraint[], nfrs : NonFunctionalRequirement[]) => {

        let impact = 0;

        this.forcedBy.forEach(f => {
            if (f.architectureRequirement.type === "constraint") {
                const force_value = constraints.find(constraint => constraint.id === f.architectureRequirement.value.id) ? f.impact : 0;
                impact += force_value;
            }

            if (f.architectureRequirement.type === "intention") {
                impact += f.impact;
            }

            if (f.architectureRequirement.type === "architecturePrinciple") {
                impact += f.impact;
            }

            if (f.architectureRequirement.type === "nonFunctionalRequirement") {
                const force_value = nfrs.find(nfr => nfr.id === f.architectureRequirement.value.id);


                nfrs.forEach(nfr => {
                    console.log(nfr.id);
                })
                console.log("ID: " + f.architectureRequirement.value.id);
                impact += 0;
            }
        });

        return impact;
    }
}