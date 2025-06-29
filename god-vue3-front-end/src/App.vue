<script setup>
import { ref, computed } from 'vue'
import { useRoute, useRouter, RouterView } from 'vue-router'

// 模拟登录状态
const isLogin = ref(localStorage.getItem('isLogin') === 'true')
const router = useRouter()
const route = useRoute()

function handleLogout() {
  isLogin.value = false
  localStorage.removeItem('isLogin')
  router.push('/login')
}

// 监听路由，未登录时强制跳转到登录页
if (!isLogin.value && route.path !== '/login' && route.path !== '/register') {
  router.push('/login')
}

// 登录页判断
const isAuthPage = computed(() => route.path === '/login' || route.path === '/register')
</script>

<template>
  <div>
    <template v-if="isAuthPage">
      <RouterView @login-success="isLogin.value == true" @register-success="router.push('/login')" />
    </template>
    <template v-else>
      <div class="admin-layout dark-theme">
        <aside class="sidebar">
          <div class="logo">⚡ 酷炫后台</div>
          <nav>
            <router-link to="/dashboard"><span class="icon">🏠</span>仪表盘</router-link>
            <router-link to="/user"><span class="icon">👤</span>用户管理</router-link>
            <router-link to="/permission"><span class="icon">🔒</span>权限管理</router-link>
          </nav>
        </aside>
        <div class="main">
          <header class="header">
            <span class="header-title">欢迎来到酷炫管理后台</span>
            <button class="logout-btn" @click="handleLogout">退出登录</button>
          </header>
          <main class="content">
            <RouterView />
          </main>
        </div>
      </div>
    </template>
  </div>
</template>

<style scoped>
:root {
  --theme-green: #00ff99;
  --theme-dark: #101820;
  --theme-dark2: #181f2a;
  --theme-dark3: #232b39;
  --theme-text: #e0ffe0;
  --theme-accent: #00ffcc;
}
.dark-theme {
  background: var(--theme-dark);
  color: var(--theme-text);
  min-height: 100vh;
}
.admin-layout {
  display: flex;
  min-height: 100vh;
  background: linear-gradient(120deg, #101820 60%, #00ff99 100%);
}
.sidebar {
  width: 220px;
  background: linear-gradient(160deg, #181f2a 80%, #00ff99 120%);
  color: var(--theme-text);
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 2rem 0;
  box-shadow: 2px 0 16px #00ff9955;
  z-index: 2;
}
.logo {
  font-size: 2rem;
  font-weight: bold;
  margin-bottom: 2.5rem;
  letter-spacing: 2px;
  color: var(--theme-green);
  text-shadow: 0 0 12px #00ff99, 0 0 2px #fff;
}
.sidebar nav {
  display: flex;
  flex-direction: column;
  gap: 2rem;
  width: 100%;
  align-items: center;
}
.sidebar a {
  color: var(--theme-text);
  text-decoration: none;
  font-size: 1.2rem;
  padding: 0.7rem 2rem;
  border-radius: 8px;
  transition: background 0.2s, color 0.2s, box-shadow 0.2s;
  display: flex;
  align-items: center;
  letter-spacing: 1px;
  box-shadow: 0 0 0 #00ff99;
}
.sidebar a .icon {
  margin-right: 0.7rem;
  font-size: 1.3rem;
}
.sidebar a.router-link-exact-active,
.sidebar a:hover {
  background: var(--theme-green);
  color: #101820;
  box-shadow: 0 0 12px #00ff99;
}
.main {
  flex: 1;
  display: flex;
  flex-direction: column;
  background: var(--theme-dark2);
}
.header {
  background: var(--theme-dark3);
  padding: 1.2rem 2.5rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-bottom: 1px solid #00ff99;
  box-shadow: 0 2px 12px #00ff9955;
  z-index: 1;
}
.header-title {
  font-size: 1.3rem;
  font-weight: 600;
  letter-spacing: 1px;
  color: var(--theme-green);
  text-shadow: 0 0 8px #00ff99;
}
.logout-btn {
  background: var(--theme-green);
  color: #101820;
  border: none;
  border-radius: 6px;
  padding: 0.5rem 1.3rem;
  font-size: 1rem;
  font-weight: bold;
  cursor: pointer;
  box-shadow: 0 0 8px #00ff99;
  transition: background 0.2s, color 0.2s;
}
.logout-btn:hover {
  background: var(--theme-accent);
  color: #101820;
}
.content {
  flex: 1;
  padding: 2.5rem;
  background: linear-gradient(120deg, #181f2a 60%, #00ff99 200%);
  min-height: 0;
  box-shadow: 0 0 24px #00ff9955 inset;
  border-radius: 12px;
  margin: 2rem 2rem 2rem 0;
}
</style>
