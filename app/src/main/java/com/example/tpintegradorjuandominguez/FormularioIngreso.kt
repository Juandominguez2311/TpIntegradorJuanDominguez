package com.example.tpintegradorjuandominguez



import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity




class FormularioIngreso : AppCompatActivity() {

    lateinit var usuario: EditText
    lateinit var contraseña: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_ingreso)
        val btn = findViewById<Button>(R.id.btn_Formulario)
        val btn_Volver = findViewById<Button>(R.id.btn_volver)
        usuario=findViewById(R.id.et_UsuarioFormulario)
        contraseña=findViewById(R.id.et_ContraseñaFormulario)

        btn.setOnClickListener { view: View? ->
            val intent = Intent(this, Principal::class.java)
            startActivity(intent)
        }
        btn_Volver.setOnClickListener { view: View? ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

