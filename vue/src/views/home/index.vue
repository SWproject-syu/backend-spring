<template>
  <div>
    <router-link to="/search">금융상품비교</router-link>
    <!-- <button @click="greet">금융상품비교</button> -->
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'

export default defineComponent({
  name: 'AboutPage',
  data() {
    return {
      name: 'Vue.js',
    }
  },
  methods: {
    greet(event) {
      // `this` inside methods points to the current active instance
      alert(`Hello ${this.name}!`)
      // `event` is the native DOM event
      if (event) {
        alert(event.target.tagName)
      }
    },
  },
})
</script>
