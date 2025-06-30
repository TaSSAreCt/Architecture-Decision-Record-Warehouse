import {SystemElementAggregateResponseDto} from "$lib/dto/response/aggregate/SystemElementAggregateResponseDto";
import {Constraint} from "$lib/domain/entity/ar/Constraint.svelte";

export class SystemElementAggregate {
    id = $state<string>("");
    title = $state<string>("");
    constraints = $state<Constraint[]>([]);

    static create = () => {
        return new SystemElementAggregate();
    }
}