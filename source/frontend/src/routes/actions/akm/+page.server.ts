import {BACKEND} from "$env/static/private";
import type {Actions} from "@sveltejs/kit";

export const actions = {

    createArchitectureRequirement: async ({fetch, request}) => {

        const form = await request.formData();

        await fetch(`${BACKEND}/api/v1/architectural-requirements`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/architecture-requirement+json",
            },
            body: JSON.stringify(
                {
                    id: form.get("id") as string,
                    title: form.get("title") as string,
                    type: form.get("architectureRequirementType") as string
                }
            )
        });

        return {
            success: true,
        };
    }
} satisfies Actions;