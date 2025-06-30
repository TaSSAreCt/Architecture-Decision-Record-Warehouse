import {
    fromSystemsOfSystemsResponseDto,
    SystemOfSystemsResponseDto
} from "$lib/dto/response/aggregate/SystemOfSystemsResponseDto";
import {AdrWarehouse} from "$lib/domain/aggregate/AdrWarehouse.svelte";

export class AdrWarehouseResponseDto {
    systemsOfSystems: SystemOfSystemsResponseDto[] = [];

    constructor() {}
}

export function fromAdrWarehouseResponseDto(adrWarehouseResponseDto : SystemOfSystemsResponseDto[]): AdrWarehouse  {

    const adrWarehouse = AdrWarehouse.create();

    adrWarehouse.systemsOfSystems = fromSystemsOfSystemsResponseDto(adrWarehouseResponseDto);

    return adrWarehouse;

}