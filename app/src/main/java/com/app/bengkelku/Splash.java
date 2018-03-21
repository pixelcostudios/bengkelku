package com.app.bengkelku;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Context context = getApplicationContext(); // or activity.getApplicationContext()
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                Intent i = new Intent(getBaseContext(),BaseActivity.class);
//                startActivity(i);
//                finish();

                startActivity(new Intent(getBaseContext(), MainActivity.class));
                finish();
            }
        }, 3000);
    }
}

