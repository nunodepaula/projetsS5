<template>
<h1>Bienvenue dans l'accueil du jeu Memory</h1>
<div class="newjoueur">
<div class="contenu1">
    <h2>Nouveau Joueur</h2>
    <br/>
    <br/>
   <label for="nom">Quel est votre nom ?&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
    <input type="text" name="nom" id="nom" placeholder="Votre nom" v-model="nom0"/>
    <br/>
    <br/>
    <br/>
    <label for="prenom">Quel est votre prénom ?&nbsp;&nbsp;</label>
    <input type="text" name="prenom" id="prenom" placeholder="Votre prénom" v-model="prenom0"/>
    <br/>
    <br/>
    <br/>
    <label for="email">Quel est votre e-mail ?&nbsp;&nbsp;&nbsp;&nbsp;</label>
    <input type="email" name="email" id="email" placeholder="Votre email" v-model="email0"/>
    <br/>
    <br/>
    <br/>
    <label for="prenom">Quel est votre pseudo ? &nbsp;</label>
    <input type="text" name="pseudo" id="pseudo" placeholder="Votre pseudo" v-model="pseudo0"/>
    <br/>
    <br/>
    <br/>
    <button class="favorite styled"
        type="button" @click="creationJoueur">
    Inscription
    </button>
</div>
</div>
<div class="ancienjoueur">
<div class="contenu2">
<h2>Déjà inscrit</h2>
<br/>
<br/>
<label for="email">Quel est votre e-mail ? &nbsp;</label>
<input type="email" name="email" id="email" placeholder="Votre email" v-model="email0"/>
<br/>
<br/>
<br/>
<button class="favorite styled" type="button" @click="creationAvecMail">Connexion</button>
</div>
</div>

</template>

<script>
import axios from "axios";
export default{
  name:'Login',
  data() {
  return{
    nom0:null,
    prenom0:null,
    email0:null,
    pseudo0:null,
    errors:"",
  }
},
methods:{
  creationJoueur(){
  axios.post('http://localhost:8080/services/creation/inscription', {
   nom:this.nom0,
   prenom:this.prenom0,
   email:this.email0,
   pseudo:this.pseudo0,
  }
  )
  .then(function (response) {
    console.log(response);
  })
   if((this.nom0)&&(this.prenom0)&&(this.email0)&&(this.pseudo0)){
              this.$store.commit("setLeUser", this.email0);
              this.$router.push({
                  name: "choixpartie",
                  params:{lenom:this.email0}
              });
          }
          if(!this.nom0) {
              this.errors.push("Nom Obligatoire.")
          }
  },

  creationAvecMail(){
    axios.get('http://localhost:8080/services/creation/connexion',{headers:{
      email:this.email0
    }})
    .then(function (response) {
    console.log(response);
  })
   if(this.email0){
     this.$router.push({name:"choixpartie",params:{lenom:this.email0}}) 
    }
  }
}

}
</script>

<style>
.newjoueur{
  float:left;
  width:50%
}
.ancienjoueur{
  float:right;
  width:50%
}

.contenu1{
  position: relative;
  top: 10%;
  left:30%;
  bottom:5%;
}

.contenu2{
  position: relative;
  top: 10%;
  left:5%;
  bottom:5%;
}
h1{
  text-align: center;
}
</style>