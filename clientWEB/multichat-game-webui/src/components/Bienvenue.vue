<template>
  <div id="titre">
    <h1>Bienvenue {{ message }} !!!</h1>
  </div>
  <div id="Navig">
      <nav>
          <h4>
              <navigation v-if="!$route.params.lenom == ''" :url="homeurl" desc=" Maison "/>
              <span v-if="!$route.params.lenom == ''"> - </span>
              <navigation v-if="!$route.params.lenom == ''" :url="lechaturl" desc=" Discutons "/>
               <span v-if="!$route.params.lenom == ''"> - </span>
              <navigation v-if="!$route.params.lenom == ''" :url="byeurl" desc=" Au Revoir ... " @click="effaceTout"/>
              <span v-if="!$route.params.lenom == ''"> - </span>
              <navigation v-if="!$route.params.lenom == ''" :url="tictactoeurl" desc=" TicTacToe "/>
          </h4>
      </nav>
  </div>
  <div id="Log" v-if="$route.params.lenom == null">
      <login @loginEvent="setUser"/>
  </div>
  <div id="contenu" v-else>
    <router-view/>
  </div>
</template>

<script>
import Login from "@/components/Login.vue"
import Navigation from "./Navigation.vue"

export default {
  name: 'Bienvenue',
  components : {
    Login,
    Navigation
  },
  data(){
      return {
          message : "",
          homeurl: "/",
          byeurl: "/",
          tictactoeurl:"/",
          lechaturl:"/"
      }
  },
  props: {
    msg: String
  },
  created() {
      if (this.$store.getters.getLeUser == ""){
          this.message = "sur " + this.msg
      }
  },
  methods: {
      setUser(){
          this.message = this.$store.getters.getLeUser;
          this.homeurl = '/maison/' + this.$store.getters.getLeUser;
          this.tictactoeurl= '/maison/' + this.$store.getters.getLeUser+'/tictactoe';
          this.lechaturl='/maison/' + this.$store.getters.getLeUser+'/lechat';
      },
      effaceTout(){
          sessionStorage.clear();
          this.message = "sur " + this.msg;
          this.homeurl = '/'
      },
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
