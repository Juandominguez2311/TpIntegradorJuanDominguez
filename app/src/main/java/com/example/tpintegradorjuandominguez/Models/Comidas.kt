package com.example.tpintegradorjuandominguez.Models

import java.io.Serializable
import java.util.*

data class Comidas (val tipoComida:String, val comidaPrincipal:String, val comidaSecundaria:String, val bebida:String,val postre:String ,val tentacion:String, val alimentoTentacion:String,val hambre:String,val dniComida:String) :Serializable