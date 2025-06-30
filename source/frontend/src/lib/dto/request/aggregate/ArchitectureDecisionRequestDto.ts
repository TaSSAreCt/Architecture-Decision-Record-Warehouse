import {IssueResponseDto} from "$lib/dto/response/entity/IssueResponseDto";
import {AlternativeAggregateResponseDto} from "$lib/dto/response/aggregate/AlternativeAggregateResponseDto";
import type {IssueRequestDto} from "$lib/dto/request/entity/IssueRequestDto";

export class ArchitectureDecisionRequestDto {
    issue: IssueRequestDto = IssueResponseDto.create();
    alternatives : AlternativeAggregateResponseDto[] = [];
}