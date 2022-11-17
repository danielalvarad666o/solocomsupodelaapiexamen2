package com.gasca1234.solocomsupodelaapiexamen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.gasca1234.solocomsupodelaapiexamen.Adaptador.Adaptador;
import com.gasca1234.solocomsupodelaapiexamen.Respuesta.Respuesta;
import com.gasca1234.solocomsupodelaapiexamen.SigletonRequest.SingletonRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Adaptador adapter;
    List<Respuesta> respuestaList;
    List<ganadores> ganadoresList;

    private RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQueue = SingletonRequest.getInstance(MainActivity.this).getRequestQueue();
        respuestaList = new ArrayList<>();
        ganadoresList = new ArrayList<>();

        jsparse();
        // Iniciar RecyclerView


    }

    public void jsparse() {
        String urlApi = "https://ramiro.uttics.com/api/ganadores";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlApi, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                RecyclerView recyclerView = findViewById(R.id.te_extraño);

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                Gson gson = new Gson();
                Respuesta pk = gson.fromJson(response.toString(), Respuesta.class);
                adapter = new Adaptador(pk.getData());

                recyclerView.setAdapter(adapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }

}