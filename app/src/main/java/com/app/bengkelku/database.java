package com.app.bengkelku;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Asnur on 4/19/2017.
 */

public class database extends SQLiteOpenHelper {
    final static String DB_NAME = "db_smk";

    public database(Context context) {
        super(context, DB_NAME, null, 1);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS servis(_id INTEGER PRIMARY KEY AUTOINCREMENT, nama TEXT, alamat TEXT, info TEXT, kategori Text, img BLOB, lat TEXT, lng TEXT)";
        db.execSQL(sql);

        ContentValues values = new ContentValues();

// MOTOR HONDA
        values.put("_id", "1");
        values.put("nama", "Astra Honda Yogyakarta");
        values.put("alamat", " Jl. Monjali No.159, Karangwaru, Tegalrejo, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55241");
        values.put("info", "Buka Pukul 08.00-17.00\n" +
                "No Telpon (0274) 582131");
        values.put("kategori","Honda");
        values.put("img", R.drawable.astramotorjogja);
        values.put("lat", "-7.766600");
        values.put("lng", "110.369150");
        db.insert("servis", "_id", values);

        values.put("_id", "12");
        values.put("nama", "Astra Honda Yogyakarta");
        values.put("alamat", " Jl. Afandi No.159, Gejayan, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55241");
        values.put("info", "Buka Pukul 08.00-17.00\n" +
                "No Telpon (0274) 582131");
        values.put("kategori","Honda");
        values.put("img", R.drawable.astramotorjogja);
        values.put("lat", "-7.766600");
        values.put("lng", "110.369150");
        db.insert("servis", "_id", values);


//MOTOR YAMAHA
        values.put("_id", "11");
        values.put("nama", "Yamaha Mataram Sakti");
        values.put("alamat", " Jalan A. M. Sangaji No. 92, Karangwaru, Tegalrejo, Karangwaru, Tegalrejo, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55241");
        values.put("info", "Buka Pukul 08.00-17.00\n" +
                "No Telpon (0274) 551336");
        values.put("kategori","Yamaha");
        values.put("img", R.drawable.yamahamataram);
        values.put("lat", "-7.771978");
        values.put("lng", "110.368384");
        db.insert("servis", "_id", values);

        values.put("_id", "11");
        values.put("nama", "Yamaha Mataram Sakti");
        values.put("alamat", " Jalan A. M. Sangaji No. 92,  Daerah Istimewa Yogyakarta 55241");
        values.put("info", "Buka Pukul 08.00-17.00\n" +
                "No Telpon (0274) 551336");
        values.put("kategori","Yamaha");
        values.put("img", R.drawable.yamahamataram);
        values.put("lat", "-7.771978");
        values.put("lng", "110.368384");
        db.insert("servis", "_id", values);


//MOTOR SUZUKI
        values.put("_id", "2");
        values.put("nama", "Suzuki");
        values.put("alamat", "  Jl. Laksda Adisucipto KM. 7,5, Caturtunggal, Kecamatan Depok, Caturtunggal, Kec. Depok, yogyakarta, Daerah Istimewa Yogyakarta 55281");
        values.put("info", "Buka Pukul 08.00-17.00\n" +
                "No Telpon (0274) 485555");
        values.put("kategori","Suzuki");
        values.put("img", R.drawable.suzuki);
        values.put("lat", "-7.783075 ");
        values.put("lng", "110.417362");
        db.insert("servis", "_id", values);


//MOTOR KAWASAKI
        values.put("_id", "3");
        values.put("nama", "Sharp");
        values.put("alamat", " Jalan Solo Km");
        values.put("info", "Buka Pukul 08.00-17.00\n" +
                "No Telpon 0274000001");
        values.put("kategori","Kawasaki");
        values.put("img", R.drawable.imv1);
        values.put("lat", "-7.9131197");
        values.put("lng", "110.0588402");
        db.insert("servis", "_id", values);

        values.put("_id", "4");
        values.put("nama", "Yamaha");
        values.put("alamat", " Jalan Solo Km");
        values.put("info", "Buka Pukul 08.00-17.00\n" +
                "No Telpon 0274000001");
        values.put("kategori","Motor");
        values.put("img", R.drawable.imv1);
        values.put("lat", "-7.9131197");
        values.put("lng", "110.0588402");
        db.insert("servis", "_id", values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS wisata or tum or servis");
        onCreate(db);


    }

}