<template>
<h1>Bienvenue dans l'accueil du jeu Memory</h1>
<div class="newjoueur">
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
<div class="ancienjoueur">
<h2>Déjà inscrit</h2>
<br/>
<br/>
<label for="email">Quel est votre e-mail ? &nbsp;</label>
<input type="email" name="email" id="email" placeholder="Votre email" />
<br/>
<br/>
<br/>
<button class="favorite styled" type="button">Connexion</button>
</div>


</template>

<script>
import axios from "axios";
export default{
  name:'Login',
  data() {
  return{
    nom0:"",
    prenom0:"",
    email0:"",
    pseudo0:"",
  }
},
methods:{
  creationJoueur(){
  axios.post('http://localhost:8080/services/creation/joueur', {
    nom: this.nom0,
    prenom:this.prenom0,
    email:this.email0,
    pseudo:this.pseudo0,
  })
  .then(function (response) {
    console.log(response);
  })
  }
}

}
</script>

<style>
.newjoueur{
  position: absolute;
  top: 170px;
  left: 340px;
}
.ancienjoueur{
  position: absolute;
  top: 170px;
  left: 740px;
}

</style>