import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/login',
      name: 'login',
      component: () => import('@/views/UserLogin.vue'),
    },
    {
      path: '/dashboard',
      name: 'dashboard',
      component: () => import('@/views/Dashboard.vue'),
    },
    {
      path: '/user',
      name: 'user',
      component: () => import('@/views/User.vue'),
    },
    {
      path: '/permission',
      name: 'permission',
      component: () => import('@/views/Permission.vue'),
    },
    {
      path: '/register',
      name: 'register',
      component: () => import('@/views/Register.vue'),
    },
    {
      path: '/:pathMatch(.*)*',
      name: 'notfound',
      component: () => import('@/views/NotFound.vue'),
    },
    {
      path: '/service',
      name: 'service',
      component: () => import('@/views/ServicePage.vue'),
    },
    {
      path: '/worldcloud',
      name: 'worldcloud',
      component: () => import('@/views/WorldCloud.vue'),
    },
  ],
})

export default router
