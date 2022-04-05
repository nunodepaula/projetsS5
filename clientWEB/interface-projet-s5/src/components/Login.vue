<template>
<h1>Bienvenue dans l'accueil du jeu Memory</h1>
<div class="newjoueur">
<form action="" method="get" class="form-example">
    <h2>Nouveau Joueur</h2>
    <br/>
    <br/>
   <label for="nom">Quel est votre nom ?</label>
    <input type="text" name="nom" id="nom" placeholder="Votre nom" v-model="nom0" required/>
    <br/>
    <br/>
    <br/>
    <label for="prenom">Quel est votre prénom ?</label>
    <input type="text" name="prenom" id="prenom" placeholder="Votre prénom" v-model="prenom0" required/>
    <br/>
    <br/>
    <br/>
    <label for="email">Quel est votre e-mail ?</label>
    <input type="email" name="email" id="email" placeholder="Votre email" v-model="email0" required/>
    <br/>
    <br/>
    <br/>
    <label for="prenom">Quel est votre pseudo ?</label>
    <input type="text" name="pseudo" id="pseudo" placeholder="Votre pseudo" v-model="pseudo0" required/>
    <br/>
    <br/>
    <br/>
    <input type="submit" value="Inscription"  @click="creationJoueur">
    </form>
</div>
<div class="ancienjoueur">
<form action="" method="get" class="form-example2">
<h2>Déjà inscrit</h2>
<br/>
<br/>
<label for="email">Quel est votre e-mail ? &nbsp;</label>
<input type="email" name="email" id="email" placeholder="Votre email" v-model="email0"/>
<br/>
<br/>
<br/>
<input type="submit" value="Connexion"  @click="creationAvecMail">
</form>
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
    errors: [],
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
body{
  background-image:url("../assets/background.jpg");
  background-size:cover;
  background-attachment: fixed;
  min-height: 100%;
  background-repeat: no-repeat;
  background-position: center center;
}
.newjoueur{
  float:left;
  width:50%
}
.ancienjoueur{
  float:right;
  width:50%
}
label {
  /* Pour être sûrs que toutes les étiquettes ont même taille et sont correctement alignées */
  display: inline-block;
  width: 120px;
  text-align: right;
}
select {
  /* Pour être sûrs que toutes les étiquettes ont même taille et sont correctement alignées */
  display: inline-block;
  width: 120px
}
.form-example{
  position: relative;
  top: 10px;
  right:100px;
  bottom:10px;
}

.form-example2{
  position: relative;
  top: 10px;
  left:40px;
  bottom:10px;
}
h1{
  text-align: center;
  
}
</style>