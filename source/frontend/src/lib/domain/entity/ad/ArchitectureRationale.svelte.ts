import type {ArchitectureRationaleResponseDto} from "$lib/dto/response/entity/ArchitectureRationaleResponseDto";

export class ArchitectureRationale {

    id : string = $state<string>("");
    title: string = $state<string>("");
    context :  string = $state<string>("");
    decision : string = $state<string>("");
    status : string = $state<string>("");
    consequences : string = $state<string>("");

    constructor() {
    }

    static create() {
        return new ArchitectureRationale();
    }

    static fromJson = (architecturalRationaleResponseDto : ArchitectureRationaleResponseDto): ArchitectureRationale => {
        const architectureRationale = new ArchitectureRationale();

        architectureRationale.id = architecturalRationaleResponseDto.id;
        architectureRationale.title = architecturalRationaleResponseDto.title;
        architectureRationale.context = architecturalRationaleResponseDto.context;
        architectureRationale.decision = architecturalRationaleResponseDto.decision;
        architectureRationale.status = architecturalRationaleResponseDto.status;
        architectureRationale.consequences = architecturalRationaleResponseDto.consequences;

        return architectureRationale;
    }
}