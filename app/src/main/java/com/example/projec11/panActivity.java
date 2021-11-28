package com.example.projec11;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projec11.databinding.ActivityMain2Binding;

import java.text.BreakIterator;


public class panActivity extends AppCompatActivity{



    TextView campNom ,campCate , campDes , campPre, campId;
    Button btn_comp;
    ImageView imagenDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pan);

        campId = findViewById(R.id.campId);
         campNom= findViewById(R.id.campNom);
         campCate= findViewById(R.id.campCate);
         campDes= findViewById(R.id.campDes);
         campPre= findViewById(R.id.campPre);
        imagenDetalle = findViewById(R.id.imagenDetalle);


        btn_comp=findViewById(R.id.btn_comp);

        /*btn_comp.setOnClickListener(this);*/


        String valor = getIntent().getStringExtra("id");
        //TextView campId = findViewById(R.id.campId);
        campId.setText(valor.toString());

        imagenDetalle.setImageResource(R.drawable.pm);


        String valor2 = getIntent().getStringExtra("nombrejuego");
        campNom.setText(valor2.toString());

        String valor3 = getIntent().getStringExtra("id_Categoria");
        campCate.setText(valor3.toString());

        String valor4 = getIntent().getStringExtra("descripcion_juego");
        campDes.setText(valor4.toString());

        String valor5= getIntent().getStringExtra("precio_juego");
        campPre.setText(valor5.toString());

        String valoridu = getIntent().getStringExtra("id_user");
        String valornick = getIntent().getStringExtra("nickname");
        String valornom = getIntent().getStringExtra("nombre");
        String valorema = getIntent().getStringExtra("email");



        btn_comp.setOnClickListener(new View.OnClickListener() {
            // int codigo = 2;
            @Override
            public void onClick(View view) {
                //Registrar(view);
                Intent intent2 = new Intent(panActivity.this, ModoCompraActivity.class);
                intent2.putExtra("id2", valor);

                intent2.putExtra("nombrejuego2", valor2);

                intent2.putExtra("id_Categoria2", valor3);

                intent2.putExtra("precio_juego2", valor5);

                intent2.putExtra("id_user", valoridu);
                intent2.putExtra("nickname", valornick);
                intent2.putExtra("nombre", valornom);
                intent2.putExtra("email", valorema);

                startActivity(intent2);

            }
        });

        //Buscar();


    }


}
