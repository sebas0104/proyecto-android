package com.example.projec11;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class CompraActivityQR extends AppCompatActivity {
    TextView campUsu ,campNomJuego,campCateJu,campPrecJ;
    Button btn_fin;
    ImageView ivOutput, imagenDetalle;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compraqr);
        campUsu = findViewById(R.id.campUsu);
        campNomJuego= findViewById(R.id.campNomJuego);
        campCateJu=findViewById(R.id.campCateJu);
        campPrecJ=findViewById(R.id.campPrecJ);
        btn_fin=findViewById(R.id.btn_fin);
        ivOutput =findViewById(R.id.ev_output);
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

        qr();

        btn_fin.setOnClickListener(new View.OnClickListener() {
            // int codigo = 2;
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(CompraActivityQR.this, MainActivity2.class);
                startActivity(intent2);

            }
        });


    }
    public void qr(){
        String valore2 = getIntent().getStringExtra("nombrejuego2");
        String sText = valore2.trim();
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
                }
    }

}
