<template>
  <v-form
    ref="form"
    v-model="valid"
    lazy-validation
  >
    <v-text-field
      v-model="name"
      :rules="nameRules"
      label="Correo"
      required
    ></v-text-field>

     <v-text-field
      v-model="password"
       type="password"
      :rules="nameRules"
      label="Contraseña"
      required
    ></v-text-field>


    <v-btn
      :disabled="!valid"
      color="success"
      class="mr-4"
      @click="Ingresar"
    >
      Ingresar
    </v-btn>


    <v-btn
      color="warning"
      @click="resetValidation"
    >
      Registrar nuevo usuario
    </v-btn>
  </v-form>
</template>