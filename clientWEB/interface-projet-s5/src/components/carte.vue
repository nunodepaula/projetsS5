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
    height:100%;
    width:100%;
    display: block;
}
.test{

    height:120px;
    width:75px;
    padding: 0;
    margin: 0;
    vertical-align: top;
    margin-left:10px;
    margin-bottom:10px;
    background-color:orange;
}
</style>