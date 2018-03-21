package com.app.bengkelku;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Asnur on 4/19/2017.
 */

public class DetailTum extends AppCompatActivity implements OnMapReadyCallback{
    ImageView Im;
    TextView tv_nama, tv_alamat, tv_info, tv_kategori, id, tv_lat, tv_lng;
    Gallery gallery;
    ImageSwitcher imageSwitcher;
    Integer[] imageIDs = new Integer[3];
    int msg_im;

    SupportMapFragment mapFragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        Intent iIdentifikasi = getIntent();
        msg_im = iIdentifikasi.getIntExtra("dataIM", 0);
        final String msg_nama = iIdentifikasi.getStringExtra("dataNama");
        String msg_alamat = iIdentifikasi.getStringExtra("dataAlamat");
        String msg_info = iIdentifikasi.getStringExtra("dataInfo");
        String msg_kategori = iIdentifikasi.getStringExtra("dataKategori");
        final String msg_lat = iIdentifikasi.getStringExtra("dataLat");
        final String msg_lng = iIdentifikasi.getStringExtra("dataLng");

        Im = (ImageView) findViewById(R.id.iv_detail);
        tv_nama = (TextView) findViewById(R.id.tvNama);
        tv_alamat = (TextView) findViewById(R.id.tvAlamat);
        tv_info = (TextView) findViewById(R.id.tvInfo);
        tv_kategori = (TextView) findViewById(R.id.tvKategori);
        tv_lat = (TextView) findViewById(R.id.tvLat);
        tv_lng = (TextView) findViewById(R.id.tvLng);

        Im.setImageResource(msg_im);
        tv_nama.setText(msg_nama);
        tv_alamat.setText(msg_alamat);
        tv_info.setText(msg_info);
        tv_kategori.setText(msg_kategori);
        tv_lat.setText(msg_lat);
        tv_lng.setText(msg_lng);

        Button btn_lokasi = (Button)findViewById(R.id.btn_lokasi);

        btn_lokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Uri gmmIntentUri = Uri.parse("geo:"+ msg_lat +","+ msg_lng +"?q="+msg_nama);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        Intent iIdentifikasi = getIntent();
        msg_im = iIdentifikasi.getIntExtra("dataIM", 0);
        final String msg_nama = iIdentifikasi.getStringExtra("dataNama");
        String msg_alamat = iIdentifikasi.getStringExtra("dataAlamat");
        String msg_info = iIdentifikasi.getStringExtra("dataInfo");
        String msg_kategori = iIdentifikasi.getStringExtra("dataKategori");
        final Double msg_lat = Double.valueOf(iIdentifikasi.getStringExtra("dataLat"));
        final Double msg_lng = Double.valueOf(iIdentifikasi.getStringExtra("dataLng"));
//        googleMap.addMarker(new MarkerOptions()
//                .position(new LatLng(37.4233438, -122.0728817))
//                .title("LinkedIn")
//                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(msg_lat,msg_lng))
                .title(msg_nama)
                .snippet(msg_alamat));

//        googleMap.addMarker(new MarkerOptions()
//                .position(new LatLng(37.3092293, -122.1136845))
//                .title("Apple"));

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(msg_lat, msg_lng), 10));

    }
}
