<script>
import SidebarComponent from './components/sidebar/sidebar-component.vue';
import { sidebarWidth } from '@/components/sidebar/state'

  export default {
    components:{ SidebarComponent },
  setup() {
    return { sidebarWidth }
  }
  }

</script>

<template>
  <SidebarComponent/>
  <div :style="{ 'margin-left': sidebarWidth }">
    <router-view />
  </div>
  <!--nav-->
    <!--router-link to="/">Home<!/--router-link-> |
    <router-link to="/about">About</router-link>
  </nav-->
  <!--router-view-->
</template> 


<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
