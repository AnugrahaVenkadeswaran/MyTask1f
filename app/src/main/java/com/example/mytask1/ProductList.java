package com.example.mytask1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Iterator;

public class ProductList extends AppCompatActivity {
    private RecyclerView recyclerView;
    String Url = "https://run.mocky.io/v3/cdc1c53e-2825-4162-826d-b8294e477934";
    private ArrayList<ProductModel> ProductArrayList = new ArrayList<>();
    private ProductListAdapter productListAdapter;
    private ProgressBar progressBar;
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private Collator MySingleton;
    TextView display;
    int qunt = 0;
    Button increase, decrease;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_Product);
        progressBar = findViewById(R.id.idPB);
        display = findViewById(R.id.display);
        increase = findViewById(R.id.increase);
        decrease = findViewById(R.id.decrease);


        GetData();
        buildRecyclerView();


        increase.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View view){
        qunt = qunt + 1;
        display(qunt);
    }
    });
        decrease.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View view){
        qunt = qunt - 1;
        display(qunt);
    }
    });

}

    private void display(int qunt) {
        display.setText("" + qunt);
    }


    private void buildRecyclerView() {
        productListAdapter = new ProductListAdapter(ProductArrayList, ProductList.this);


        GridLayoutManager manager = new GridLayoutManager(this, 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);

        recyclerView.setAdapter(productListAdapter);
    }


    private void GetData() {


        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, Url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try{

                            JSONArray ja = response.getJSONArray("Articles");

                            for(int i=0; i < ja.length(); i++) {

                                JSONObject jsonObject = ja.getJSONObject(i);

                                // int id = Integer.parseInt(jsonObject.optString("id").toString());
                                String title = jsonObject.getString("title");

                            }

                           buildRecyclerView();
                        }catch(JSONException e){e.printStackTrace();}
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley","Error");

                    }
                }
        );
        requestQueue.add(jor);
    }
}