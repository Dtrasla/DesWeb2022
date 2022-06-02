import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../components/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/tour',
    name: 'tour-formulario',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../components/TourFormularioView.vue')
  },
  {
    path: '/divis',
    name: 'vista-hoteles',
    component: () => import('../components/ReserveView.vue')
  },
  {
    path: '/registro',
    name: 'registro-usuario',
    component: () => import('../components/FormularioUser.vue')

  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
