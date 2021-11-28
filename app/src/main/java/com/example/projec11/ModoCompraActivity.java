package com.example.projec11;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projec11.ui.ModalidadFisicaQR;

public class ModoCompraActivity extends AppCompatActivity implements View.OnClickListener{
    TextView campNomc ,campCatec ,campPrec, campIdc;
    Button btn_compf,btn_compd;
    ImageView imagenDetallec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modocompra);
        campNomc= findViewById(R.id.campNomc);
        campCatec= findViewById(R.id.campPre);
        campPrec= findViewById(R.id.campPrec);
        campIdc= findViewById(R.id.campIdc);

        imagenDetallec = findViewById(R.id.imagenDetallec);
        btn_compf=findViewById(R.id.btn_compf);
        btn_compf.setOnClickListener(this);

        btn_compd=findViewById(R.id.btn_compd);
        btn_compd.setOnClickListener(this);

        String valore = getIntent().getStringExtra("id2");
        TextView campIdc = findViewById(R.id.campIdc);
        campIdc.setText(valore.toString());

        imagenDetallec.setImageResource(R.drawable.cart);

        String valore2 = getIntent().getStringExtra("nombrejuego2");
        TextView campNomc = findViewById(R.id.campNomc);
        campNomc.setText(valore2.toString());

        String valore3 = getIntent().getStringExtra("id_Categoria2");
        TextView campCatec = findViewById(R.id.campCatec);
        campCatec.setText(valore3.toString());

        String valore4 = getIntent().getStringExtra("precio_juego2");
        TextView campPrec = findViewById(R.id.campPrec);
        campPrec.setText(valore4.toString());

        String valoridu = getIntent().getStringExtra("id_user");
        String valornick = getIntent().getStringExtra("nickname");
        String valornom = getIntent().getStringExtra("nombre");
        String valorema = getIntent().getStringExtra("email");

        btn_compd.setOnClickListener(new View.OnClickListener() {
            // int codigo = 2;
            @Override
            public void onClick(View view) {
                /*Registrar(view);*/
                Intent intent2 = new Intent(ModoCompraActivity.this, licenciaUser.class);
                intent2.putExtra("id_user", valoridu);
                intent2.putExtra("nickname", valornick);
                intent2.putExtra("nombre", valornom);
                intent2.putExtra("email", valorema);

                intent2.putExtra("id2", valore);

                intent2.putExtra("nombrejuego2", valore2);

                intent2.putExtra("id_Categoria2", valore3);

                intent2.putExtra("precio_juego2", valore4);

                startActivity(intent2);

            }
        });
        btn_compf.setOnClickListener(new View.OnClickListener() {
            // int codigo = 2;
            @Override
            public void onClick(View view) {
                /*Registrar(view);*/
                Intent intent2 = new Intent(ModoCompraActivity.this, ModalidadFisicaQR.class);
                intent2.putExtra("id_user", valoridu);
                intent2.putExtra("nickname", valornick);
                intent2.putExtra("nombre", valornom);
                intent2.putExtra("email", valorema);

                intent2.putExtra("id2", valore);

                intent2.putExtra("nombrejuego2", valore2);

                intent2.putExtra("id_Categoria2", valore3);

                intent2.putExtra("precio_juego2", valore4);
                startActivity(intent2);

            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_compf:

                break;
        }

    }

}
