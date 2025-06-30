import {SystemClassRequestDto} from "$lib/dto/request/entity/SystemClassRequestDto";
import {NonFunctionalRequirementRequestDto} from "$lib/dto/request/entity/NonFunctionalRequirementRequestDto";

export class RequireRelationshipRequestDto {

    systemClass : SystemClassRequestDto = SystemClassRequestDto.create();
    nonFunctionalRequirement : NonFunctionalRequirementRequestDto = NonFunctionalRequirementRequestDto.create();

    static create() {
        return new RequireRelationshipRequestDto();
    }
}