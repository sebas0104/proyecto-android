package com.example.projec11;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarCompra extends AppCompatActivity implements View.OnClickListener {
    EditText et_contraseña ,et_id_user , et_nickname , et_nombre , et_apellido ,
            et_emeil, et_fecha_naci , et_pais , et_departamen , et_Direccion;
    Button btnIns, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        et_id_user= findViewById(R.id.et_id_user);

        et_nickname=findViewById(R.id.et_nickname);

        et_contraseña=findViewById(R.id.et_contraseña);

        et_nombre=findViewById(R.id.et_nombre);

        et_apellido=findViewById(R.id.et_apellido);

        et_emeil=findViewById(R.id.et_emeil);

        //et_fecha_naci=findViewById(R.id.et_fecha_naci);

        //et_pais=findViewById(R.id.et_pais);


        //et_departamen=findViewById(R.id.et_departamen);


        et_Direccion=findViewById(R.id.et_Direccion);

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

        String usuario= et_id_user.getText().toString();

        String Nickname=et_nickname.getText().toString();

        String contraseña=et_contraseña.getText().toString();

        String Nombre=et_nombre.getText().toString();

        String Apellido=et_apellido.getText().toString();

        String Email=et_emeil.getText().toString();


        String Fecha_Nacimiento=et_fecha_naci.getText().toString();


        String Pais=et_pais.getText().toString();

        String Departamento=et_departamen.getText().toString();

        String Direccion=et_Direccion.getText().toString();




        if (!usuario.isEmpty() && !Nickname.isEmpty() && !contraseña.isEmpty() && !Nombre.isEmpty()
                && !Apellido.isEmpty() && !Email.isEmpty() && !Fecha_Nacimiento.isEmpty() && !Pais.isEmpty()
                && !Departamento.isEmpty() && !Direccion.isEmpty()){

            ContentValues registro=new ContentValues();

            registro.put("usuario",usuario);

            registro.put("Nickname",Nickname);

            registro.put("contraseña",contraseña);

            registro.put("Nombre",Nombre);

            registro.put("Apellido",Apellido);

            registro.put("Email",Email);

            registro.put("Fecha_Nacimiento",Fecha_Nacimiento);

            registro.put("Pais",Pais);

            registro.put("Departamento",Departamento);

            registro.put("Direccion",Direccion);



            BaseDeDatos.insert("Usuario",null,registro);

            BaseDeDatos.close();

            et_id_user.setText("");

            et_nickname.setText("");

            et_contraseña.setText("");

            et_nombre.setText("");

            et_apellido.setText("");

            et_emeil.setText("");

            et_fecha_naci.setText("");

            et_pais.setText("");

            et_departamen.setText("");

            et_Direccion.setText("");


            Toast.makeText(this,"Registro exitoso",Toast.LENGTH_SHORT).show();

        }else{Toast.makeText(this,"Debes llenar todos los campos",Toast.LENGTH_SHORT).show();}

    }
    public void login(View view){
        Intent intent = new Intent(RegistrarCompra.this , Login.class);
        startActivity(intent);
    }
}