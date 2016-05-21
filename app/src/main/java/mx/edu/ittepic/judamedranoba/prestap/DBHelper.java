package mx.edu.ittepic.judamedranoba.prestap;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by juanjose on 21/05/2016.
 */
public class DBHelper extends SQLiteOpenHelper{

    public DBHelper(Context context){
        super(context,"Prestamo.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
