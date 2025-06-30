import {IssueRequestDto} from "$lib/dto/request/entity/IssueRequestDto";
import {SystemClassRequestDto} from "$lib/dto/request/entity/SystemClassRequestDto";

export class RaiseRelationshipRequestDto {
    system : SystemClassRequestDto = SystemClassRequestDto.create();
    issue : IssueRequestDto = IssueRequestDto.create();

    static create() {
        return new RaiseRelationshipRequestDto();
    }

}