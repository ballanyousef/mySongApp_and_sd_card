package com.it.yb.mysongapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SongAdapter extends ArrayAdapter<Song> {
    private Context ctx;
    private int songResourceId;//
    private List<Song> data;//

    public SongAdapter(Context context, int resource, List<Song> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.songResourceId = resource;
        this.data = objects;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater li = (LayoutInflater)
                this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = li.inflate(this.songResourceId, null);

        Song s = this.data.get(position);
        TextView tv1 = v.findViewById(R.id.textViewSongName);
        tv1.setText(s.getSongName());
        TextView tv2=v.findViewById(R.id.textViewSingerName);
        tv2.setText(s.getSingerName());
        TextView tv3=v.findViewById(R.id.textViewTime);
        tv3.setText(String.valueOf(s.getTime()));
        return v;
    }
}
