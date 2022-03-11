<template>
    <button v-on:click="changeEtat" class="test"><img :src="require(`@/assets/${filename}`)" class="monimage"></button>
</template>
<script>
export default {
  name: 'carte',
  data(){
    return{   
    }
  },
  methods: {
    changeEtat(){
      this.$emit("change",this.filename)
    }
    },
  props:{
      filename:String,
    }
}
</script>
<style>

.monimage{
    height:200px;
    width:150px;
}
.test{
    margin-left:20px;
       margin-bottom:20px;
    background-color:white;
}
</style>