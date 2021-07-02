package com.example.tpintegradorjuandominguez

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tpintegradorjuandominguez.Models.Paciente
import com.example.tpintegradorjuandominguez.Dao.DBHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.btn_ingresar)
        val btn2 = findViewById<Button>(R.id.btn_Registrar)
        val db = DBHelper(this, null)


        btn1.setOnClickListener { view: View? ->
            val intent = Intent(this, FormularioIngreso::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener { view: View? ->
            val intent = Intent(this, Registrar::class.java)
            startActivity(intent)
        }

    }
}