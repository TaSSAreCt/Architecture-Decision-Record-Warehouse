import {ArchitectureRequirement} from "$lib/domain/entity/ar/ArchitectureRequirement.svelte";

export class ArchitectureRequirementResponseDto {
    id : string = "";
    title : string = "";
    type : "constraint" | 'nonFunctionalRequirement' | "intention" | "architecturePrinciple" = "constraint";

    static create() {
        return new ArchitectureRequirementResponseDto();
    }
}

export function fromArchitectureRequirementResponseDto(architectureRequirementResponseDto : ArchitectureRequirementResponseDto): ArchitectureRequirement {

    const architectureRequirement : ArchitectureRequirement = ArchitectureRequirement.create(architectureRequirementResponseDto.id, architectureRequirementResponseDto.title);

    architectureRequirement.type = architectureRequirementResponseDto.type;

    return  architectureRequirement;
    /*
    switch (architectureRequirementResponseDto.type) {

        case "constraint": {

            const constraint =  Constraint.create();

            constraint.id = architectureRequirementResponseDto.id;
            constraint.title = architectureRequirementResponseDto.title;
            constraint.type = architectureRequirementResponseDto.type;

            return constraint;

        }
        case "nonFunctionalRequirement": {
            const nonFunctionalRequirement = NonFunctionalRequirement.create();
            nonFunctionalRequirement.id = architectureRequirementResponseDto.id;
            nonFunctionalRequirement.title = architectureRequirementResponseDto.title;
            nonFunctionalRequirement.type = architectureRequirementResponseDto.type;

            return nonFunctionalRequirement;
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

     */
}