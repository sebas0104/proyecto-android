package com.example.projec11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CompraActivity extends AppCompatActivity {
    TextView campUsu ,campNomJuego,campCateJu,campPrecJ;
    Button btn_fin;
    ImageView imagenDetalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);
        campUsu = findViewById(R.id.campUsu);
        campNomJuego= findViewById(R.id.campNomJuego);
        campCateJu=findViewById(R.id.campCateJu);
        campPrecJ=findViewById(R.id.campPrecJ);
        btn_fin=findViewById(R.id.btn_fin);
        imagenDetalle = findViewById(R.id.imagenDetalle);

        String valor = getIntent().getStringExtra("nickname");
        campUsu.setText(valor.toString());
        String valor2 = getIntent().getStringExtra("nombrejuego2");
        campNomJuego.setText(valor2.toString());
        String valor3 = getIntent().getStringExtra("id_Categoria2");
        campCateJu.setText(valor3.toString());
        String valor4 = getIntent().getStringExtra("precio_juego2");
        campPrecJ.setText(valor4.toString());

        imagenDetalle.setImageResource(R.drawable.check);

        btn_fin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(CompraActivity.this, MainActivity2.class);
                startActivity(intent2);

            }
        });


    }
}
