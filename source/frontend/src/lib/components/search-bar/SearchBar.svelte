<script lang="ts">
    let { index, id, value, list,  callback = $bindable() } = $props();

    let visible = $state<boolean>(true);
    let input = $state({
        id: id,
        value: value
    });

</script>

<div>
    <div class="input">

        <input class="search-bar" id={input.id} type="text" placeholder="Mock" bind:value={input.value} onfocus={() => {visible = true}}/>

        {#if visible}
            <div class="search-items">
                {#each list as item}
                    <button class="w3-button w3-border search-item-button" onclick={() => {

                        visible = false;

                        input.id = item.id;
                        input.value = item.title;

                        callback[index] = item;

                    }}>{item.title}</button>
                {/each}
            </div>
        {/if}
    </div>
</div>


<style>
    .input {
        position :relative;
        margin-bottom: 20px;
    }

    .search-bar {
        width: 400px;
        padding: 8px;
        border: 1px solid #ccc;
    }

    .search-items {
        position: absolute;
        top: calc(100% + 3px);
        left: 0;
        width: 200px;
        height: 50px;
        background-color: white;
        border-radius: 2px;
        opacity: 0;
        pointer-events: none;
        z-index: 100;
    }

    .search-item-button {
        width: 200px;
    }

    .search-items:has(button:active) {
        opacity: 0;
        pointer-events: none;
    }

    .input:focus-within .search-items {
        opacity: 1;
        pointer-events: auto;
    }

</style>