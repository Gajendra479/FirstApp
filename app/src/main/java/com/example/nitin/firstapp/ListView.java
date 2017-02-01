package com.example.nitin.firstapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListView extends AppCompatActivity {
    private static final String url="http://api.androidhive.info/json/movies.json";
    private ProgressDialog dialog;
    private List<Item> array=new ArrayList<Item>();
//    private ListView listView;
    private ItemAdapter adapter;

//    ListView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
//        l=findViewById(R.id.list_item_l);
      final android.widget.ListView listView= (android.widget.ListView) findViewById(R.id.list_item_l);


        dialog=new ProgressDialog(this);
        dialog.setMessage("Loading....");
        dialog.show();

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                hideDialog();
                for(int i=0;i<response.length();i++){
                    try{
                        JSONObject obj=response.getJSONObject(i);
                        Item item=new Item();
                        item.setTitle(obj.getString("title"));
                        item.setImage(obj.getString("image"));
                        item.setRate(obj.getString("rating"));
                        item.setYear(obj.getString("genre"));

                        JSONArray genreArray=obj.getJSONArray("genre");
                        ArrayList<String> genre=new ArrayList<String>();
                        for(int j=0 ;j<genreArray.length();j++){
                            genre.add((String) genreArray.get(j));
                        }
                        item.setGen(genre);
                        array.add(item);
                        adapter=new ItemAdapter(ListView.this,array);
                        listView.setAdapter(adapter);
                    }
                catch (JSONException ex) {
                    ex.printStackTrace();
                    }
                }
            adapter.notifyDataSetChanged();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getmInstance().addtorequestqueue(jsonArrayRequest);
    }
    public void hideDialog(){
        if(dialog!=null){
            dialog.dismiss();
            dialog=null;
        }
    }
}
