import { createStore } from 'vuex'

export default createStore({
  state: {
    leuser:"",
    taillejeu:0,
    emailcreateur:"",
  },

  getters:{
    getLeUser(state){
      return state.leuser
    },
    getTaille(state){
      return state.taillejeu
    },
    getEmailCreateur(state){
      return state.emailcreateur
    }
  },
  mutations: {
    setLeUser(state, nom){
    state.leuser = nom
    },
    setTaille(state,taille){
      state.taillejeu=taille
    },
    setEmailCreateur(state,emailc){
      state.emailcreateur=emailc
    }
  },
  actions: {
  },
  modules: {
  }
})
