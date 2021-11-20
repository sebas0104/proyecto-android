package com.example.projec11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar extends AppCompatActivity implements View.OnClickListener {
    EditText et_nickname ,et_emeil , et_contraseña;
    Button btnIns, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        et_nickname=findViewById(R.id.et_nickname);

        et_emeil=findViewById(R.id.et_emeil);

        et_contraseña=findViewById(R.id.et_contraseña);

        btnIns=findViewById(R.id.btn_ins);

        btnIns.setOnClickListener(this);

        btnLogin=findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ins:
                Registrar(v);
            case R.id.btnLogin:
                login(v);
                break;
        }


    }

    public void Registrar(View view){

        ProyectoAdminSQLiteHelper admin= new  ProyectoAdminSQLiteHelper(this,"administracion",null,1);

        SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();


        String Nickname=et_nickname.getText().toString();

        String Email=et_emeil.getText().toString();

        String contraseña=et_contraseña.getText().toString();



        if (!Nickname.isEmpty() && !Email.isEmpty()  && !contraseña.isEmpty()){

            ContentValues registro=new ContentValues();

            registro.put("Nickname",Nickname);

            registro.put("Email",Email);

            registro.put("contraseña",contraseña);



            BaseDeDatos.insert("Usuario",null,registro);

            BaseDeDatos.close();

            et_nickname.setText("");

            et_emeil.setText("");

            et_contraseña.setText("");


            Toast.makeText(this,"Registro exitoso",Toast.LENGTH_SHORT).show();

        }else{Toast.makeText(this,"Debes llenar todos los campos",Toast.LENGTH_SHORT).show();}

    }
    public void login(View view){
        Intent intent = new Intent(Registrar.this , Login.class);
        startActivity(intent);
    }
}