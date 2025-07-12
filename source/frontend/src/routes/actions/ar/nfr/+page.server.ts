import type {Actions} from "@sveltejs/kit";
import {BACKEND} from "$env/static/private";
import {RequireRelationshipRequestDto} from "$lib/dto/request/entity/RequireRelationshipRequestDto";

export const actions = {

    require : async ({fetch, request}) => {

        const formData = await request.formData();

        const dto : RequireRelationshipRequestDto = RequireRelationshipRequestDto.create();

        dto.nonFunctionalRequirement.id = formData.get("nonFunctionalRequirementId") as string;
        dto.systemClass.id = formData.get("systemId") as string;

        await fetch(`${BACKEND}/api/v1/relationships/require`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/require+json",
            },
            body: dto ? JSON.stringify(dto) : undefined
        });

        return {
            success: true,
        };

    },

} satisfies Actions;