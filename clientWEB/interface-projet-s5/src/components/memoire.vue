
<template>
<h1>C'est partie</h1>
<div class="gameboard">
<div v-for="(row,index) in this.mesCartes" :key="index">
<carte :class="{invisible:!carteTrouve[index][num]}" @change="sendReponse(index,num)" v-for="(macarte,num) in row" :filename="macarte" :key="num"/>
</div>
<div class="score">
<div class="contenu">
<div v-for="[emailkey,scoredata] in this.joueurScore" :key="emailkey">
<h2>{{emailkey}}:{{scoredata}}</h2>
</div>
</div>
</div>
</div>
</template>


<script>
import carte from '../components/carte.vue'
import axios from "axios"
export default {
  name: 'memoire',
  mounted(){
    this.initMesCartes();
    this.getIdentifiant();
  },
  data(){
      return{
        ws:null,
        verrou:0,
        identifiant:0,
        joueurScore:new Map(),
        taille:this.$store.getters.getTaille,
        monemail:this.$store.getters.getLeUser,
        url:"http://localhost:8080/services/identifiant/",
        mesCartes:[],
        ligne:[],
        ligneTrouve:[],
        carteTrouve:[],
        serverUrl:"",
        memoryMessage: {
        valeur:"",  
        colonne: 0,
        ligne: 0,
        emailCreateur:"",
        emailScoreMaj:"",
        score:0,
      },
      memoryReponse: {
        valeur:"",
        colonne: 0,
        ligne: 0,
      },
      }
  },
  function:{
    
  },
  methods:{
    sendReponse(colonne,ligne){
      if((this.mesCartes[colonne][ligne]=="cacher.png")&&(this.verrou!=1)){
      this.memoryReponse.colonne = colonne;
      this.memoryReponse.ligne = ligne; 
      this.ws.send(JSON.stringify(this.memoryReponse)); 
      console.log(colonne);
      console.log(ligne);
      }
    },

    getIdentifiant(){
    console.log(this.$store.getters.getEmailCreateur);
    this.url=this.url+this.$store.getters.getEmailCreateur;
    console.log(this.url);
    console.log("Appel service Rest ...")
    axios.get(this.url
    ).then((response) => {
    console.log(response.data);
    this.identifiant = response.data;
    this.MemoryConnect();
    });
  },

    initMesCartes(){
      for(var i=0;i<this.taille;i++){
        this.ligne=[];
        this.ligneTrouve=[];
        for(var j=0;j<this.taille;j++){
        this.ligne.push('cacher.png');
        this.ligneTrouve.push(true);
        }
         this.mesCartes.push(this.ligne);
         this.carteTrouve.push(this.ligneTrouve);
      }
    },
    handleNewMessage(event) {

        console.log(event.data);
        this.memoryMessage = JSON.parse(event.data);
        console.log(this.memoryMessage.emailCreateur);
        if((this.memoryMessage.valeur!="trouver")&&(this.memoryMessage.valeur!="cacher")&&(this.memoryMessage.valeur!=null)){
             this.mesCartes[this.memoryMessage.colonne][this.memoryMessage.ligne]=this.memoryMessage.valeur+".png";
        }
        if(this.memoryMessage.valeur=="trouver"){
            this.verrou=1;
            setTimeout(() =>{this.reinitialisationCarte("trouver.png");},2000);
        }
        if(this.memoryMessage.valeur=="cacher"){
          this.verrou=1;
          setTimeout(() =>{this.reinitialisationCarte("cacher.png");},2000);
          console.log("=======>test");
           }
        if(this.memoryMessage.valeur=="danstaface"){
          this.carteTrouve[this.memoryMessage.colonne][this.memoryMessage.ligne]=true;
          this.mesCartes[this.memoryMessage.colonne][this.memoryMessage.ligne]="cacher.png";
        }
        if(this.memoryMessage.emailCreateur!=null){
          this.joueurScore.set(this.memoryMessage.emailCreateur,this.memoryMessage.score);
        }}
  ,
    MemoryBye(){
        this.ws.close();
        this.ws = null;
        this.chatAllMessage='';
    },

    
    MemoryConnect() {     
      console.log("Starting connection to WebSocket Server");
      this.serverUrl = "ws://localhost:8080/ws/memory/"+this.identifiant+':'+ this.$store.getters.getLeUser
      this.ws = new WebSocket( this.serverUrl );
      this.ws.onopen = function (event) {
        console.log(event);
        console.log("On est connecté au jeu début de partie!!!");
      };
      this.ws.addEventListener('message', (event) => { this.handleNewMessage(event) });
    },

    reinitialisationCarte(nouveletat){
      for(var i=0;i<this.mesCartes.length;i++ ){
        for(var j=0;j<this.mesCartes[i].length;j++){
          if((this.mesCartes[i][j]!="cacher.png")&&(this.mesCartes[i][j]!="trouver.png")){
            this.mesCartes[i][j]=nouveletat;
            if(nouveletat=="trouver.png"){
            this.carteTrouve[i][j]=false;
            console.log(this.carteTrouve[i][j]);
          }
          }
        }
      }
      this.verrou=0;
    }
    },
components:{
    carte,
  }
  }
</script>

<style>


.invisible{
  visibility:hidden;
}
.gameboard{
  float:left;
  width:90%
}
.score{
  float:right;
  width:10%
}
.contenu{
  position:absolute;
  top:250px;
  padding:20px;
}


</style>