package com.example.projec11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.projec11.databinding.ActivityMain2Binding;
import com.example.projec11.databinding.ActivityMainBinding;
import com.example.projec11.ui.pan.PanFragment;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity2  extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageView imageView1 = findViewById(R.id.imgP5);
        ImageView imageView2 = findViewById(R.id.imgDoa6);
        ImageView imageView3 = findViewById(R.id.imgSmtst);

        imageView2.setOnClickListener(new View.OnClickListener() {
            // int codigo = 2;
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,
                        panActivity.class);
                intent.putExtra("id", "1");

                intent.putExtra("nombrejuego", "Dead or Alive 6");

                intent.putExtra("id_Categoria", "Peleas");

                intent.putExtra("descripcion_juego", "Dead or Alive 6 es la sexta entrega principal de lucha en la franquicia Dead or Alive.");


                intent.putExtra("precio_juego", "S/. 190.0");


                //intent.putExtra("id", "1");

                startActivity(intent);

            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext (),
                        panActivity.class);
                intent.putExtra("id", "2");

                intent.putExtra("nombrejuego", "Persona 5");

                intent.putExtra("id_Categoria", "JRPG");

                intent.putExtra("descripcion_juego", "Persona 5 es un videojuego de rol desarrollado por Atlus." +
                        " Cronológicamente se trata del sexto videojuego de la saga Persona, que forma parte de la franquicia Megami Tensei.");


                intent.putExtra("precio_juego", "S/. 90.0");


                //intent.putExtra("id", "1");
                startActivity(intent);

            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext (),
                        panActivity.class);
                intent.putExtra("id", "3");


                intent.putExtra("nombrejuego", "Shin Megami Tensei: Strange Journey");

                intent.putExtra("id_Categoria", "JRPG");

                intent.putExtra("descripcion_juego", "Shin Megami Tensei: Strange Journey es un juego de rol desarrollado por Atlus en colaboración con Lancarse, para la plataforma Nintendo DS");


                intent.putExtra("precio_juego", "S/.244.0");


                startActivity(intent);

            }
        });
    }
}
