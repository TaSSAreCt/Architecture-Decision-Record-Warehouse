import {type Actions, json} from "@sveltejs/kit";
import {BACKEND} from "$env/static/private";

export const actions = {

    architecturalKnowledge : async ({fetch, request}) => {

        const formData  = await request.formData();

        const architecturalKnowledge = JSON.parse(formData.get("architecturalKnowledge") as string);

        // create new issue
        architecturalKnowledge.issueList.forEach(issue => {

            issue.id = crypto.randomUUID();

            fetch(`${BACKEND}/api/v1/issues`, {
                method: 'POST',
                headers: {
                    "Content-Type": "application/issue+json",
                },
                body: JSON.stringify(
                    {
                        id: issue.id as string,
                        title: issue.title as string,
                    }
                )
            });

            issue.alternativeList.forEach(alternative => {

                alternative.id = crypto.randomUUID();

                fetch(`${BACKEND}/api/v1/issues/${issue.id}/alternatives`, {
                    method: 'POST',
                    headers: {
                        "Content-Type": "application/alternative+json",
                    },
                    body: JSON.stringify(
                        {
                            id: alternative.id as string,
                            title: alternative.title as string,
                        }
                    )
                });

                alternative.influenceList.forEach(influence => {

                    influence.id = crypto.randomUUID();
                    influence.architectureRequirement.id = crypto.randomUUID();

                    fetch(`${BACKEND}/api/v1/architectural-requirements`, {
                        method: 'POST',
                        headers: {
                            "Content-Type": "application/architecture-requirement+json",
                        },
                        body: JSON.stringify(
                            {
                                id: influence.architectureRequirement.id as string,
                                title: influence.architectureRequirement.title as string,
                                type: influence.architectureRequirement.type as string
                            }
                        )
                    });

                    fetch(`${BACKEND}/api/v1/relationships/influence`, {
                        method: 'POST',
                        headers: {
                            "Content-Type": "application/influence+json",
                        },
                        body: JSON.stringify(
                            {
                                id: influence.id,
                                value: influence.value,
                                alternativeId: alternative.id,
                                architectureRequirementId: influence.architectureRequirement.id,
                            }
                        )
                    });

                });

            });

        });

        return {
            success: true
        }
    }

} satisfies Actions;