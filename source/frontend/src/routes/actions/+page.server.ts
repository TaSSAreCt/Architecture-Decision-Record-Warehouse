import type {Actions} from "@sveltejs/kit";
import {AlternativeAggregateRequestDto} from "$lib/dto/request/aggregate/AlternativeAggregateRequestDto";
import {IssueRequestDto} from "$lib/dto/request/entity/IssueRequestDto";
import {SAT} from "$env/static/private";
import {ArchitecturalKnowledgeRequestDto} from "$lib/dto/request/aggregate/ArchitecturalKnowledgeRequestDto";

export const actions = {
    createArchitecturalKnowledge : async ({fetch, request}) => {
        const formData = await request.formData();

        const issue : IssueRequestDto = IssueRequestDto.create();

        issue.id = formData.get("id") as string;
        issue.title = formData.get("title") as string;

        const alternativeAggregates : AlternativeAggregateRequestDto[] = JSON.parse(formData.get("alternativeAggregates") as string);
        const architecturalKnowledgeRequestDto = ArchitecturalKnowledgeRequestDto.create(issue, alternativeAggregates);

        await fetch(`${SAT}/api/v1/architectural-knowledge`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/architectural-knowledge+json",
            },
            body: architecturalKnowledgeRequestDto ? JSON.stringify(architecturalKnowledgeRequestDto) : undefined
        });

        return {
            success: true,
        };
    }
} satisfies Actions