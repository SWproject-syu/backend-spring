import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { createPinia } from 'pinia'

// vuetify
import 'vuetify/dist/vuetify.min.css'

createApp(App).use(router).use(createPinia()).mount('#app')
