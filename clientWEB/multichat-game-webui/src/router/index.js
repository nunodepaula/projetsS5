import { createRouter, createWebHashHistory } from 'vue-router'
import Login from '../components/Login.vue'
import Maison from '../components/Maison.vue'
import lejeu from '../components/lejeu.vue'
import lechat from '../components/Lechat.vue'
const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: "/maison/:lenom",
    name: "Maison",
    component: Maison
  },
  {
    path: "/maison/:lenom/tictactoe",
    name: "lejeu",
    component: lejeu
  },
  {
    path: "/maison/:lenom/lechat",
    name: "lechat",
    component: lechat
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
