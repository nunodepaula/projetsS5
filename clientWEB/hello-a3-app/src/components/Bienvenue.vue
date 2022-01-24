<template>
  <div class="bienvenue">
    <h1>Bienvenue sur {{ msg }} !!!</h1>
    <p>
      Entrez votre nom ou pseudo ci-dessous pour se connecter.
    </p>
  </div>
</template>

<script>
export default {
  name: 'Bienvenue',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
