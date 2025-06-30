import {System} from "$lib/domain/entity/sos/System.svelte.js";

export class SystemResponseDto {
    id : string = "";
    title : string = "";

    constructor() {
    }

    static create() {
        return new SystemResponseDto();
    }
}

export function fromSystemResponseDto(systemResponseDto : SystemResponseDto) : System {
    const system : System = System.create();

    system.id = systemResponseDto.id;
    system.title = systemResponseDto.title;

    return system;
}