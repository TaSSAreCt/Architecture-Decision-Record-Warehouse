export class NonFunctionalRequirement {
    id : string | undefined = $state();
    title : string | undefined = $state();

    constructor() {
    }

    static create() {
        return new NonFunctionalRequirement();
    }
}