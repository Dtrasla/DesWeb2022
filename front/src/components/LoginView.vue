<template>
 <v-form
    ref="form"
    v-model="valid"
    lazy-validation
  >
  <h1> {{email}} </h1>
  <h1> {{password}} </h1>
    <v-text-field
      v-model="email"
      :rules="emailRules"
      label="E-mail"
      required
    ></v-text-field>

    <v-text-field
            v-model="password"
            :append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
            :rules="[rules.required, rules.min]"
            :type="show1 ? 'text' : 'password'"
            name="input-10-1"
            label="Contraseña"

            counter
            @click:append="show1 = !show1"
          ></v-text-field>


    <v-btn
      :disabled="!valid"
      color="success"
      class="mr-4"
      @click="validate"
    >
      Ingresar
    </v-btn>


    <v-btn
      color="warning"
      @click= "registrar()"
    >
      Registrar nuevo usuario
    </v-btn>
  </v-form>

</template>
<script>
  import { logIn } from "@/services/LoginService";
 

  export default {
    data () {
      return {
        show1: false,
        password: '',
        rules: {
          required: value => !!value || 'Required.',
          emailMatch: () => (`The email and password you entered don't match`),
          valid: true,
          
        },
        email: '',
          emailRules: [
            v => !!v || 'E-mail is required',
            v => /.+@.+\..+/.test(v) || 'E-mail must be valid',
          ]
      }
    },

    data1: () => ({
      
      
    }),
    methods: {
      validate () {
        const body = {
          "email": this.email,
          "password": this.password};
        logIn(body);
      },
      registrar(){
            this.$router.push('/registro'); 
      }
    },
    

  }
  
</script>