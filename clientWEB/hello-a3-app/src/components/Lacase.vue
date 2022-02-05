<template>
    <button v-on:click="changeEtat" class="test"><img :src="require(`@/assets/${filename}`)"></button>
</template>
<script>
export default {
  name: 'Lacase',
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
.test{
    height:200px;
    width:200px;
}
</style>
