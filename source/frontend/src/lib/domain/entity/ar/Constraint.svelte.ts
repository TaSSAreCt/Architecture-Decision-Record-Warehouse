export class Constraint {

    id: string | undefined = $state();
    title: string | undefined = $state();

    constructor() {
    }

    static create(): Constraint {
        return new Constraint();
    }
}