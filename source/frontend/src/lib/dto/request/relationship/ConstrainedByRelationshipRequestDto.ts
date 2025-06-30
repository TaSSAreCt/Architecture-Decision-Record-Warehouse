import {SystemElementRequestDto} from "$lib/dto/request/entity/SystemElementRequestDto";
import {ConstraintRequestDto} from "$lib/dto/request/entity/ConstraintRequestDto";

export class ConstrainedByRelationshipRequestDto {
    systemElement : SystemElementRequestDto = SystemElementRequestDto.create();
    constraint : ConstraintRequestDto = ConstraintRequestDto.create();

    static create() {
        return new ConstrainedByRelationshipRequestDto();
    }
}