import type {
  ArchitectureRequirementInterface
} from "$lib/domain/entity/ar/ArchitectureRequirement.svelte";

export class Constraint implements ArchitectureRequirementInterface {

  id: string = $state("");
  title: string = $state("");
  type: "nonFunctionalRequirement" | "constraint" | "intention" | "architecturePrinciple" | undefined = $state();
  isCyber: boolean = $state(true);

  constructor() {
  }

  static create(): Constraint {
    return new Constraint();
  }
}
