import {SAT} from "$env/static/private";
import type {Actions} from "@sveltejs/kit";

export const actions = {

    createIssue: async ({fetch, request}) => {

        const form = await request.formData();

        await fetch(`${SAT}/api/v1/issues`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/issue+json",
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