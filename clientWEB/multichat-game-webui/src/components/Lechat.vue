<template>
    <div>
    <h1>Mon app</h1>
    <table id='liste-chat'>
        <thread>
            <tr>
                <th>Canaux</th>
            </tr>
        </thread>
        <tbody>
            <tr v-for="row in this.leschat" :key="row">
                <td>{{ row }}</td>
            </tr>
        </tbody>
    </table>
    <h4>Sélectionner un des cannaux ci-dessous</h4>
    <input type=text list=choixCanal v-model="canalChoisi">
    <datalist id="choixCanal">
        <option v-for="row in this.leschat" :key="row"> {{ row }} </option>
    </datalist>

    <button @click="chatConnect">
        Connecter à {{canalChoisi}}
    </button>

    <div>
        <span><pre>{{chatAllMessage}}</pre></span>
    </div>

    <input v-model="reponse" style="width:300px"/>
    <button @click="sendReponse">Répondre</button>
    <p>
        <button @click="chatBye">Bye Bye</button>
    </p>

    </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
    ws : null,
    canalChoisi:"",
    canalId:"",
    serverUrl: "ws://localhost:8080/ws/multichat/1:Mikky",
      leschat: {
        canalId: "",
        canalName: "",
      },
      reponse : '',
      chatMessage: {
        canalId: 0,
        lePseudo: "",
        leContenu: "",
      },
      chatReponse: {
        canalId: 0,
        lePseudo: "",
        leContenu: "",
      },
      chatAllMessage: "",
    };
  },
  mounted() {
    console.log("Appel service Rest ...")
    axios.get("http://localhost:8080/services/canaux-disponibles").then((response) => {
      this.leschat = response.data;
      console.log(this.leschat)
    });
  },
  methods: {
    handleNewMessage(event) {
        console.log(event.data);
        this.chatMessage = JSON.parse(event.data);
        this.chatAllMessage = this.chatAllMessage + this.chatMessage.lePseudo + " : " + this.chatMessage.leContenu + "\n";
    },
    chatBye(){
        this.ws.close();
        this.ws = null;
        this.chatAllMessage='';
    },
    sendReponse(){
      this.chatReponse.lePseudo = this.$store.getters.getLeUser;
      this.chatReponse.leContenu = this.reponse; 
      this.ws.send(JSON.stringify(this.chatReponse)); 
      this.reponse = '';
    },
    chatConnect() {     
      console.log("Starting connection to WebSocket Server");
      this.chatAllMessage = ""
      this.canalId = this.canalChoisi[0];
      this.chatReponse.canalId = this.canalId;
      this.chatMessage.canalId = this.canalId;
      this.serverUrl = "ws://localhost:8080/ws/multichat/"+this.canalId+':'+ this.$store.getters.getLeUser
      this.ws = new WebSocket( this.serverUrl );
      this.ws.onopen = function (event) {
        console.log(event);
        console.log("On est connecté !!!");
        console.log(this.canalId);
      };
      this.ws.addEventListener('message', (event) => { this.handleNewMessage(event) });
    }
  },
};
</script>