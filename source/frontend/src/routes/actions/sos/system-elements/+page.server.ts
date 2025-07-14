import {BACKEND} from "$env/static/private";
import type {Actions} from "@sveltejs/kit";

export const actions = {

    createSystemElement: async ({fetch, request}) => {

        const form = await request.formData();

        const systemId = form.get("systemId") as string;

        await fetch(`${BACKEND}/api/v1/systems/${systemId}/system-elements`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/system-element+json",
            },
            body: JSON.stringify(
                {
                    id: form.get("id") as string,
                    title: form.get("title") as string,
                }
            )
        });

        return {
            success: true,
        };
    }
} satisfies Actions;