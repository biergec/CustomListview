package com.example.mustafa.customlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mustafa on 10.02.2018.
 */

public class CustomListviewUrunler extends ArrayAdapter<Urunler> implements View.OnClickListener{

    private Context context;
    ArrayList<Urunler> list_urunler;

    public CustomListviewUrunler(Context context, ArrayList<Urunler> urunlers){
        super(context,0,urunlers);
        this.context=context;
        this.list_urunler=urunlers;
    }

    // View Holder Pattern for better performance -> View Holder bir pattern olup detaylı bilgiye Google üzerinden ulaşabilirsiniz.
    private static class ViewHolder{
        Button b_arti,b_eksi;
        EditText t_siparis_mikatari;
        TextView t_urun_name;
    }

    @Override
    public int getCount() {
        return list_urunler.size();
    }

    @Nullable
    @Override
    public Urunler getItem(int position) {
        return list_urunler.get(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public void onClick(View v) {
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.t_siparis_mikatari=(EditText)v.findViewById(R.id.editText2_urun_miktari);
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        View row;

        if (convertView ==null){
            viewHolder=new ViewHolder();
            LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.custom_listview,parent,false);

            viewHolder.b_arti=row.findViewById(R.id.buton_arti);
            viewHolder.b_eksi=row.findViewById(R.id.buton_eksi);
            viewHolder.t_siparis_mikatari=row.findViewById(R.id.editText2_urun_miktari);
            viewHolder.t_urun_name=row.findViewById(R.id.textview_urun_isim);

            row.setTag(viewHolder);
        }else{
            row=convertView;
            viewHolder=(ViewHolder) row.getTag();
        }

        final Urunler urunler=getItem(position);
        viewHolder.t_urun_name.setText(urunler.getSiparis_isim());
        viewHolder.t_siparis_mikatari.setText(urunler.getSiparis_miktar()+"");

        viewHolder.b_eksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateEdittext(position,viewHolder.t_siparis_mikatari,-1);
            }
        });

        viewHolder.b_arti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateEdittext(position,viewHolder.t_siparis_mikatari,+1);
            }
        });

        return  row;
    }

    private void updateEdittext(int position, EditText t_siparis_mikatari, int value) {

        Urunler urunler=getItem(position);

        if (value>0){
            urunler.setSiparis_miktar(urunler.getSiparis_miktar()+1);
        }else{
            if (urunler.getSiparis_miktar()>0){
                urunler.setSiparis_miktar(urunler.getSiparis_miktar()-1);
            }
        }
        t_siparis_mikatari.setText(urunler.getSiparis_miktar()+"");
    }
}