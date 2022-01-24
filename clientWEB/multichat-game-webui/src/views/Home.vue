<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <Bienvenue msg="MyMultichat-Game"/>
    <Login v:on:connexion='demande'/>
  </div>
</template>

<script>
// @ is an alias to /src
import Bienvenue from '../components/Bienvenue.vue'
import Login from '../components/Login.vue'

export default {
  name: 'Home',
  components: {
    Bienvenue,
    Login
  }
}
</script>