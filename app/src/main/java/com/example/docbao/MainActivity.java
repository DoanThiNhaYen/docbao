package com.example.docbao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity  {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mytoggle;
    ListView list;
    ArrayList<String> arrayList,arrayLink,arrayList1;
    ArrayAdapter<String> adapter,adapter1;
    customadapter customadapter1;
    ArrayList<doc> mangdocbao;
    ArrayList<object>mangdocbao1;
    NavigationView navigationView;
    static String linkWeb="https://vnexpress.net/rss/tin-moi-nhat.rss";
    public static Database database;
    public static Database databaseread;
    int vitri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=(DrawerLayout)findViewById(R.id.myDream);
        navigationView=(NavigationView)findViewById(R.id.nav_view);

        mytoggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(mytoggle);
        mytoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        databaseread = new Database(this, "TinDaDoc.sqlite", null, 1);
        databaseread.QueryData("CREATE TABLE IF NOT EXISTS contacts(id INTEGER PRIMARY KEY AUTOINCREMENT,link VARCHAR(100))");
        database = new Database(this, "TinDaLuu.sqlite", null, 1);
        database.QueryData("CREATE TABLE IF NOT EXISTS contacts(id INTEGER PRIMARY KEY AUTOINCREMENT, hinhanh NVARCHAR(100),title NVARCHAR(100),link VARCHAR(100))");
        list=(ListView)findViewById(R.id.list);

       // arrayLink=new ArrayList<>();

       // arrayList=new ArrayList<>();
       // arrayList1=new ArrayList<>();
        mangdocbao=new ArrayList<doc>();
       // mangdocbao1=new ArrayList<doc>();
       // adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
       // adapter1=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList1);
       // list.setAdapter(adapter);

        new ReadRSS().execute(linkWeb);
        registerForContextMenu(list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //databaseread.QueryData("INSERT INTO contacts VALUES(null,'" + mangdocbao.get(i).link + "')");
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                //intent.putExtra("link",arrayLink.get(i));
                   // intent.putExtra("link",mangdocbao.get(i).link);
                intent.putExtra("link", mangdocbao.get(i).link);
                intent.putExtra("image", mangdocbao.get(i).hinhanh);
                intent.putExtra("title", mangdocbao.get(i).title);
                startActivity(intent );
            }
       });

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //if (menuItem.isChecked()) menuItem.setChecked(false);
               // else menuItem.setChecked(true);
                // drawerLayout.closeDrawers();
                switch (menuItem.getItemId()) {
                    case R.id.item1:
                        mangdocbao.clear();
                        linkWeb="https://vnexpress.net/rss/tin-moi-nhat.rss";
                        new ReadRSS().execute(linkWeb);



                       //Toast.makeText(getApplicationContext(), "Camera is clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item2:
                        linkWeb="https://vnexpress.net/rss/giai-tri.rss";
                        new ReadRSS().execute(linkWeb);
                        break;
                    case R.id.item3:
                        linkWeb="https://vnexpress.net/rss/giao-duc.rss";
                        new ReadRSS().execute(linkWeb);
                        break;
                    case R.id.item4:
                        linkWeb="https://vnexpress.net/rss/kinh-doanh.rss";
                        new ReadRSS().execute(linkWeb);
                        break;
                    case R.id.item5:
                        linkWeb="https://vnexpress.net/rss/the-thao.rss";
                        new ReadRSS().execute(linkWeb);
                        break;
                    case R.id.item6:
                        linkWeb="https://vnexpress.net/rss/phap-luat.rss";
                        new ReadRSS().execute(linkWeb);
                        break;
                    case R.id.item7:
                        linkWeb="https://vnexpress.net/rss/du-lich.rss";
                        new ReadRSS().execute(linkWeb);
                        break;
                    case R.id.item8:
                        linkWeb="https://vnexpress.net/rss/khoa-hoc.rss";
                        new ReadRSS().execute(linkWeb);
                        break;
                    case R.id.item9:
                        linkWeb="https://vnexpress.net/rss/so-hoa.rss";
                        new ReadRSS().execute(linkWeb);
                        break;
                    case R.id.item10:
                        linkWeb="https://vnexpress.net/rss/oto-xe-may.rss";
                        new ReadRSS().execute(linkWeb);
                        break;
                    case R.id.item11:
                        getSavedFromDatabase();

                        break;
                    default:
                        break;

                }
                    invalidateOptionsMenu();

                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;



            }
        });



    }
    private void getSavedFromDatabase(){
        mangdocbao.clear();
        Cursor dataContacts = database.GetData("SELECT * FROM contacts");
        while (dataContacts.moveToNext()) {
            //int id = dataContacts.getInt(0);

            String hinhanh = dataContacts.getString(1);
            String title = dataContacts.getString(2);
            String link = dataContacts.getString(3);

            mangdocbao.add(0, new doc( title, link, hinhanh));
            customadapter1=new customadapter(MainActivity.this,android.R.layout.simple_list_item_1,mangdocbao);
            //invalidateOptionsMenu();
            list.setAdapter(customadapter1);

        }
    }

  //  @Override
   // public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

   //     super.onCreateContextMenu(menu, v, menuInfo);
   //     getMenuInflater().inflate(R.menu.context_menu,menu);
//
  //  }

  //  @Override
  //  public boolean onContextItemSelected(@NonNull MenuItem item) {
  //      final AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
  //      vitri=info.position;
  //      switch (item.getItemId()){
  //          case R.id.Luu:
  //              break;
  //      }
  //      return super.onContextItemSelected(item);
  //  }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       if(mytoggle.onOptionsItemSelected(item)) {
           return true;

       }

        return super.onOptionsItemSelected(item)||mytoggle.onOptionsItemSelected(item);
    }






    private class ReadRSS extends AsyncTask<String,Void,String>{
        ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            mangdocbao.clear();
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage("Loading...");
            dialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content=new StringBuilder();
            try {
                URL url=new URL(strings[0]);
                InputStreamReader inputStreamReader=new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                String line="";
                while ((line=bufferedReader.readLine())!=null){
                    content.append(line);
                }
                bufferedReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return content.toString();

        }

        @Override
        protected void onPostExecute(String s) {

            XMLDOMParser xmldomParser=new XMLDOMParser();
            XMLDOMParser xmldomParser1=new XMLDOMParser();
            Document document= xmldomParser.getDocument(s);
            NodeList nodeList=document.getElementsByTagName("item");
            NodeList nodeList1=document.getElementsByTagName("description");
            String hinhanh="";
            String tieude="";
            String link="";
            for(int i=0;i<nodeList.getLength();i++){
                String cdata=nodeList1.item(i+1).getTextContent();
                Pattern p=Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
                Matcher matcher=p.matcher(cdata);
                if(matcher.find()){
                    hinhanh=matcher.group(1);

                }
                Element element= (Element) nodeList.item(i);
                tieude=xmldomParser.getValue(element,"title");
                link=xmldomParser.getValue(element,"link");
               // arrayList.add(tieude);
               // arrayList1.add(tieude);
               // arrayLink.add(xmldomParser.getValue(element,"link"));
               // arrayLink1.add(xmldomParser.getValue(element,"link"));
                mangdocbao.add(new doc(tieude,link,hinhanh));
                dialog.dismiss();
            }
            mangdocbao.add(new doc(tieude,link,hinhanh));
            dialog.dismiss();
            customadapter1=new customadapter(MainActivity.this,android.R.layout.simple_list_item_1,mangdocbao);
            //invalidateOptionsMenu();
            list.setAdapter(customadapter1);
            //adapter.notifyDataSetChanged();
            super.onPostExecute(s);


        }

    }

}
