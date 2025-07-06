import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router/index.js'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import 'element-plus/theme-chalk/dark/css-vars.css'

const app = createApp(App)
document.documentElement.classList.add('dark')
app.use(router)
app.use(ElementPlus)

app.mount('#app')
