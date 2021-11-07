package com.example.projec11;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class ProyectoAdminSQLiteHelper extends SQLiteOpenHelper {

    public ProyectoAdminSQLiteHelper( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table Usuario (id_user int primary key, nickname text,contraseña text,nombre text,apellido text,email text,fechanacimento datetime,departamento text,pais text,direccion text,tarjeta text)");
        db.execSQL("create table Categoria (id_categoria int primary key, nombre_categoria text)");
        db.execSQL("create table Juego (id_juego int primary key,id_proveedor int,id_Categoria int,id_plataforma int,nombrejuego text,descripcion_juego text, precio_juego real)");
        db.execSQL("create table Proveedor (id_proveedor int primary key,Nombre text,descripcion text)");
        db.execSQL("create table Empleado (codigo int primary key,Nombre text,Apellido text,contraseña text)");
        db.execSQL("create table Venta (id_venta int primary key,descripcion_venta text, precio_venta real)");
        db.execSQL("create table Plataforma (codigo int primary key,descripcion text)");

        //insertar juegos
        db.execSQL("insert into Juego (id_proveedor,id_Categoria,id_plataforma,nombrejuego,descripcion_juego,precio_juego) values (1,1,1,'Dead or Alive 6','Dead or Alive 6 es la sexta entrega principal de lucha en la franquicia Dead or Alive.',190.0)");
        db.execSQL("insert into Juego (id_proveedor,id_Categoria,id_plataforma,nombrejuego,descripcion_juego,precio_juego) values (1,2,1,'Persona 5','Persona 5 es un videojuego de rol desarrollado por Atlus. Cronológicamente se trata del sexto videojuego de la saga Persona, que forma parte de la franquicia Megami Tensei.',90.0)");
        db.execSQL("insert into Juego (id_proveedor,id_Categoria,id_plataforma,nombrejuego,descripcion_juego,precio_juego) values (2,2,2,'Shin Megami Tensei: Strange Journey','Shin Megami Tensei: Strange Journey es un juego de rol desarrollado por Atlus en colaboración con Lancarse, para la plataforma Nintendo DS.',244.0)");
       //insertar Categoria

        // insertar Proveedor


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
