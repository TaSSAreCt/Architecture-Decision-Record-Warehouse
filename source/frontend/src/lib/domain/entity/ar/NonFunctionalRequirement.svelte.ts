export class NonFunctionalRequirement {
    id : string = $state("");
    title : string = $state("");

    constructor() {
    }

    static create() {
        return new NonFunctionalRequirement();
    }
}