import {AlternativeRequestDto} from "$lib/dto/request/entity/AlternativeRequestDto";
import {ArchitectureRationaleRequestDto} from "$lib/dto/request/entity/ArchitectureRationaleRequestDto";

export class JustifiedByRelationshipRequestDto {

    alternative : AlternativeRequestDto = AlternativeRequestDto.create();
    architectureRationale : ArchitectureRationaleRequestDto = ArchitectureRationaleRequestDto.create();


    static create() {
        return new JustifiedByRelationshipRequestDto();
    }
}