package com.example.projec11;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class licenciaUser extends AppCompatActivity {
    TextView campUser ,campEmail;
    Button btn_continua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_licencia);
        campUser = findViewById(R.id.campUser);
        campEmail= findViewById(R.id.campEmail);
        btn_continua=findViewById(R.id.btn_continua);

        String valore = getIntent().getStringExtra("id2");
        String valore2 = getIntent().getStringExtra("nombrejuego2");
        String valore3 = getIntent().getStringExtra("id_Categoria2");
        String valore4 = getIntent().getStringExtra("precio_juego2");

        String valoridu = getIntent().getStringExtra("id_user");
        String valornick = getIntent().getStringExtra("nickname");
        campUser.setText(valornick.toString());
        String valornom = getIntent().getStringExtra("nombre");
        String valorema = getIntent().getStringExtra("email");
        campEmail.setText(valorema.toString());


        btn_continua.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Registrar(view);
                Intent intent2 = new Intent(licenciaUser.this, CompraActivity.class);
                intent2.putExtra("id2", valore);

                intent2.putExtra("nombrejuego2", valore2);

                intent2.putExtra("id_Categoria2", valore3);

                intent2.putExtra("precio_juego2", valore4);

                intent2.putExtra("id_user", valoridu);
                intent2.putExtra("nickname", valornick);
                intent2.putExtra("nombre", valornom);
                intent2.putExtra("email", valorema);

                startActivity(intent2);

            }
        });

    }
    public void Registrar(View view){
        ProyectoAdminSQLiteHelper admin= new ProyectoAdminSQLiteHelper(this,"administracion",null,1);
        SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();



        String valoridu = getIntent().getStringExtra("id_user");
        String valore = getIntent().getStringExtra("id2");
        String valore4 = getIntent().getStringExtra("precio_juego2");

        if (!valoridu.isEmpty()){

            ContentValues registro=new ContentValues();
            registro.put("id_user",valoridu);
            registro.put("id_juego",valore);
            registro.put("precio_venta",valore4);

            BaseDeDatos.insert("Venta",null,registro);
            BaseDeDatos.close();
            Toast.makeText(this,"Compra exitosa. Usuario con codigo "+valoridu+", compra del juego con codigo "+valore+" con precio "+valore4,Toast.LENGTH_LONG).show();

        }else{Toast.makeText(this,"Debes llenar todos los campos apropiadamente",Toast.LENGTH_LONG).show();}
        //Toast.makeText(this,"Debes llenar todos los campos apropiadamente",Toast.LENGTH_LONG).show();
    }
}
