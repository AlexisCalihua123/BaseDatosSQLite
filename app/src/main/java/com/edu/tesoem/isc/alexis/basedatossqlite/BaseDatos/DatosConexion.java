package com.edu.tesoem.isc.alexis.basedatossqlite.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.edu.tesoem.isc.alexis.basedatossqlite.BaseDatos.DatosHelper.tabladatos;

public class DatosConexion {
    private SQLiteDatabase basedatos;
    private  DatosHelper datosHelper;
    private Context context;

    public DatosConexion(Context context) {
        this.context = context;
    }
    public DatosConexion open(){

        datosHelper =new DatosHelper(context);
        basedatos = datosHelper.getWritableDatabase();
        return this;
    }
    public  void  close(){
        datosHelper.close();
    }
    public boolean insertar (ContentValues contentValues){
        boolean estado = true ;
        int resultadoconsulta = (int) basedatos.insert(tabladatos.TABLA, null   ,contentValues);
        if (resultadoconsulta < 0) estado = false;
        return estado;

    }
}
