export class ArchitecturePrinciple {

    id :  string = $state("");
    title: string = $state("");

    constructor() {
    }

    static create() {
        return new ArchitecturePrinciple();
    }
}