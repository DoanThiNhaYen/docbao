package com.example.docbao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {
    WebView webviewtintuc;
    String link;
    String title,hinhanh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        webviewtintuc=(WebView)findViewById(R.id.webviewtintuc);
        Intent intent=getIntent();
        link=intent.getStringExtra("link");
        hinhanh=intent.getStringExtra("image");

        title=intent.getStringExtra("title");
        //String link=intent.getStringExtra("link");
        webviewtintuc.loadUrl(link);
       // webviewtintuc.loadUrl(hinhanh);
       // webviewtintuc.loadUrl(title);
        webviewtintuc.setWebViewClient(new WebViewClient());

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Luu:
                MainActivity.database.QueryData("INSERT INTO contacts VALUES(null,'" +hinhanh+ "','"+title+"','"+link+"')");
                Toast.makeText(Main2Activity.this,"Đã Lưu",Toast.LENGTH_SHORT).show();
                break;



        }

        return super.onOptionsItemSelected(item);
    }
}
