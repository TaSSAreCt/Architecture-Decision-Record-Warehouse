import {Rationale} from "$lib/domain/entity/ad/Rationale.svelte";

export class YStatement extends Rationale {

    context : string;
    nonFunctionalConcern : string;
    option : string;
    options : string[];
    quality : string;
    consequence : string;

    get() : string {
        return`In the context of ${this.context}, 
        facing ${this.nonFunctionalConcern}, 
        we decided for ${this.option}, 
        and neglected ${this.options}, 
        to achieve ${this.quality}, 
        accepting downside ${this.consequence}.`
    }

    constructor(
        context : string,
        nonFunctionalConcern : string,
        option: string,
        options : string[],
        quality: string,
        consequence: string,
    ) {
        super();

        this.context = context;
        this.nonFunctionalConcern = nonFunctionalConcern;
        this.option = option;
        this.options = options;
        this.quality = quality;
        this.consequence = consequence;
    }

    static create(
        context : string,
        nonFunctionalConcern : string,
        option: string,
        options : string[],
        quality: string,
        consequence: string,
    ) {
        return new YStatement(context, nonFunctionalConcern, option, options, quality, consequence)
    }
}