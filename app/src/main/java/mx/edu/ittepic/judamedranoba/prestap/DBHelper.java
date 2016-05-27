package mx.edu.ittepic.judamedranoba.prestap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by juanjose on 21/05/2016.
 */
public class DBHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Prestamotap.db";
    public static final String TABLA_PRESTAMOS = "prestamos";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOMBREOBJ = "nombre";
    public static final String COLUMN_NOMBREDES="descripcion";
    public static final String COLUMN_FECHAPRES="fprestado";
    public static final String COLUMN_FECHADEV="fdevolucion";
    public static final String COLUMN_STATUS="estado";
    public static final String COLUMN_PRESTAVIENTE="prestaviente";

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE "+TABLA_PRESTAMOS+"("+
                COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_NOMBREOBJ+" TEXT, "+
                COLUMN_NOMBREDES+ " TEXT, "+
                COLUMN_FECHAPRES+ " TEXT, "+
                COLUMN_FECHADEV+" TEXT, "+
                COLUMN_STATUS+ " TEXT, "+
                COLUMN_PRESTAVIENTE+" TEXT "+
                ");";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLA_PRESTAMOS);
        onCreate(sqLiteDatabase);
    }

    public void addprestamo(Prestamo prestamo){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBREOBJ,prestamo.getNombreobj());
        values.put(COLUMN_NOMBREDES,prestamo.getDescripcionobj());
        values.put(COLUMN_FECHAPRES,prestamo.getFechapres());
        values.put(COLUMN_FECHADEV,prestamo.getFechadev());
        values.put(COLUMN_STATUS,prestamo.getStatus());
        values.put(COLUMN_PRESTAVIENTE,prestamo.getPrestaviente());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLA_PRESTAMOS,null,values);
        db.close();
    }

    public void dropprestamo(int prestamo_id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLA_PRESTAMOS+" WHERE "+COLUMN_ID+ " = "+prestamo_id+";");
        db.close();
    }

    public Cursor listaprestamo(){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM "+TABLA_PRESTAMOS+" WHERE 1 ORDER BY "+COLUMN_FECHADEV+";";
        Cursor c = db.rawQuery(query,null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }
}
