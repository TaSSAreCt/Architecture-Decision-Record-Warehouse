import {BACKEND} from "$env/static/private";
import type {Actions} from "@sveltejs/kit";

export const actions = {

    createAlternativeWithIssue: async ({fetch, request}) => {

        const form = await request.formData();

        const issueId = String(form.get("issueId"));

        await fetch(`${BACKEND}/api/v1/issues/${issueId}/alternatives`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/alternative+json",
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