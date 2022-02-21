<template>
<h1>Choix de Partie</h1>
<h3 onload="choixPartieConnect()">Sélectionnez une partie en attente de joueurs ou remplissez une nouvelle partie puis cliquez sur commencer</h3>
<div class="gauche">
<div class="contenu1">
<h4>Parties en attentes</h4>
<label for="name">Identifiant de la partie à rejoindre&nbsp;</label>
<input type="text" v-model="identifiant">
<button @click="rejoindre">
Rejoindre!!
</button>
 <table id='parties' class="styled-table">
            <tr>
                <th>Crée par</th>
                <th>Identifiant</th>
                <th>Difficulté</th>
                <th>Taille Plateau</th>
                <th>Nombre de paires</th>
                <th>Nombre de Joueurs</th>
            </tr>
            <tr v-for="row in this.lesparties" :key="row">
                <td>{{row.nomCreateur}}</td>
                <td>{{row.identifiant}}</td>
                <td>{{row.difficulte}}</td>
                <td>{{row.longueurPlateau}}</td>
                <td>{{row.nbPaires}}</td>
                <td>{{row.nbJoueurs}}</td>
            </tr>
    </table>
</div>
</div>
<div class="droite">
<div class="contenu2">
<h4>Nouvelle Partie</h4>
<br/>
<label for="difficulty">&nbsp;&nbsp;&nbsp;&nbsp;Difficulté&nbsp;</label>

<select name="difficulte" id="difficulty" v-model="difficulteChoisi">
    <option value="">Sélectionnez</option>
    <option value="debutant">Débutant</option>
    <option value="normal">Normal</option>
    <option value="impossible">Impossible</option>
</select>
<br/>
<br/>
<br/>
<label for="taille">Taille Plateau&nbsp;</label>

<select name="plateau" id="taille" v-model="longueurPlateauChoisi">
    <option value="">Sélectionnez</option>
    <option value=10>10</option>
    <option value=30>30</option>
    <option value=70>70</option>
</select>
<br/>
<br/>
<br/>
<label for="paire">Nombre de paires</label>

<select name="nombre" id="paire" v-model="nbPaireChoisi">
    <option value="">Sélectionnez</option>
    <option value=3>3</option>
    <option value=12>12</option>
    <option value=30>30</option>
</select>
<br/>
<br/>
<br/>
<label for="joueurs">Nombre de Joueurs</label>
<select name="nombreJoueur" id="joueurs" v-model="nbJoueursChoisi">
    <option value="">Sélectionnez</option>
    <option value=2>2</option>
    <option value=3>3</option>
    <option value=4>4</option>
    <option value=5>5</option>
    <option value=6>6</option>
    <option value=7>7</option>
    <option value=8>8</option>
</select>
<br/>
<br/>
<br/>
<label>Adversaire</label>
<br/>
 <input type="checkbox" id="joueurphy" name="joueurphy"
         checked @checked="changeJoueurPhy">
  <label for="joueurphy">Joueurs en ligne</label>
<input type="checkbox" id="joueurmachine" name="joueurmachine"
         checked @checked="changeJoueurVirtuel">
  <label for="joueurmachine">Joueurs machines</label>  
  <br/>
  <br/>
  <button @click="sendReponse">Commencez!!</button>
</div>
</div>
</template>


<script>
import axios from "axios";
export default{
    name:"choixpartie",
    data(){
    return{
    ws : null,
    identifiant:0,
    index:0,
    difficulteChoisi:"",
    nbPaireChoisi:"",
    longueurPlateauChoisi:"",
    nbJoueursChoisi:0,
    adversaire:"",
    serverUrl: "ws://localhost:8080/ws/allparties/",
    lesparties:[],
     choixReponse: {
        nomCreateur:"",
        difficulte: "",
        nbPaires: 0,
        longueurPlateau:0,
        nbJoueurs:0,
        identifiant:0,
      },
      partieMessage: {
        nomCreateur:"",
        identifiant:0,
        difficulte:"",
        nbPaires:0,
        longueurPlateau:0,
        nbJoueurs:0
      },

    }
},

mounted(){
    this.appelPartieRest();
    this.choixPartieConnect();
  },
methods:{
    appelPartieRest(){
        console.log("Appel service Rest ...")
        axios.get("http://localhost:8080/services/allparties").then((response) => {
        for(this.index;this.index<response.data.length;this.index++){
            console.log(response.data[this.index]);
            this.lesparties.push(response.data[this.index]);
      }
    });
    },
    changeJoueurPhy(){
        this.adversaire="JoueurPhysique";
    },
    changeJoueurVirtuel(){
        this.adversaire="JoueurVirtuel";
    },

    rejoindre(){
        for (this.index = 0; this.index < this.lesparties.length; this.index++) {
            if(this.lesparties[this.index].identifiant==this.identifiant){
                  this.choixReponse.nomCreateur = this.lesparties[this.index].nomCreateur;
                  this.choixReponse.difficulte =  this.lesparties[this.index].difficulte;
                  this.choixReponse.longueurPlateau= this.lesparties[this.index].longueurPlateau;
                  this.choixReponse.nbPaires= this.lesparties[this.index].nbPaires; 
                  this.choixReponse.nbJoueurs= this.lesparties[this.index].nbJoueurs;
                  this.choixReponse.identifiant=this.identifiant;
                  this.ws.send(JSON.stringify(this.choixReponse));
                  this.PartieChoisie();
                  this.$router.push({
                  name: "memoire"
              });
            }
            else{
                console.log("pas d'identifiant correspondant");
            }
        }
    },
     handleNewMessage(event) {
        console.log(event.data);
        this.partieMessage = JSON.parse(event.data);
        for(var i=0;i<this.lesparties.length;i++){
            console.log(this.lesparties[i].identifiant);
            if(this.lesparties[i].identifiant==this.partieMessage.identifiant){
            this.lesparties.splice(i,1);
            console.log(this.lesparties);
            return;
        }
        }
        this.lesparties.push(this.partieMessage);
        console.log(this.partieMessage.nomCreateur);},
    PartieChoisie(){
        this.ws.close();
        this.ws = null;
    },
    sendReponse(){
        console.log(this.difficulteChoisi);
        console.log(this.nbPaireChoisi);
      this.choixReponse.nomCreateur = this.$store.getters.getLeUser;
      this.choixReponse.difficulte = this.difficulteChoisi;
      this.choixReponse.longueurPlateau=this.longueurPlateauChoisi;
      this.choixReponse.nbPaires=this.nbPaireChoisi; 
      this.choixReponse.nbJoueurs=this.nbJoueursChoisi;
      this.ws.send(JSON.stringify(this.choixReponse)); 
      this.PartieChoisie();
      this.$router.push({
                  name: "memoire"
              });
    },
    choixPartieConnect() {     
      console.log("Starting connection to WebSocket Server");
      this.serverUrl=this.serverUrl+this.$store.getters.getLeUser;
      this.ws = new WebSocket(this.serverUrl);
      this.ws.onopen = function (event) {
        console.log(event);
        console.log("On est connecté !!!");
      };
      this.ws.addEventListener('message', (event) => { this.handleNewMessage(event) });
    }
}

}

</script>

<style>
h1{
    text-align:center,
}
h3{
    text-align:center,
}

.gauche{
    float:left;
    width:60%
}

.droite{
    float:right;
    width:40%,
}
.contenu1{
    position:relative;
    top:10%;
    left:10%;
    bottom:5%;
}
.contenu2{
  position: relative;
  top: 10%;
  right:100%;
  bottom:5%;
  left:0%

}
.styled-table {
    border-collapse: collapse;
    margin: 25px 0;
    font-size: 0.9em;
    font-family: sans-serif;
    min-width: 400px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}
.styled-table thead tr {
    background-color: #009879;
    color: #ffffff;
    text-align: left;
}
.styled-table th,
.styled-table td {
    padding: 12px 15px;
}

.select{
    align-items:center;
}
th{
    text-align:center;
    background-color: #009879;
    color: #ffffff;
}

td{
    width:0%;
}
</style>