package com.example.read;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.os.Parcelable;
import android.widget.TextView;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.widget.ListAdapter;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ListView list;
    int incount = 0;
    String[] book_main;
    InputStream inputStream;
    BufferedReader bufferedReader;
    InputStream inputStreaml;
    BufferedReader bufferedReaderb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.list);
        inputStream = this.getResources().openRawResource(R.raw.book_main4);
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        inputStreaml = this.getResources().openRawResource(R.raw.book_main4);
        bufferedReaderb = new BufferedReader(new InputStreamReader(inputStreaml));
        try {
            while (bufferedReader.readLine() != null) {
                incount++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        book_main = new String[incount];
        try {
            for (int i = 0; i < incount; i++) {
                book_main[i] = bufferedReaderb.readLine();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,book_main);
        list.setAdapter(adapter);
    }
}
