import {Constraint} from "$lib/domain/entity/ar/Constraint.svelte.js";
import {ArchitecturePrinciple} from "$lib/domain/entity/ar/ArchitecturePrinciple.svelte.js";
import {Intention} from "$lib/domain/entity/ar/Intention.svelte.js";
import {NonFunctionalRequirement} from "$lib/domain/entity/ar/NonFunctionalRequirement.svelte.js";
import type {ArchitectureRequirement} from "$lib/domain/entity/ar/ArchitectureRequirement.svelte";

export class ArchitecturalRequirements {
    constraintList =  $state<Constraint[]>([]);
    architecturePrincipleList = $state<ArchitecturePrinciple[]>([]);
    intentionList = $state<Intention[]>([]);
    nonFunctionalRequirementList = $state<NonFunctionalRequirement[]>([]);

    constructor() {}

    add(architectureRequirement : ArchitectureRequirement) {
        switch (architectureRequirement.type) {
            case "constraint":
                let constraint : Constraint = Constraint.create();
                constraint.id = architectureRequirement.id;
                constraint.title = architectureRequirement.title;
                this.constraintList.push(constraint);
                break
            case "nonFunctionalRequirement":
                let nonFunctionalRequirement : NonFunctionalRequirement = NonFunctionalRequirement.create();
                nonFunctionalRequirement.id = architectureRequirement.id;
                nonFunctionalRequirement.title = architectureRequirement.title;
                this.nonFunctionalRequirementList.push(nonFunctionalRequirement);
                break
            case "architecturePrinciple":
                let architecturePrinciple : ArchitecturePrinciple = ArchitecturePrinciple.create();
                architecturePrinciple.id = architectureRequirement.id;
                architecturePrinciple.title = architectureRequirement.title;
                this.architecturePrincipleList.push(architecturePrinciple);
                break
            case "intention":
                let intention : Intention = Intention.create();
                intention.id = architectureRequirement.id;
                intention.title = architectureRequirement.title;
                this.intentionList.push(intention);
                break
            default:
                console.log("Unknown");
        }
    }

    static create() : ArchitecturalRequirements {
        return new ArchitecturalRequirements();
    }


}