<template>
<h1>Choix de Partie</h1>
<h3 onload="choixPartieConnect()">Sélectionnez une partie en attente de joueurs ou remplissez une nouvelle partie puis cliquez sur commencer</h3>
<div class="gauche">
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
                <th>Mode</th>
                <th>Taille Plateau</th>
                <th>Nombre de Joueurs</th>
            </tr>
            <tr v-for="row in this.lesparties" :key="row">
                <td>{{row.nomCreateur}}</td>
                <td>{{row.identifiant}}</td>
                <td>{{row.mode}}</td>
                <td>{{row.longueurPlateau}}</td>
                <td>{{row.nbJoueurs}}</td>
            </tr>
    </table>
</div>
<div class="droite">
<h4>Nouvelle Partie</h4>
<br/>

<label for="taille">Taille Plateau</label>

<select name="plateau" id="taille" v-model="longueurPlateauChoisi">
    <option selected="selected" value=4>4</option>
    <option value=7>7</option>
    <option value=10>10</option>
</select>
<br/>
<br/>
<br/>
<label for="paire">Mode</label>

<select name="nombre" id="paire" v-model="modeChoisi">
    <option selected=true value=1>1</option>
    <option value=2>2</option>
</select>
<br/>
<br/>
<br/>
<label for="joueurs">Nombre de Joueurs</label>
<select name="nombreJoueur" id="joueurs" v-model="nbJoueursChoisi">
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
    modeChoisi:0,
    longueurPlateauChoisi:"",
    nbJoueursChoisi:0,
    adversaire:"",
    serverUrl: "ws://localhost:8080/ws/allparties/",
    lesparties:[],
     choixReponse: {
        nomCreateur:"",
        mode:0,
        longueurPlateau:0,
        nbJoueurs:0,
        identifiant:0,
      },
      partieMessage: {
        nomCreateur:"",
        identifiant:0,
        mode:0,
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
                  this.$store.commit("setEmailCreateur",this.choixReponse.nomCreateur);
                  console.log(this.choixReponse.nomCreateur+"test");
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
        this.$store.commit("setTaille", this.choixReponse.longueurPlateau);
    },
    sendReponse(){
      this.choixReponse.nomCreateur = this.$store.getters.getLeUser;
      this.choixReponse.longueurPlateau=this.longueurPlateauChoisi;
      this.choixReponse.mode=this.modeChoisi; 
      this.choixReponse.nbJoueurs=this.nbJoueursChoisi;
      this.ws.send(JSON.stringify(this.choixReponse)); 
      this.PartieChoisie();
       this.$store.commit("setEmailCreateur",this.choixReponse.nomCreateur);
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
    width:60%;
    vertical-align:middle,
}

.droite{
    float:right;
    width:40%;
    vertical-align:middle;
    align-items: center,
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


table{
    position:absolute;
    left:230px;
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