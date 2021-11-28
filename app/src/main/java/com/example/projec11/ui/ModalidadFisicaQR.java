package com.example.projec11.ui;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projec11.CompraActivity;
import com.example.projec11.CompraActivityQR;
import com.example.projec11.ProyectoAdminSQLiteHelper;
import com.example.projec11.R;
import com.example.projec11.licenciaUser;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import kotlin.collections.UArraySortingKt;
import kotlin.collections.unsigned.UArraysKt;

public class ModalidadFisicaQR extends AppCompatActivity {
    Button btGenera;
    ImageView ivOutput;
    TextView campUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprafisica);
        btGenera =findViewById(R.id.btn_genera);
        ivOutput =findViewById(R.id.ev_output);
        campUser = findViewById(R.id.campUser);

        String valore = getIntent().getStringExtra("id2");
        String valore2 = getIntent().getStringExtra("nombrejuego2");
        String valore3 = getIntent().getStringExtra("id_Categoria2");
        String valore4 = getIntent().getStringExtra("precio_juego2");

        String valoridu = getIntent().getStringExtra("id_user");
        String valornick = getIntent().getStringExtra("nickname");
        campUser.setText(valornick.toString());
        String valornom = getIntent().getStringExtra("nombre");
        String valorema = getIntent().getStringExtra("email");


        btGenera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                /*String sText = valore2.trim();
                //String sText = etInput.getText().toString().trim();
                MultiFormatWriter writer =new MultiFormatWriter();
                try {
                    BitMatrix matrix = writer.encode(sText, BarcodeFormat.QR_CODE,350,350);
                    BarcodeEncoder encoder = new BarcodeEncoder();
                    Bitmap bitmap =encoder.createBitmap(matrix);
                    ivOutput.setImageBitmap(bitmap);
                    InputMethodManager manager = (InputMethodManager) getSystemService(
                            Context.INPUT_METHOD_SERVICE
                    );
                    //manager.hideSoftInputFromWindow(etInput.getApplicationWindowToken(),0);
                }catch (WriterException e){
                    e.printStackTrace();
                }*/
                Registrar(view);

                Intent intent2 = new Intent(ModalidadFisicaQR.this, CompraActivityQR.class);
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

        /*String codigou="1";
        String codigoj=campId.getText().toString();
        String precio=campPre.getText().toString();*/

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
