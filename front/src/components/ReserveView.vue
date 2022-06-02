<template>
  <div class="contenedor">
    <div class="grid-container">
      <div class="grid-child purple">
        <!-- Grid Column 1 -->
        <h1>Origen</h1>
        <select v-model="selected">
          <option disabled value="">Please select one</option>
          
        </select>
        <v-row align="center">
          <v-col cols="20">
            <v-select><option>A</option>
            <option>B</option>
            <option>C</option></v-select>
            
          </v-col>
        </v-row>
      </div>

      <div class="grid-child green">
        <!-- Grid Column 2 -->
        <h1>Destino</h1>
        <select v-model="selected">
          <option disabled value="">Please select one</option>
          <option>A</option>
          <option>B</option>
          <option>C</option>
        </select>
      </div>

      <div class="texto">
        <h1>Campo Txt</h1>
        <input v-model="message" placeholder="edit me" />
      </div>

      <div class="tercero">
        <!-- Grid Column 2 -->
        <button>Aceptar</button>
      </div>
    </div>
  </div>
</template>

<script>
// var vm = new Vue({
//   el: 'body',
//   data: {
//     'choices': [1, 2, 3, 4, 5]
//   }
// });
</script>

<style scoped>
h3 {
  margin: 40px 0 0;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}

.grid-container {
  height: inherit;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-gap: 20px;
  background-color: aliceblue;
  justify-content: center;
}

.contenedor {
  margin: 40pt;
  height: 30vh;

  background-color: aliceblue;
}

.tercero {
  display: flex;
  align-items: center;
}
</style>
