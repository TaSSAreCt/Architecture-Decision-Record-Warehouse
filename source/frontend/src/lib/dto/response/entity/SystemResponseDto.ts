import { System } from "$lib/domain/entity/sos/System.svelte.js";
import {
  fromSystemElementListResponseDto,
  SystemElementResponseDto
} from "$lib/dto/response/entity/SystemElementResponseDto";
import {
  fromNonFunctionalRequirementsResponseDto,
  NonFunctionalRequirementResponseDto
} from "$lib/dto/response/entity/NonFunctionalRequirementResponseDto";
import { fromIssueListResponseDto, type IssueResponseDto } from "$lib/dto/response/entity/IssueResponseDto";
import {
  fromRationalesResponseDto,
  RationaleResponseDto
} from "$lib/dto/response/entity/ArchitectureRationaleResponseDto";

export class SystemResponseDto {
  id: string | undefined;
  title: string | undefined;
  isCyber: boolean | undefined;
  systemElementList: SystemElementResponseDto[] = [];
  systemList: SystemResponseDto[] = [];
  issueList: IssueResponseDto[] = [];
  nonFunctionalRequirementList: NonFunctionalRequirementResponseDto[] = [];
  rationaleList: RationaleResponseDto[] = [];
}

export function fromSystemListResponseDto(systemListResponseDto: SystemResponseDto[]): System[] {
  return systemListResponseDto.map(fromSystemResponseDto);
}

export function fromSystemResponseDto(systemResponseDto: SystemResponseDto): System {

  const system: System = System.create();

  system.id = systemResponseDto.id;
  system.title = systemResponseDto.title;
  system.isCyber = systemResponseDto.isCyber;

  system.systemElementList = fromSystemElementListResponseDto(systemResponseDto.systemElementList);

  system.systemList = fromSystemListResponseDto(systemResponseDto.systemList);

  system.nonFunctionalRequirementList = fromNonFunctionalRequirementsResponseDto(systemResponseDto.nonFunctionalRequirementList);

  system.issueList = fromIssueListResponseDto(systemResponseDto.issueList);

  system.rationaleList = fromRationalesResponseDto(systemResponseDto.rationaleList);

  return system;
}
