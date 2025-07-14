import type {Actions} from "@sveltejs/kit";
import {ConstrainedByRelationshipRequestDto} from "$lib/dto/request/relationship/ConstrainedByRelationshipRequestDto";
import {BACKEND} from "$env/static/private";

export const actions = {

    constrainedByConstraint : async ({fetch, request}) => {

        const formData = await request.formData();

        const dto : ConstrainedByRelationshipRequestDto = ConstrainedByRelationshipRequestDto.create();

        dto.constraint.id = formData.get("constrainedId") as string;
        dto.systemElement.id = formData.get("systemElementId") as string;

        const response = await fetch(`${BACKEND}/api/v1/relationships/constrained-by`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/constrained-by+json",
            },
            body: dto ? JSON.stringify(dto) : undefined
        });

        return {
            success: true,
        };

    },

} satisfies Actions;