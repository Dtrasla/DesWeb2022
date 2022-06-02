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
                        <v-list-item v-for="(item, i) in items" :key="i">
                            
                            <v-list-item-content>
                                <v-list-item-title v-text="item.text"></v-list-item-title>
                            </v-list-item-content>
                        </v-list-item>
                    </v-list-item-group>
                </v-list>
            </v-card>

        </div>


    </div>



</template>



<script>
  export default {
    data: () => ({
      selectedItem: 1,
      items: [
        { text: 'Real-Time' },
        { text: 'Audience'},
        { text: 'Conversions' },
      ],
    }),
  }
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