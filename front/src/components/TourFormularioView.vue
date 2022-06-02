<template>
  <div class="tour-formulario">
    <h1>Tours 🗺️</h1>
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
    };
  },
  created() {
    this.getHotels();
  },
  methods: {
    async getHotels() {
      this.hotels = await getAllHotels();
    },
  },
};
</script>
