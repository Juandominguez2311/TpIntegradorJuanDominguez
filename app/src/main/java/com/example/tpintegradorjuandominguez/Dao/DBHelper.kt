package com.example.tpintegradorjuandominguez.Dao
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.tpintegradorjuandominguez.Models.Comidas
import com.example.tpintegradorjuandominguez.Models.Paciente

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {
    companion object{
        private val DATABASE_NAME: String = "persona.db"
        private val DATABASE_VERSION: Int = 1
        val TABLA_PACIENTE = "paciente"
        val COLUMN_ID = "id"
        val COLUMN_NOMBRE="nombre"
        val COLUMN_APELLIDO="apellido"
        val COLUMN_DNI="dni"
        val COLUMN_SEXO="sexo"
        val COLUMN_FECHANACIMIENTO="fechaNacimiento"
        val COLUMN_LOCALIDAD="localidad"
        val COLUMN_USUARIO="usuario"
        val COLUMN_CONTRASEÑA="contraseña"
        val COLUMN_TRATAMIENTO="tratamiento"

        // HAGO OTRA TABLA
        val TABLA_COMIDAS = "comidas"
        val COLUMN_ID_REGIMEN = "id"
        val COLUMN_ID_PACIENTE = "idPaciente"
        val COLUMN_TIPOCOMIDA="tipoComida"
        val COLUMN_COMIDAPRINCIPAL="comidaPrincipal"
        val COLUMN_COMIDASECUNDARIA="comidaSecundaria"
        val COLUMN_BEBIDA="bebida"
        val COLUMN_POSTRE="postre"
        val COLUMN_Tentacion="tentacion"
        val COLUMN_ALIMENTOTENTACION="alimentoTentacion"
        val COLUMN_QUEDOHAMBRE="hambre"
        val COLUMN_FECHA="fecha"
        val COLUMN_DNI_COMIDA="dniComida"
    }

    override fun onCreate(db: SQLiteDatabase?) {

        val CREATE_Paciente_TABLE = ("CREATE TABLE " +
                TABLA_PACIENTE + "("+
                COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_NOMBRE+ " TEXT,"+
                COLUMN_APELLIDO+" TEXT,"+
                COLUMN_DNI + " TEXT" +
                COLUMN_SEXO + " TEXT" +
                COLUMN_FECHANACIMIENTO + " TEXT" +
                COLUMN_LOCALIDAD + " TEXT" +
                COLUMN_USUARIO+" TEXT,"+
                COLUMN_CONTRASEÑA+" TEXT,"+
                COLUMN_TRATAMIENTO + " TEXT" +")")

        db?.execSQL(CREATE_Paciente_TABLE);

        //CREO LA OTRA TABLA
        val CREATE_COMIDAS_TABLE = ("CREATE TABLE " +
                TABLA_COMIDAS + "("+
                COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_ID_PACIENTE + "FOREING KEY Paciente_TABLE" +
                COLUMN_TIPOCOMIDA + " TEXT,"+
                COLUMN_COMIDAPRINCIPAL +" TEXT,"+
                COLUMN_COMIDASECUNDARIA + " TEXT" +
                COLUMN_BEBIDA + " TEXT" +
                COLUMN_POSTRE + " TEXT" +
                COLUMN_Tentacion + " TEXT" +
                COLUMN_ALIMENTOTENTACION +" TEXT,"+
                COLUMN_QUEDOHAMBRE +" TEXT,"+
                COLUMN_FECHA+ "TEXT"+
                COLUMN_DNI_COMIDA+"TEXT"+")")

        db?.execSQL(CREATE_COMIDAS_TABLE);
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        if(oldVersion != newVersion){
            db?.execSQL("DROP TABLE TABLE IF EXIST"+ TABLA_PACIENTE )
            onCreate(db)
        }
        if(oldVersion != newVersion){
            db?.execSQL("DROP TABLE TABLE IF EXIST"+ TABLA_COMIDAS)
            onCreate(db)
        }
    }
        fun guardarPaciente(p: Paciente){

            val db = this.writableDatabase

            val values = ContentValues()
            values.put(COLUMN_NOMBRE, p.nombre)
            values.put(COLUMN_APELLIDO, p.apellido)
            values.put(COLUMN_DNI, p.dni)
            values.put(COLUMN_SEXO, p.sexo)
            values.put(COLUMN_FECHANACIMIENTO, p.fechaNacimiento)
            values.put(COLUMN_LOCALIDAD, p.localidad)
            values.put(COLUMN_USUARIO, p.usuario)
            values.put(COLUMN_CONTRASEÑA, p.contraseña)
            values.put(COLUMN_TRATAMIENTO, p.tratamiento)


            db.insert(TABLA_PACIENTE,null,values)
        }
    fun guardarRegimen(c: Comidas){

        val db = this.writableDatabase

        val values = ContentValues()
        values.put(COLUMN_TIPOCOMIDA, c.tipoComida)
        values.put(COLUMN_COMIDAPRINCIPAL, c.comidaPrincipal)
        values.put(COLUMN_COMIDASECUNDARIA, c.comidaSecundaria)
        values.put(COLUMN_BEBIDA, c.bebida)
        values.put(COLUMN_POSTRE, c.postre)
        values.put(COLUMN_Tentacion, c.tentacion)
        values.put(COLUMN_ALIMENTOTENTACION, c.alimentoTentacion)
        values.put(COLUMN_QUEDOHAMBRE, c.hambre)
        values.put(COLUMN_DNI_COMIDA, c.dniComida)





        db.insert(TABLA_COMIDAS,null,values)
    }

    fun obtenerPersonas():ArrayList<Paciente>{

        val query = "SELECT * FROM" + TABLA_PACIENTE
        val listaPaciente: ArrayList<Paciente> = ArrayList<Paciente>()
        val db = this.readableDatabase

        val cursor: Cursor = db.rawQuery(query,null)

        if(cursor.moveToFirst()){

            do {
                val nom = cursor.getString(cursor.getColumnIndex("nombre"))
                val ape = cursor.getString(cursor.getColumnIndex("apellido"))
                val dni = cursor.getString(cursor.getColumnIndex("dni"))
                val sex = cursor.getString(cursor.getColumnIndex("sexo"))
                val fec = cursor.getString(cursor.getColumnIndex("fechaNacimiento"))
                val loc = cursor.getString(cursor.getColumnIndex("localidad"))
                val usu = cursor.getString(cursor.getColumnIndex("usuario"))
                val con = cursor.getString(cursor.getColumnIndex("contraseña"))
                val tra = cursor.getString(cursor.getColumnIndex("tratamiento"))
                listaPaciente.add(Paciente(nom,ape,dni,sex,fec,loc,usu,con,tra))
            }while(cursor.moveToNext())

        }


     return listaPaciente
    }
    fun obtenerRegimen():ArrayList<Comidas> {
        val query = "SELECT * FROM" + TABLA_COMIDAS
        val listaRegimen: ArrayList<Comidas> = ArrayList<Comidas>()
        val db = this.readableDatabase

        val cursor: Cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {

            do {
                val tip = cursor.getString(cursor.getColumnIndex("tipoComida"))
                val cpr = cursor.getString(cursor.getColumnIndex("comidaPrincipal"))
                val cse = cursor.getString(cursor.getColumnIndex("comidaSecundaria"))
                val beb = cursor.getString(cursor.getColumnIndex("bebida"))
                val pos = cursor.getString(cursor.getColumnIndex("postre"))
                val ten = cursor.getString(cursor.getColumnIndex("tentacion"))
                val ate = cursor.getString(cursor.getColumnIndex("alimentoTentacion"))
                val ham = cursor.getString(cursor.getColumnIndex("hambre"))
                val dni = cursor.getString(cursor.getColumnIndex("dniComida"))


                listaRegimen.add(Comidas(tip, cpr, cse, beb, pos, ten, ate, ham, dni))
            } while (cursor.moveToNext())

        }
        return listaRegimen
    }
}