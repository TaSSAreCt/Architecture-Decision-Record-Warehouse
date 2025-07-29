// @ts-ignore
import {BACKEND} from "$env/static/private";

// @ts-ignore
export const load: PageServerLoad = async ({fetch}) => {

    const architecturalKnowledge = async () => {
        const response = await fetch(`${BACKEND}/api/v1/architectural-knowledge`, {
            method: 'GET',
        })
        return await response.json();
    }

    const adrWarehouse = async () => {
        const response = await fetch(`${BACKEND}/api/v1/cpsos`, {
            method: 'GET',
        });
        return await response.json();
    }

    return {
        adrWarehouse: await adrWarehouse(),
        architecturalKnowledge : await architecturalKnowledge()
    }

};