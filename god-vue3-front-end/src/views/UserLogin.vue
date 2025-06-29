<template>
  <div class="auth-container">
    <div class="auth-card">
      <h1>欢迎登录管理后台</h1>
      <form @submit.prevent="handleLogin">
        <input v-model="username" type="text" placeholder="用户名" required />
        <input v-model="password" type="password" placeholder="密码" required />
        <button type="submit">登录</button>
        <p v-if="error" class="error">{{ error }}</p>
      </form>
      <div class="switch-link">
        还没有账号？<a @click.prevent="goRegister" href="#">注册</a>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, defineEmits } from 'vue'
import { useRouter } from 'vue-router'
const username = ref('admin')
const password = ref('')
const error = ref('')
const emit = defineEmits(['login-success'])
const router = useRouter()

function handleLogin() {
  if (!username.value || !password.value) {
    error.value = '用户名和密码不能为空'
    return
  }

  const validUsers = [
    { user: 'admin', pass: '123456' },
    { user: 'test', pass: 'test123' }
  ]

  const isValid = validUsers.some(u => u.user === username.value && u.pass === password.value)

  if (isValid) {
    error.value = ''
    localStorage.setItem('isLogin', 'true')
    emit('login-success')
    router.push('/dashboard')
  } else {
    error.value = '用户名或密码错误'
  }
}
function goRegister() {
  router.push('/register')
}
</script>

<style scoped>
.auth-container {
  min-height: 100vh;
  width: 100vw;
  background: linear-gradient(120deg, #101820 60%, #00ff99 100%);
  display: flex;
  align-items: center;
  justify-content: center;
  overflow: hidden;
}
.auth-card {
  background: #181f2aee;
  border-radius: 16px;
  box-shadow: 0 0 32px #00ff9955, 0 0 2px #fff;
  padding: 2.5rem 2.5rem 2rem 2.5rem;
  width: 100%;
  max-width: 420px;
  color: #e0ffe0;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.auth-card h1 {
  color: #00ff99;
  margin-bottom: 2rem;
  text-shadow: 0 0 8px #00ff99;
  font-size: 1.6rem;
}
.auth-card form {
  display: flex;
  flex-direction: column;
  gap: 1.2rem;
  width: 100%;
}
.auth-card input {
  padding: 0.7rem 1rem;
  border: none;
  border-radius: 8px;
  background: #232b39;
  color: #e0ffe0;
  font-size: 1rem;
  outline: none;
  box-shadow: 0 0 8px #00ff9955 inset;
  transition: box-shadow 0.2s;
}
.auth-card input:focus {
  box-shadow: 0 0 16px #00ff99;
}
.auth-card button {
  padding: 0.7rem;
  background: linear-gradient(90deg, #00ff99 60%, #00ffcc 100%);
  color: #101820;
  border: none;
  border-radius: 8px;
  font-size: 1.1rem;
  font-weight: bold;
  cursor: pointer;
  box-shadow: 0 0 12px #00ff99;
  transition: background 0.2s, color 0.2s;
}
.auth-card button:hover {
  background: linear-gradient(90deg, #00ffcc 60%, #00ff99 100%);
  color: #101820;
}
.error {
  color: #ff4c4c;
  text-align: center;
  margin-top: 0.5rem;
}
.switch-link {
  margin-top: 1.2rem;
  color: #e0ffe0;
  font-size: 0.98rem;
}
.switch-link a {
  color: #00ff99;
  text-decoration: underline;
  cursor: pointer;
  margin-left: 0.3rem;
}
.switch-link a:hover {
  color: #00ffcc;
}
@media (max-width: 600px) {
  .auth-card {
    max-width: 98vw;
    padding: 1.2rem 0.5rem 1rem 0.5rem;
  }
}
</style> 