<template>
    <div>
    <h1>Mon app</h1>
    {{ info }}
    </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
    ws : null,
    serverUrl: "ws://localhost:8085/ws/multichat/1:Mikky",
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
    axios.get("http://localhost:8085/services/multichat/1").then((response) => {
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
      this.ws = new WebSocket( this.serverUrl );
      this.ws.onopen = function (event) {
        console.log(event);
        console.log("On est connecté !!!");
      };
      this.ws.addEventListener('message', (event) => { this.handleNewMessage(event) });
    }
  },
};
</script>