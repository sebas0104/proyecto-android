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
                startActivity(intent);

            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext (),
                        panActivity.class);
                intent.putExtra("id", "2");
                startActivity(intent);

            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext (),
                        panActivity.class);
                intent.putExtra("id", "3");
                startActivity(intent);

            }
        });
    }
}
