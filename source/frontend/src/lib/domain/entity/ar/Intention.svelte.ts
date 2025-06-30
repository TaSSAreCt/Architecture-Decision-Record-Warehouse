export class Intention {

    id :  string = $state("");
    title:  string = $state("");

    constructor() {
    }

    static create() {
        return new Intention();
    }
}