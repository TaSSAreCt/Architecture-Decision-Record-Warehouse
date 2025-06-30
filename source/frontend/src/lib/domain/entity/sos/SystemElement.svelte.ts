export class SystemElement {

    id : string = $state("");
    title : string = $state("");

    constructor() {
    }

    static create() {
        return new SystemElement();
    }

}