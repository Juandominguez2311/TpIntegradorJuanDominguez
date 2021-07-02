package com.example.tpintegradorjuandominguez.Models

import java.io.Serializable

data class Paciente(val nombre: String, val apellido: String, val dni:String,var sexo:String,val fechaNacimiento:String,val localidad:String, val usuario: String, val contraseña: String, var tratamiento:String ) :Serializable