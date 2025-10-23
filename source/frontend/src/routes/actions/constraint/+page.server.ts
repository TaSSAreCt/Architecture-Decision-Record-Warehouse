import type { Actions } from "@sveltejs/kit";
import { BACKEND } from "$env/static/private";

export const actions = {
  createConstrainedByRelationship: async ({ fetch, request }) => {
    const form = await request.formData();

    const constraintID = form.get("constraintID") as string;
    const systemElementID = form.get("systemElementID") as string;
    const isCyber = form.get("isCyber") as boolean;

    await fetch(`${BACKEND}/api/v1/relationships/constrained-by`, {
      method: "POST",
      headers: {
        "Content-Type": "application/constrained-by+json",
      },
      body: JSON.stringify({
        constraintID: constraintID,
        systemElementID: systemElementID,
        isCyber: isCyber,
      }),
    });

    return {
      success: true,
    };
  },
} satisfies Actions;
