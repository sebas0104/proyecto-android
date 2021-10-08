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
        db.execSQL("create table Proveedor (id_proveedor int primary key,contraseña text,descripcion text, precio real)");
        db.execSQL("create table Empleado (codigo int primary key,contraseña text, precio real)");
        db.execSQL("create table Venta (id_venta int primary key,descripcion_venta text, precio_venta real)");
        db.execSQL("create table Plataforma (codigo int primary key,descripcion text, precio real)");




    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
