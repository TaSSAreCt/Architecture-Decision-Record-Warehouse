
import {System} from "$lib/domain/entity/sos/System.svelte";
import {SystemElement} from "$lib/domain/entity/sos/SystemElement.svelte";
import type {Issue} from "$lib/domain/entity/ad/Issue.svelte";
import type {Rationale} from "$lib/domain/entity/ad/Rationale.svelte";

export class SelectionManager {

    selectedSystem  : System | undefined = $state<System>();
    selectedSystemElement : SystemElement | undefined = $state<SystemElement>();
    selectedIssue : Issue | undefined = $state<Issue>();
    selectedRationale : Rationale | undefined = $state<Rationale>();

    constructor() {}

    static create() {
        return new SelectionManager();
    }
}