package com.unlimitedappworks.u3_3;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLWarning;

/**
 * Created by Luis Fernando on 04/05/2016.
 */
public class EnlaceBD {
    private SQLiteDatabase bd;

    public EnlaceBD(Context context) {
        SQLiteOpenHelper sql = new SQLiteOpenHelper(context, "ife", null, 1) {
            @Override
            public void onCreate(SQLiteDatabase db) {
                db.execSQL("create table votantes(ife text, nombre_votante text, direccion text, num_casilla integer);");
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            }
        };
        bd = sql.getWritableDatabase();
    }

    public void execSQL(String sql) {
        bd.execSQL(sql);
    }

    public Cursor consulta(String sql){
        return bd.rawQuery(sql, null);
    }
}
