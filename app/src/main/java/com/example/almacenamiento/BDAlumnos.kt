package com.example.almacenamiento

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BDAlumnos(context: Context) : SQLiteOpenHelper(context, "BDAlumnos.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE Alumnos(control VARCHAR(8) NOT NULL, nombre VARCHAR(50) NOT NULL)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}