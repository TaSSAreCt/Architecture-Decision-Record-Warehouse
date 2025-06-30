import {ArchitecturePrinciple} from "$lib/domain/entity/ar/ArchitecturePrinciple.svelte";

export class ArchitecturePrincipleResponseDto {
    id : string = "";
    title : string = "";

    static create() {
        return new ArchitecturePrincipleResponseDto();
    }
}


export function fromArchitecturalPrinciplesResponseDto(architecturalPrinciplesResponseDto : ArchitecturePrincipleResponseDto[]) : ArchitecturePrinciple[] {
    return architecturalPrinciplesResponseDto.map(fromArchitecturePrincipleResponseDto);
}

export function fromArchitecturePrincipleResponseDto(architecturePrincipleResponseDto : ArchitecturePrincipleResponseDto) : ArchitecturePrinciple {
    const architecturePrinciple : ArchitecturePrinciple = ArchitecturePrinciple.create();

    architecturePrinciple.id = architecturePrincipleResponseDto.id;
    architecturePrinciple.title = architecturePrincipleResponseDto.title;

    return architecturePrinciple;
}
