package com.example.nitin.firstapp;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;

import java.util.List;
import java.util.zip.Inflater;

import static com.example.nitin.firstapp.R.id.imageView;

/**
 * Created by nitin on 1/30/2017.
 */

public class ItemAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Item> items;
    ImageLoader imageLoader=AppController.getmInstance().getmImageLoader();
    public ItemAdapter(Activity activity,List<Item> items){
        this.activity=activity;
        this.items=items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater==null){
            inflater=(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null){
            convertView=inflater.inflate(R.layout.custom_layout,null);
        }
        if(imageLoader==null){
            imageLoader=AppController.getmInstance().getmImageLoader();
            NetworkImageView imageView= (NetworkImageView) convertView.findViewById(R.id.imageView);
            TextView title= (TextView) convertView.findViewById(R.id.tv_title);
            TextView rate= (TextView) convertView.findViewById(R.id.tv_rate);
            TextView gen= (TextView) convertView.findViewById(R.id.tv_gen);
            TextView year= (TextView) convertView.findViewById(R.id.tv_year);

            Item item=items.get(position);
            imageView.setImageUrl(item.getImage(),imageLoader);
            title.setText(String.valueOf(item.getRate()));
            String genStr="";
            Log.e("nfdkfd",item.getRate());
            for(String str:item.getGen()){
                genStr +=str +",";
            }
            genStr=genStr.length()>0? genStr.substring(0,genStr.length()-2):genStr;
            gen.setText(genStr);

            year.setText(String.valueOf(item.getYear()));
        }

            return convertView;

    }
}
