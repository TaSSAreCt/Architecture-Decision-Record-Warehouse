export class Constraint {

    id: string = $state("");
    title: string = $state("");

    constructor() {
    }

    static create(): Constraint {
        return new Constraint();
    }
}