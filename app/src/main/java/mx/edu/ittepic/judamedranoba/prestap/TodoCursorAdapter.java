package mx.edu.ittepic.judamedranoba.prestap;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by juanjose on 26/05/2016.
 */
public class TodoCursorAdapter extends CursorAdapter{
    public TodoCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.consulta, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView idtxt = (TextView) view.findViewById(R.id.id_txt);
        TextView tipoObj = (TextView) view.findViewById(R.id.tipo_text);
        TextView nombreObj = (TextView) view.findViewById(R.id.nombreO_txt);

        // Extraccion de las propiedades del cursor

        int txtid = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        String txttipoObj = cursor.getString(cursor.getColumnIndexOrThrow("prestaviente"));
        String txtnombreObj = cursor.getString(cursor.getColumnIndexOrThrow("fdevolucion"));

        idtxt.setText(String.valueOf(txtid));
        tipoObj.setText(txttipoObj);
        nombreObj.setText(txtnombreObj);
    }
}
