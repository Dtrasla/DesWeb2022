<template>
  <h1>Reservar</h1>
  <div class="contenedor">
    <div class="grid-container">
      <div class="grid-child purple">
        <!-- Grid Column 1 -->
        <h1>Toures</h1>

        <v-row align="center">
          <v-col cols="20">
            <v-select :items="hotelSelect" >
              
            </v-select>

          </v-col>
        </v-row>
      </div>

      <div class="grid-child green">
        <!-- Grid Column 2 -->
        <h1>Destino</h1>
        <h1> {{selectedTouris}} </h1>
        <v-row align="center" 
              >
          <v-col cols="20">
            <v-select 
              :items="hotelSelect" 
              :disabled="disableHotel"
              v-model = "selectedTouris"
             >
            </v-select>
          </v-col>
        </v-row>
      </div>

      <div class="texto">
        <h1>Campo Txt</h1>
        <v-text-field v-model="opcion" :rules="namerules" :counter="15" label="First name" required>
        </v-text-field>
      </div>

      <div class="tercero">
        <!-- Grid Column 2 -->
        <v-btn elevation="2" large outlined > Aceptar </v-btn>
      </div>
    </div>
  </div>
</template>

<script>
import { getAllHotels } from "@/services/HotelService";

class Hotel {
  constructor(id = "", name = "", address = "") {
    this.id = id;
    this.name = name;
    this.address = address;
  }
}

export default {
  data() {
    return {
      hotel: new Hotel(),
      hotels: [],
      hotelSelect:[],
      selectedTouris: '',
      disableHotel: false
    };
  },
  created() {
    this.getHotels();
  },
  methods: {
    async getHotels() {
      this.hotels = await getAllHotels();
      this.hotels.forEach(hotelito => {
        this.hotelSelect.push(hotelito.name);
      })
    },
    selectedTour(event){
      console.log("llege");
      console.log(event.target.value)
      console.log(this.selectedTouris);
    }
  },
  watch:{

  }
};

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
