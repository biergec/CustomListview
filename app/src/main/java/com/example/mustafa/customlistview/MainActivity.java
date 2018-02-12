package com.example.mustafa.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Urunler> urunlerArrayList;
    private ListView listView;
    private CustomListviewUrunler customListviewUrunler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Listview tanımlama ve içerisine veri ekleme işlemleri ayrı birer metot olarak yazıldı.
        initialize();
        fill(urunlerArrayList);
    }

    private void initialize() {
        urunlerArrayList = new ArrayList<Urunler>();
        listView=(ListView)findViewById(R.id.listview_custom);
        customListviewUrunler=new CustomListviewUrunler(MainActivity.this,urunlerArrayList);
        listView.setAdapter(customListviewUrunler);
    }

    private void fill(ArrayList<Urunler>arrylistUrunler){
        for (int i = 0; i < 20; i++) {
            Urunler person = new Urunler("Sipariş : " + i);
            arrylistUrunler.add(person);
        }
    }
}
