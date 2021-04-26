package com.it.yb.mysongapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MoreInfoActivity extends Activity {

    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);

        tv1=findViewById(R.id.tv1);

        Intent i=getIntent();
        String stSingerName = i.getExtras().getString("key1");
        Toast.makeText(this, ""+stSingerName, Toast.LENGTH_SHORT).show();
        tv1.setText(stSingerName);
    }
}