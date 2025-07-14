import {SystemElement} from "$lib/domain/entity/sos/SystemElement.svelte";
import {NonFunctionalRequirement} from "$lib/domain/entity/ar/NonFunctionalRequirement.svelte";
import {Issue} from "$lib/domain/entity/ad/Issue.svelte";

export class System {

    id : string | undefined = $state<string>();
    title : string | undefined = $state<string>();
    systemList = $state<System[]>([]);
    systemElementList : SystemElement[] = $state([]);
    nonFunctionalRequirementList : NonFunctionalRequirement[] = $state([]);
    issueList : Issue[] = $state([]);

    constructor() {}

    static create() : System {
        return new System();
    };
}