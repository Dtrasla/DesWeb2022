<template>
  <h1>Touristic Locations 🗺️</h1>
  <div class="tour-formulario">
    <h1>Tours</h1>
  </div>
  <div>
    <v-row align="center">
      <v-col cols="20">
        <v-select 
        :items="hotelSelect"
        v-model="selectTour">
        
        </v-select>
        
      </v-col>
    </v-row>
  </div>
  <ul>
    <div v-for="(hotel, index) in hotels" :key="index">
      <li>
        {{ hotel.id }}
        {{ hotel.name }}
        {{ hotel.address }}
      </li>
    </div>
  </ul>
  <v-btn
      color="warning"
      @click="getAddresses"
    >
      Buscar
  </v-btn>

</template>

<script>
import { getAllAddresses } from "@/services/AddressService";
import { getCityID } from "@/services/CityService";
import { getAllHotels } from "@/services/HotelService";

class Hotel {
  constructor(id = "", name = "", address = "") {
    this.id = id;
    this.name = name;
    this.address = address;
  }
}

class Address {
  constructor(id = "", data = "", zipCode = "", cityId = "") {
    this.id = id;
    this.data = data;
    this.zipCode = zipCode;
    this.cityId = cityId
  }
}

export default {
  data() {
    return {
      hotel: new Hotel(),
      hotels: [],
      hotelSelect:[],
      selectTour: "",
      selectTourValue: "",
      addresses:[],
      selectedAddresses:[],
      cities:[],
      s:new Address()
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
    async getAddresses() {
      this.addresses = [];
      this.addresses = await getAllAddresses();
      this.addresses.filter(address => {

        this.hotels.forEach(h =>{
          if(h.name == this.selectTour){
            this.selectTourValue = h;
          }
        });

        
        if(address.id == this.selectTourValue.address.id){
          this.selectedAddresses.push(address);
        }

      })
      console.log(this.selectedAddresses);
      
      this.selectedAddresses.forEach(address => {
        
        console.log(address);
        var g = getCityID();
        console.log(g);
      })

    },
  },
};
</script>
