import {ArchitectureRationaleRequestDto} from "$lib/dto/request/entity/ArchitectureRationaleRequestDto";
import {SystemClassRequestDto} from "$lib/dto/request/entity/SystemClassRequestDto";

export class HasRelationshipRequestDto {
    systemClass : SystemClassRequestDto = SystemClassRequestDto.create();
    architectureRationale : ArchitectureRationaleRequestDto = ArchitectureRationaleRequestDto.create();


    static create() {
        return new HasRelationshipRequestDto();
    }
}