package com.example.projec11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.projec11.databinding.ActivityMain2Binding;
import com.example.projec11.databinding.ActivityMainBinding;
import com.example.projec11.ui.pan.PanFragment;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity2  extends AppCompatActivity {
ViewFlipper v_flipper;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
      int images[] ={R.drawable.dd,R.drawable.juego, R.drawable.tojue, R.drawable.portadal,R.drawable.nuevos_videojuegos_junio_2018};

        v_flipper = findViewById(R.id.v_fliter);

        for(int image:images){
            flipperImagenes(image);
        }
        ImageView imageView1 = findViewById(R.id.imgP5);
        ImageView imageView2 = findViewById(R.id.imgDoa6);
        ImageView imageView3 = findViewById(R.id.imgSmtst);
        ImageView imageView4 = findViewById(R.id.imgFifa);
        ImageView imageView5 = findViewById(R.id.imgCrash);
        ImageView imageView6 = findViewById(R.id.imgTekken);

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
                intent.putExtra("id_user", "1");
                intent.putExtra("nickname", "Sebas0104");
                intent.putExtra("nombre", "Sebastian");
                intent.putExtra("email", "Sebas0104@hotmail.com");
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
                intent.putExtra("id_user", "1");
                intent.putExtra("nickname", "Sebas0104");
                intent.putExtra("nombre", "Sebastian");
                intent.putExtra("email", "Sebas0104@hotmail.com");
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
                intent.putExtra("id_user", "1");
                intent.putExtra("nickname", "Sebas0104");
                intent.putExtra("nombre", "Sebastian");
                intent.putExtra("email", "Sebas0104@hotmail.com");
                startActivity(intent);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext (),
                        panActivity.class);
                intent.putExtra("id", "5");
                intent.putExtra("nombrejuego", "PS5 FIFA 22");
                intent.putExtra("id_Categoria", "Deportivo");
                intent.putExtra("descripcion_juego", "FIFA 22 es un videojuego de fútbol desarrollado por EA Vancouver y EA Romania, siendo publicado por EA Sports");
                intent.putExtra("precio_juego", "S/.200.0");
                intent.putExtra("id_user", "1");
                intent.putExtra("nickname", "Sebas0104");
                intent.putExtra("nombre", "Sebastian");
                intent.putExtra("email", "Sebas0104@hotmail.com");
                startActivity(intent);
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext (),
                        panActivity.class);
                intent.putExtra("id", "6");
                intent.putExtra("nombrejuego", "CRASH BANDICOOT TRILOGÍA N SANE");
                intent.putExtra("id_Categoria", "Aventura");
                intent.putExtra("descripcion_juego", "Tu marsupial favorito Mejorado, embelesado y listo para bailar con la colección de juegos La trilogía.");
                intent.putExtra("precio_juego", "S/.200.0");
                intent.putExtra("id_user", "1");
                intent.putExtra("nickname", "Sebas0104");
                intent.putExtra("nombre", "Sebastian");
                intent.putExtra("email", "Sebas0104@hotmail.com");
                startActivity(intent);
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext (),
                        panActivity.class);
                intent.putExtra("id", "7");
                intent.putExtra("nombrejuego", "Tekken 7");
                intent.putExtra("id_Categoria", "Pelea");
                intent.putExtra("descripcion_juego", "Tekken (En español: Puño de hierro) es una serie de videojuegos de lucha.");
                intent.putExtra("precio_juego", "S/.99.0");
                intent.putExtra("id_user", "1");
                intent.putExtra("nickname", "Sebas0104");
                intent.putExtra("nombre", "Sebastian");
                intent.putExtra("email", "Sebas0104@hotmail.com");
                startActivity(intent);
            }
        });
    }
    public void flipperImagenes(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(3000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this, android.R.anim.slide_out_right);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);


    }
}
