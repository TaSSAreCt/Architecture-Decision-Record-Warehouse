<script lang="ts">
  let { isCyber } = $props();
</script>

<span
  class="w3-round-xlarge {isCyber ? 'w3-green' : 'w3-red'}"
  style="padding-right: 8px; padding-left: 8px;"
  >{isCyber ? "Cyber" : "Physical"}
</span>
