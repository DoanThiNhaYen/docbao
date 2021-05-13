package com.example.docbao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import com.squareup.picasso.Picasso;

import java.util.List;


public class customadapter extends ArrayAdapter<doc> {

    public customadapter(Context context, int resource, List<doc> items) {
        super(context , resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.dong_listview, null);
        }
        doc p = getItem(position);
        if (p != null) {
            // Anh xa + Gan gia tri
            TextView txttitle = (TextView) view.findViewById(R.id.txttitle);
            txttitle.setText(p.title);
            ImageView imageView=(ImageView)view.findViewById(R.id.imageView);
            Picasso.get().load(p.hinhanh).into(imageView);

        }
        return view;
    }





}
