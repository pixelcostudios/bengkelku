package com.app.bengkelku;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by Asnur on 4/19/2017.
 */

public class honda extends AppCompatActivity {
    protected ListView lv;
    protected ListAdapter adapter;
    SQLiteDatabase db;
    Cursor cursor;
    EditText et_honda;

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.honda);


        db = (new database(this)).getWritableDatabase();
        lv = (ListView) findViewById(R.id.lv);


        try{
            cursor = db.rawQuery("SELECT * FROM servis where kategori='Honda'", null);
            adapter = new SimpleCursorAdapter(this, R.layout.isi_lv, cursor, new String[] {"nama", "alamat", "img"}, new int[] {R.id.tv_nama, R.id.tv_alamat, R.id.imV});
            lv.setAdapter(adapter);
            lv.setTextFilterEnabled(true);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View v,
                                        int position, long id) {
                    detail(position);

                }
            });
        }catch(Exception e){
            e.printStackTrace();
        }

    }




    public void detail(int position){
        int im = 0;
        String _id = "";
        String nama = "";
        String alamat = "";
        String info = "";
        String kategori = "";
        String lat = "";
        String lng = "";
        if(cursor.moveToFirst()){
            cursor.moveToPosition(position);
            im = cursor.getInt(cursor.getColumnIndex("img"));
            nama = cursor.getString(cursor.getColumnIndex("nama"));
            alamat = cursor.getString(cursor.getColumnIndex("alamat"));
            info = cursor.getString(cursor.getColumnIndex("info"));
            kategori = cursor.getString(cursor.getColumnIndex("kategori"));
            lat = cursor.getString(cursor.getColumnIndex("lat"));
            lng = cursor.getString(cursor.getColumnIndex("lng"));
        }

        Intent iIntent = new Intent(this, DetailTum.class);
        iIntent.putExtra("dataIM", im);
        iIntent.putExtra("dataNama", nama);
        iIntent.putExtra("dataAlamat", alamat);
        iIntent.putExtra("dataInfo", info);
        iIntent.putExtra("dataKategori", kategori);
        iIntent.putExtra("dataLat", lat);
        iIntent.putExtra("dataLng", lng);
        setResult(RESULT_OK, iIntent);
        startActivityForResult(iIntent, 99);
    }

}
