import type {Actions} from "@sveltejs/kit";

export const actions = {

    ask : async ({fetch, request}) => {

        const form = await request.formData();

        await fetch(``, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                adr : form.get("adr") as string,
            })
        });

        return {
            success: true,
        }
    }

} satisfies Actions;