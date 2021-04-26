package com.it.yb.mysongapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ListView lstView1;
    ArrayList<Song> arySongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstView1=findViewById(R.id.listView1);


        //SongAdapter sa=new SongAdapter(this, R.layout.song, SongDB.getSongData());
        Dal dal=new Dal(this);
        arySongs=dal.getAllSongs();

        SongAdapter sa=new SongAdapter(this, R.layout.song, arySongs);
        lstView1.setAdapter(sa);

        lstView1.setOnItemClickListener(lst1Listener);
        lstView1.setOnItemLongClickListener(lst1LongClick);
    }


    private AdapterView.OnItemClickListener lst1Listener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           Dal dal=new Dal(MainActivity.this);

            Toast.makeText(MainActivity.this,
                    arySongs.get(position).toString(), Toast.LENGTH_LONG).show();

            String st=arySongs.get(position).getSingerName();

            Intent i=new Intent(MainActivity.this, MoreInfoActivity.class);
            i.putExtra("key1", st);
            startActivity(i);



        }
    };

//    private AdapterView.OnItemClickListener lst1Listener_=new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            Toast.makeText(MainActivity.this,
//                    SongDB.getSongData().get(position).toString(), Toast.LENGTH_LONG).show();
//
//            String st=SongDB.getSongData().get(position).getSingerName();
//
//            Intent i=new Intent(MainActivity.this, MoreInfoActivity.class);
//            i.putExtra("key1", st);
//            startActivity(i);
//
//
//
//        }
//    };


    private AdapterView.OnItemLongClickListener lst1LongClick=new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

            final String []shareAry={"Facebook","Twitter","Whatsup"};

            AlertDialog.Builder adb=new AlertDialog.Builder(MainActivity.this);
            adb.setTitle("Share in..");
            ArrayAdapter<String> arySharing=new
                    ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,shareAry);

            adb.setAdapter(arySharing, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this,shareAry[i] , Toast.LENGTH_SHORT).show();

                }
            });


            AlertDialog ad=adb.create();
            ad.getListView().setBackgroundColor(Color.YELLOW);
            ad.show();

            return true;
        }
    };




}
