
import {Intention} from "$lib/domain/entity/ar/Intention.svelte";

export class IntentionResponseDto {
    id : string = "";
    title : string = "";
}

export function fromIntentionsResponseDto(intentionsResponseDto : IntentionResponseDto[]) : Intention[] {
    return intentionsResponseDto.map(fromIntentionResponseDto);
}

export function fromIntentionResponseDto(intentionResponseDto : IntentionResponseDto) : Intention {
    const intention : Intention = Intention.create();

    intention.id = intentionResponseDto.id;
    intention.title = intentionResponseDto.title;

    return intention;
}