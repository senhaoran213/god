<template>
  <div class="auth-container">
    <div class="auth-card">
      <h1>注册新账号</h1>
      <form @submit.prevent="handleRegister">
        <input v-model="username" type="text" placeholder="用户名" required />
        <input v-model="password" type="password" placeholder="密码" required />
        <input v-model="confirm" type="password" placeholder="确认密码" required />
        <button type="submit">注册</button>
        <p v-if="error" class="error">{{ error }}</p>
        <p v-if="success" class="success">注册成功，请登录！</p>
      </form>
      <div class="switch-link">
        已有账号？<a @click.prevent="goLogin" href="#">去登录</a>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, defineEmits } from 'vue'
import { useRouter } from 'vue-router'
const username = ref('')
const password = ref('')
const confirm = ref('')
const error = ref('')
const success = ref(false)
const emit = defineEmits(['register-success'])
const router = useRouter()

function handleRegister() {
  if (!username.value || !password.value || !confirm.value) {
    error.value = '请填写所有字段'
    return
  }
  if (password.value !== confirm.value) {
    error.value = '两次密码不一致'
    return
  }
  if (username.value === 'admin' || username.value === 'test') {
    error.value = '该用户名已存在'
    return
  }
  error.value = ''
  success.value = true
  setTimeout(() => {
    emit('register-success')
  }, 1200)
}
function goLogin() {
  router.push('/login')
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
}
.auth-card {
  background: #181f2aee;
  border-radius: 20px;
  box-shadow: 0 0 48px #00ff9955, 0 0 2px #fff;
  padding: 3rem 3rem 2.5rem 3rem;
  min-width: 340px;
  max-width: 480px;
  width: 100%;
  color: #e0ffe0;
  display: flex;
  flex-direction: column;
  align-items: center;
  backdrop-filter: blur(2px);
}
.auth-card h1 {
  color: #00ff99;
  margin-bottom: 2.2rem;
  text-shadow: 0 0 12px #00ff99, 0 0 2px #fff;
  font-size: 2rem;
  font-weight: 700;
  letter-spacing: 2px;
}
.auth-card form {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
  width: 100%;
}
.auth-card input {
  padding: 1rem 1.2rem;
  border: none;
  border-radius: 10px;
  background: #232b39;
  color: #e0ffe0;
  font-size: 1.1rem;
  outline: none;
  box-shadow: 0 0 12px #00ff9955 inset;
  transition: box-shadow 0.2s;
}
.auth-card input:focus {
  box-shadow: 0 0 24px #00ff99;
}
.auth-card button {
  padding: 1rem;
  background: linear-gradient(90deg, #00ff99 60%, #00ffcc 100%);
  color: #101820;
  border: none;
  border-radius: 10px;
  font-size: 1.2rem;
  font-weight: bold;
  cursor: pointer;
  box-shadow: 0 0 18px #00ff99;
  transition: background 0.2s, color 0.2s;
  letter-spacing: 1px;
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
.success {
  color: #00ff99;
  text-align: center;
  margin-top: 0.5rem;
}
.switch-link {
  margin-top: 1.5rem;
  color: #e0ffe0;
  font-size: 1rem;
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
    min-width: 0;
    max-width: 98vw;
    padding: 1.2rem 0.5rem 1rem 0.5rem;
  }
  .auth-card h1 {
    font-size: 1.3rem;
  }
}
</style> 