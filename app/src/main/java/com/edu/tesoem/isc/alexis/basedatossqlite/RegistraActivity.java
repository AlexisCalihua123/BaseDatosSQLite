package com.edu.tesoem.isc.alexis.basedatossqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.DefaultTaskExecutor;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.edu.tesoem.isc.alexis.basedatossqlite.BaseDatos.DatosConexion;
import com.edu.tesoem.isc.alexis.basedatossqlite.BaseDatos.DatosHelper;

public class RegistraActivity extends AppCompatActivity {
EditText txtnombre, txtedad, txtsexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registra);
        txtnombre = findViewById(R.id.txtNombre);
        txtedad = findViewById(R.id.txtEdad);
        txtsexo= findViewById(R.id.txtSexo);

    }
    public  void regista_registro(View v){
        ContentValues contentValues = new ContentValues();
        DatosConexion datosConexion = new DatosConexion(this);
        datosConexion.open();
        contentValues.put("nombre",txtnombre.getText().toString());
        contentValues.put("edad",txtedad.getText().toString());
        contentValues.put("sexo",txtsexo.getText().toString());
        if (datosConexion.insertar(contentValues)){

            Toast.makeText(this, "Se registro correctamente", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this, "No se pudo guardar ", Toast.LENGTH_SHORT).show();
        }
  datosConexion.close();
    }
}
