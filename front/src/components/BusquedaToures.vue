<template>
    <div class="buscarToures">


        <v-row class="busq" align="center" justify="center">
            <v-text-field class="busqueda" label="Hotel a buscar" required>
            </v-text-field>
            <v-btn class="buscarTourBoton" dark color="pink"> SEARCH </v-btn>
        </v-row>



        <div class="respuesta">
            <v-card class="mx-auto" max-width="300" tile>
                <v-list >
                    <v-subheader>Resultados</v-subheader>
                    <v-list-item-group v-model="selectedItem" color="primary">
                        <v-list-item v-for="(tour, i) in tours" :key="i">
                            
                            <v-list-item-content>
                                <v-list-item-title v-text="tour.name"></v-list-item-title>
                            </v-list-item-content>
                        </v-list-item>
                    </v-list-item-group>
                </v-list>
            </v-card>

        </div>


    </div>



</template>



<script>
import { getAllTours } from "@/services/TourService";

class Tour {

  constructor(id = "", name = "", date = "") {
    this.id = id;
    this.name = name;
    this.date = date;
  }
}

export default {
  data() {
    return {
      tour: new Tour(),
      tours: [],
      tourSelect:[]
    };
  },
  created() {
    this.getTours();
  },
  methods: {
    async getTours() {
      this.tours = await getAllTours();
      this.tours.forEach(tou => {
        this.tourSelect.push(tou.name);
      })
    },
  },
};


//   export default {
//     data: () => ({
//       selectedItem: 1,
//       items: [
//       ],
//     }),
//   }
</script>


<style scoped>
.buscarToures {
    margin: auto;
    width: 50%;
    border: 3px solid green;
    padding: 10px;
}

.busqueda {
    padding-top: 20pt;
}


.respuesta {
    height: fit-content;

}
</style>