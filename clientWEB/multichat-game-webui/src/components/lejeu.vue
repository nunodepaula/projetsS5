
<template>
<div>
<div class="ligne1">
<Lacase @change="changeValeur($event,position,0)" v-for="(valeur,position) in carre[0]" :key="position" :filename="valeur"/>
</div>
<div class="ligne2">
<Lacase @change="changeValeur($event,position,1)" v-for="(valeur,position) in carre[1]" :key="position" :filename="valeur"/>
</div>
<div class="ligne3">
<Lacase @change="changeValeur($event,position,2)" v-for="(valeur,position) in carre[2]" :key="position" :filename="valeur"/>
</div>
</div>
</template>
<script>
import Lacase from "../components/Lacase.vue"
export default {
  name: 'lejeu',
  data(){
    return{
      carre: [["vide.png","vide.png","vide.png"],["vide.png","vide.png","vide.png"],["vide.png","vide.png","vide.png"]]
    }
  },

  methods:{
    changeValeur(state,position,ligne){
      console.log(position)
      if(state=="vide.png"){
        this.carre[ligne][position]="rond.png"
        return}
      if(state=="rond.png"){
        this.carre[ligne][position]="croix.png"
        return}
      if(state=="croix.png"){
        this.carre[ligne][position]="vide.png"
        return }
        }
    },
    
  
  components:{
    Lacase,
  }
  }
  
</script>

