
import {AdrWarehouse} from "$lib/domain/aggregate/AdrWarehouse.svelte";
import {fromSystemListResponseDto, type SystemResponseDto} from "$lib/dto/response/entity/SystemResponseDto";

export class AdrWarehouseResponseDto {
    systemsOfSystems: SystemResponseDto[] = [];

    constructor() {}
}

export function fromAdrWarehouseResponseDto(adrWarehouseResponseDto : AdrWarehouseResponseDto): AdrWarehouse  {

    const adrWarehouse = AdrWarehouse.create();

    adrWarehouse.systemsOfSystems = fromSystemListResponseDto(adrWarehouseResponseDto.systemsOfSystems);

    return adrWarehouse;

}