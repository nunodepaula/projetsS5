import { createRouter, createWebHashHistory } from 'vue-router'
import Login from '../components/Login.vue'
import choixpartie from '../components/choixpartie.vue'
import memoire from '../components/memoire.vue'
const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },

  {
    path:'/partie/:lenom',
    name: 'choixpartie',
    component:choixpartie
  },

  {
    path:'/partie/:lenom/memoire',
    name: 'memoire',
    component:memoire
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
