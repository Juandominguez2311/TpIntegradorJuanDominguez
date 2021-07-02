package com.example.tpintegradorjuandominguez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.tpintegradorjuandominguez.Dao.DBHelper
import com.example.tpintegradorjuandominguez.Models.Comidas
import java.text.SimpleDateFormat
import java.util.*

class Principal : AppCompatActivity() {
    lateinit var desayuno: RadioButton
    lateinit var almuerzo: RadioButton
    lateinit var merienda: RadioButton
    lateinit var cena: RadioButton
    lateinit var postreSi: RadioButton
    lateinit var postreNo: RadioButton
    lateinit var tentacionSi: RadioButton
    lateinit var tentacionNo: RadioButton
    lateinit var hambreSi: RadioButton
    lateinit var hambreNo: RadioButton
    lateinit var comidaPrincipal: EditText
    lateinit var comidaSecundaria: EditText
    lateinit var bebida: EditText
    lateinit var dni: EditText
    lateinit var alimentoTentacion: EditText
    lateinit var btn_guardarComida: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val titulo: TextView
        desayuno = findViewById(R.id.rb_Desayuno)
        almuerzo = findViewById(R.id.rb_Almuerzo)
        merienda = findViewById(R.id.rb_Merienda)
        cena = findViewById(R.id.rb_Cena)
        var TipoComida:String =""
        postreSi = findViewById(R.id.rb_PostreSi)
        postreNo = findViewById(R.id.rb_PostreNo)
        var Postre:String =""
        tentacionSi = findViewById(R.id.rb_TentacionSi)
        tentacionNo = findViewById(R.id.rb_TentacionNo)
        var Tentacion:String =""
        hambreSi = findViewById(R.id.rb_HambreSi)
        hambreNo = findViewById(R.id.rb_HambreNo)
        var Hambre:String =""
        comidaPrincipal = findViewById(R.id.et_ComidaPrincipal)
        comidaSecundaria = findViewById(R.id.et_ComidaSecundaria)
        bebida = findViewById(R.id.et_Bebida)
        alimentoTentacion = findViewById(R.id.et_tentacion)
        dni = findViewById(R.id.et_dniRegimen)
        btn_guardarComida = findViewById(R.id.btn_principal)
        val db = DBHelper(this, null)

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate =sdf.format(Date())



        if(desayuno.isChecked){
            TipoComida ="Desayuno"
        }
        if(almuerzo.isChecked){
            TipoComida ="Almuerzo"
        }
        if(merienda.isChecked){
            TipoComida ="Merienda"
        }
        if(cena.isChecked){
            TipoComida ="Cena"
        }

        if(postreSi.isChecked){
            Postre = "si"
        }
        if(postreNo.isChecked){
            Postre = "no"
        }
        if(tentacionSi.isChecked){
            Tentacion = "si"
        }
        if(tentacionNo.isChecked){
            Tentacion = "no"
        }
        if(hambreSi.isChecked){
            Hambre="si"
        }
        if(hambreNo.isChecked){
            Hambre="no"
        }

        btn_guardarComida.setOnClickListener(View.OnClickListener {

            db.guardarRegimen(Comidas(TipoComida,comidaPrincipal.text.toString(),comidaSecundaria.text.toString(),bebida.text.toString(),Postre,Tentacion,alimentoTentacion.text.toString(),Hambre,dni.text.toString()))
            Toast.makeText(it.context, "Regimen guardado correctamente", Toast.LENGTH_LONG).show()
            Toast.makeText(this, currentDate, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }
}