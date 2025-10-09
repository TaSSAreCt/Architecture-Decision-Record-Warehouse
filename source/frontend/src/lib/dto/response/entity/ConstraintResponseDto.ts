import { Constraint } from "$lib/domain/entity/ar/Constraint.svelte.js";

export class ConstraintResponseDto {
  id: string | undefined;
  title: string | undefined;
  isCyber: boolean | undefined;
}

export function fromConstraintListResponseDto(constraintListResponseDto: ConstraintResponseDto[]): Constraint[] {
  return constraintListResponseDto.map(fromConstraintResponseDto);
}

export function fromConstraintResponseDto(constraintResponseDto: ConstraintResponseDto): Constraint {
  const constraint: Constraint = Constraint.create();

  constraint.id = constraintResponseDto.id;
  constraint.title = constraintResponseDto.title;
  constraint.isCyber = constraintResponseDto.isCyber;

  return constraint;
}
