import { SystemElement } from "$lib/domain/entity/sos/SystemElement.svelte";
import { NonFunctionalRequirement } from "$lib/domain/entity/ar/NonFunctionalRequirement.svelte";
import { Issue } from "$lib/domain/entity/ad/Issue.svelte";
import type { Rationale } from "$lib/domain/entity/ad/Rationale.svelte";

export class System {

  id: string | undefined = $state<string>();
  title: string | undefined = $state<string>();
  isCyber: boolean = $state(true);
  systemList = $state<System[]>([]);
  systemElementList: SystemElement[] = $state([]);
  nonFunctionalRequirementList: NonFunctionalRequirement[] = $state([]);
  issueList: Issue[] = $state([]);
  rationaleList: Rationale[] = $state([]);

  constructor() { }

  getOpenIssues(): Issue[] {
    return this.issueList
      .filter(issue => issue.alternativeList.every(alternative => !this.rationaleList.some(rationale => rationale.justifies === alternative.id)));
  }

  static create(): System {
    return new System();
  };
}
