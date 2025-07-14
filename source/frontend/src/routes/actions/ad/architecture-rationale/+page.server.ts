import type { Actions } from "@sveltejs/kit";
import {ArchitectureRationaleRequestDto} from "$lib/dto/request/entity/ArchitectureRationaleRequestDto";
import {JustifiedByRelationshipRequestDto} from "$lib/dto/request/relationship/JustifiedByRelationshipRequestDto";
import {BACKEND} from "$env/static/private";
import {HasRelationshipRequestDto} from "$lib/dto/request/relationship/HasRelationshipRequestDto";

export const actions = {

    createArchitectureRationale : async ({ fetch, request }) => {

        const formData = await request.formData();

        const architectureRationaleRequestDto = ArchitectureRationaleRequestDto.create();

        architectureRationaleRequestDto.id = formData.get("id") as string;
        architectureRationaleRequestDto.title = formData.get("title") as string;
        architectureRationaleRequestDto.context = formData.get("context") as string;
        architectureRationaleRequestDto.decision = formData.get("decision") as string;
        architectureRationaleRequestDto.status = formData.get("status") as string;
        architectureRationaleRequestDto.consequences = formData.get("consequences") as string;

        await fetch(`${BACKEND}/api/v1/architectural-rationales`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/architecture-rationale+json"
            },
            body: architectureRationaleRequestDto ? JSON.stringify(architectureRationaleRequestDto) : undefined
        });

        const justifiedByRelationshipRequestDto = JustifiedByRelationshipRequestDto.create();

        justifiedByRelationshipRequestDto.alternative.id = formData.get("alternativeId") as string;
        justifiedByRelationshipRequestDto.architectureRationale.id = architectureRationaleRequestDto.id as string;

        await fetch(`${BACKEND}/api/v1/relationships/justified-by`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/justified-by+json"
            },
            body: justifiedByRelationshipRequestDto ? JSON.stringify(justifiedByRelationshipRequestDto) : undefined
        });

        const hasRelationshipRequestDto = HasRelationshipRequestDto.create();
        hasRelationshipRequestDto.systemClass.id = formData.get("systemId") as string;
        hasRelationshipRequestDto.architectureRationale.id = architectureRationaleRequestDto.id;


        await fetch(`${BACKEND}/api/v1/relationships/has`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/has+json"
            },
            body: hasRelationshipRequestDto ? JSON.stringify(hasRelationshipRequestDto) : undefined
        });


        return {
            success: true,
        }

    },


} satisfies Actions;