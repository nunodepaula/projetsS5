<template>
  <div class="login">
    <p>
        Nom : <input v-model="message" placeholder="pseudo">
    </p>
  </div>
</template>

<script>
export default {
  name: 'Login'
}
</script>