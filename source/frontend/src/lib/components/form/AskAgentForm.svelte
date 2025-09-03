<script lang="ts">

    import { enhance } from "$app/forms";
</script>

<div class="w3-container">

    <form method="post" action="actions/ai?/ask" use:enhance={async ({formData}) => {

        const file = formData.get('adr');

        if (file instanceof File) {
            const text = await file.text();
            console.log(text);
        }

    }}>
        <label for="adr">Choose an architecture decision record:</label>
        <input type="file" id="adr" name="adr" /><br>

        <button class="w3-button w3-border" style="margin-top: 20px" type="submit">ask</button>
    </form>
</div>