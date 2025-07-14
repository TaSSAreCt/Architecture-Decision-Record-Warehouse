import {BACKEND} from "$env/static/private";
import type {Actions} from "@sveltejs/kit";
import {RaiseRelationshipRequestDto} from "$lib/dto/request/relationship/RaiseRelationshipRequestDto";
import {SystemClassRequestDto} from "$lib/dto/request/entity/SystemClassRequestDto";

export const actions = {

    createSystem: async ({fetch, request}) => {
        const form = await request.formData();

        const systemDto = SystemClassRequestDto.create();

        systemDto.id = form.get("id") as string;
        systemDto.title = form.get("title") as string;

        await fetch(`${BACKEND}/api/v1/systems`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/system+json",
            },
            body: systemDto ? JSON.stringify(systemDto) : undefined
        });

        if (form.get('parentSystemId') as string) {
            await fetch(`${BACKEND}/api/v1/relationships/part-of`, {
               method: 'POST',
               headers: {
                   "Content-Type": "application/part-of+json",
               },
                body: JSON.stringify({
                    "parentSystemClass": {"id": form.get('parentSystemId') as string},
                    "childSystemClass": {"id": systemDto.id}
                })
            });
        }

        return {
            success: true,
        };
    },

    raiseIssue : async ({fetch, request}) => {
        const formData = await request.formData();

        const dto : RaiseRelationshipRequestDto = RaiseRelationshipRequestDto.create();
        dto.system.id = formData.get("systemId") as string;
        dto.issue.id = formData.get("issueId") as string;

        const response = await fetch(`${BACKEND}/api/v1/relationships/raise`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/raise+json",
            },
            body: dto ? JSON.stringify(dto) : undefined
        });

        return {
            success: true,
        };
    }

} satisfies Actions;