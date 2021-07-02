package com.example.tpintegradorjuandominguez

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.tpintegradorjuandominguez.Dao.DBHelper
import com.example.tpintegradorjuandominguez.Models.Paciente


class Registrar : AppCompatActivity() {

  lateinit var nombre: EditText
    lateinit var apellido: EditText
    lateinit var dni: EditText
    lateinit var hombre: RadioButton
    lateinit var mujer: RadioButton
    lateinit var fechaNacimiento: EditText
    lateinit var localidad: EditText
    lateinit var usuario: EditText
    lateinit var contraseña: EditText
    lateinit var anorexia: RadioButton
    lateinit var bulimia: RadioButton
    lateinit var obesidad: RadioButton
    lateinit var guardar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        nombre= findViewById(R.id.et_Nombre)
        apellido= findViewById(R.id.et_apellido)
        dni= findViewById(R.id.et_Dni)
        hombre= findViewById(R.id.rb_Hombre)
        mujer= findViewById(R.id.rb_Mujer)
        fechaNacimiento= findViewById(R.id.et_fechaNacimiento)
        localidad= findViewById(R.id.et_Localidad)
        usuario= findViewById(R.id.et_Usuario)
        contraseña= findViewById(R.id.et_Contraseña)
        anorexia= findViewById(R.id.rb_Anorexia)
        bulimia= findViewById(R.id.rb_Bulimia)
        obesidad= findViewById(R.id.rb_Obesidad)
        guardar=findViewById(R.id.btn_GuardarUsuario)
        val db = DBHelper(this, null)


        var sexo:String=""
            if(hombre.isChecked)
                sexo = "Hombre"
            if (mujer.isChecked)
                sexo="Mujer"
        var tratamiento:String=""
        if(anorexia.isChecked){
            tratamiento="Anorexia"
        }else if(bulimia.isChecked){
            tratamiento="Bulimia"
        }else{
            tratamiento="Obesidad"
        }




        guardar.setOnClickListener(View.OnClickListener {

            db.guardarPaciente(Paciente(nombre.text.toString(), apellido.text.toString(), dni.text.toString(), sexo, fechaNacimiento.text.toString(), localidad.text.toString(), usuario.text.toString(), contraseña.text.toString(), tratamiento))
            Toast.makeText(it.context, "Persona guardada correctamente", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }
}