import {Constraint} from "$lib/domain/entity/ar/Constraint.svelte.js";

export class ConstraintResponseDto {
    id : string = "";
    title : string = "";
}

export function fromConstraintsResponseDto(constraintsResponseDto : ConstraintResponseDto[]) : Constraint[] {
    return constraintsResponseDto.map(fromConstraintResponseDto);
}

export function fromConstraintResponseDto(constraintResponseDto : ConstraintResponseDto) : Constraint {
    const constraint : Constraint = Constraint.create();

    constraint.id = constraintResponseDto.id;
    constraint.title = constraintResponseDto.title;

    return constraint;
}