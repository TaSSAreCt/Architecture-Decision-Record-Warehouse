import {type ArchitectureRequirementType, ForcedBy} from "$lib/domain/aggregate/ForcedBy.svelte";
import {Constraint} from "$lib/domain/entity/ar/Constraint.svelte";
import {NonFunctionalRequirement} from "$lib/domain/entity/ar/NonFunctionalRequirement.svelte.js";
import {Intention} from "$lib/domain/entity/ar/Intention.svelte.js";
import {ArchitecturePrinciple} from "$lib/domain/entity/ar/ArchitecturePrinciple.svelte.js";

export class ArchitectureRequirementResponseDto {
    id : string = "";
    title : string = "";
    type : "constraint" | 'nonFunctionalRequirement' |"intention" | "architecturePrinciple" = "constraint";

    static create() {
        return new ArchitectureRequirementResponseDto();
    }
}

export function fromArchitectureRequirementResponseDto(architectureRequirementResponseDto : ArchitectureRequirementResponseDto): ArchitectureRequirementType {

    let architectureRequirement : ArchitectureRequirementType;

    switch (architectureRequirementResponseDto.type) {

        case "constraint": {

            const constraint =  Constraint.create();

            constraint.id = architectureRequirementResponseDto.id;
            constraint.title = architectureRequirementResponseDto.title;

            return architectureRequirement = {
                type: architectureRequirementResponseDto.type,
                value: constraint
            }
        }
        case "nonFunctionalRequirement": {
            const nonFunctionalRequirement = NonFunctionalRequirement.create();
            nonFunctionalRequirement.id = architectureRequirementResponseDto.id;
            nonFunctionalRequirement.title = architectureRequirementResponseDto.title;

            return architectureRequirement = {
                type: architectureRequirementResponseDto.type,
                value: nonFunctionalRequirement
            }
        }
        case "intention": {

            const intention = Intention.create();

            intention.id = architectureRequirementResponseDto.id;
            intention.title = architectureRequirementResponseDto.title;

            return architectureRequirement = {
                type: architectureRequirementResponseDto.type,
                value: intention
            }
        }
        case "architecturePrinciple": {
            const architecturePrinciple = ArchitecturePrinciple.create();

            architecturePrinciple.id = architectureRequirementResponseDto.id;
            architecturePrinciple.title = architectureRequirementResponseDto.title;

            return architectureRequirement = {
                type: architectureRequirementResponseDto.type,
                value: architecturePrinciple
            }
        }
        default: {
            console.log("Unknown");
            return architectureRequirement = {
                type: "constraint",
                value: Constraint.create()
            };
        }
    }
}