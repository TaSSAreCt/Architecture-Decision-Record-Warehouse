import {BACKEND} from "$env/static/private";
import type {Actions} from "@sveltejs/kit";

export const actions = {

    createAlternativeWithIssueAndArchitecturalRequirements : async ({fetch, request}) => {

        const form = await request.formData();
        const issueId = String(form.get("issueId"));
        const alternativeId = form.get("id") as string;

        await fetch(`${BACKEND}/api/v1/issues/${issueId}/alternatives`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/alternative+json",
            },
            body: JSON.stringify(
                {
                    id: alternativeId,
                    title: form.get("title") as string,
                }
            )
        });

        let architectureRequirementIds : string | string[] = String(form.get("selectedArchitecturalRequirements"));
        architectureRequirementIds = architectureRequirementIds.split(",");
        let values : number[] = String(form.get("values")).split(",").map(value => Number(value.trim()));
        let influenceIds : string[] = String(form.get("influenceIds")).split(",");

        architectureRequirementIds.forEach(((architectureRequirementId, index) => {

            fetch(`${BACKEND}/api/v1/relationships/influence`, {
                method: 'POST',
                headers: {
                    "Content-Type": "application/influence+json",
                },
                body: JSON.stringify(
                    {
                        id: influenceIds[index],
                        value: values[index],
                        alternativeId: alternativeId,
                        architectureRequirementId: architectureRequirementId,
                    }
                )
            });
        }));

        return {
            success: true,
        };
    },

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