package com.example.projec11;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.BreakIterator;


public class panActivity extends AppCompatActivity {
    TextView campNom ,campCate , campDes , campPre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pan);

          campNom= findViewById(R.id.campNom);
         campCate= findViewById(R.id.campCate);
         campDes= findViewById(R.id.campDes);
         campPre= findViewById(R.id.campPre);

      Buscar();


    }

    private void Buscar() {
        String valor = getIntent().getStringExtra("id");
        TextView campId = findViewById(R.id.campId);
        campId.setText(valor.toString());

        ProyectoAdminSQLiteHelper admin = new ProyectoAdminSQLiteHelper(this,"administracion",null,1);
        SQLiteDatabase BaseDeDatos= admin.getWritableDatabase();
        String codigo= campId.getText().toString();

        if (!codigo.isEmpty()){
            Cursor fila = BaseDeDatos.rawQuery("select nombrejuego,id_Categoria,descripcion_juego,precio_juego from Juego where id_juego="+codigo,null);

            if(fila.moveToFirst()){
                campNom.setText(fila.getString(0));
                campCate.setText(fila.getString(1));
                campDes.setText(fila.getString(2));
                campPre.setText(fila.getString(3));
                BaseDeDatos.close();
            }else {
                Toast.makeText(this,"No existe el Docente",Toast.LENGTH_LONG).show();
                BaseDeDatos.close();
            }
        }else{
            Toast.makeText(this,"Debes introducir el código del Docente",Toast.LENGTH_LONG).show();
        }
    }
}
