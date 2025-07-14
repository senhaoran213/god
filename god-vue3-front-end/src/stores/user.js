import { defineStore } from 'pinia'

export const useUserStore = defineStore('user', {
  state: () => ({
    token: localStorage.getItem('token') || '',
    // 判断是否登录 !!value === Boolean(value)
    isLogin: !!localStorage.getItem('token'),
    username: '',
  }),
  actions: {
    setToken(token) {
      this.token = token
      this.isLogin = true
      localStorage.setItem('token', token)
    },
    clearToken() {
      this.token = ''
      this.isLogin = false
      localStorage.removeItem('token')
    },
    loginSuccess(data) {
      this.setToken(data.token)
      this.username = data.username || ''
    },
    logout() {
      this.clearToken()
      this.username = ''
    }
  }
})