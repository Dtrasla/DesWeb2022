

<template>
    <div class="formulario">

        <div class="nombre">
            <v-text-field v-model="nombre" :rules="namerules" :counter="20" label="Nombre" required>
            </v-text-field>
        </div>

        <div class="apellido">
            <v-text-field v-model="apellido" :rules="namerules" :counter="20" label="Apellido" required>
            </v-text-field>
        </div>

        <div class="correo">
            <v-text-field v-model="correo" label="Correo" required>
            </v-text-field>
        </div>

        <div class="cumple">
            <v-text-field v-model="cumple" label="cumple" required>
            </v-text-field>
        </div>

        <div class="genero">
            <v-text-field v-model="genero" label="genero" required>
            </v-text-field>
        </div>

        <div class="telefono">
            <div class="codigo">
                <v-text-field v-model="codigoPais" label="codigo pais" required>
                </v-text-field>
            </div>


            <div class="num">
                <v-text-field v-model="numero" label="numero" required>
                </v-text-field>
            </div>

        </div>

        <div class="aceptar">
            <v-btn elevation="2" large outlined @click="validate"> Aceptar </v-btn>

        </div>


    </div>
</template>









<script>
import { createUser } from '@/services/UserService';

export default {
    data() {
        return {
            picker: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
            nombre:"",
            apellido:"",
            correo:"",
            cumple:"",
            genero:"",
            codigoPais:"",
            numero:"",
        }
    },methods: {
      validate () {
        const body = {
            "id": "c563e71b-4609-4fa7-bb06-6225f5f0362a",
            "email": this.correo,
            "password": this.apellido,
            "name": this.nombre,
            "lastName": this.apellido,
            "birthday": this.cumple,
            "gender": this.genero
          };
        createUser(body);
        this.$router.push('/registro'); 
      }
    },
}
</script>


<style scoped>
.formulario {
    margin: auto;
    width: 50%;
    border: 3px solid green;
    padding: 10px;
}

.telefono {
    height: inherit;
    display: grid;
    grid-template-columns: 1fr 1fr;
    /* grid-gap: 20px; */
    justify-content: center;
}

.codigo {
    width: 20ch;
}

.num {
    padding-right: 50px;
}
</style>