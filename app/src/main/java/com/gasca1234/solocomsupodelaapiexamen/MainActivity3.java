package com.gasca1234.solocomsupodelaapiexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.gasca1234.solocomsupodelaapiexamen.Respuesta.respuesta_de_numeros;
import com.gasca1234.solocomsupodelaapiexamen.SigletonRequest.SingletonRequest;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;

public class MainActivity3 extends AppCompatActivity {
    Button b2,bt1;
    TextView vista,vista2;
    int  numero=0;
    int[] results=new int [7];
    int sumador=0;
    int suma=0;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
b2=findViewById(R.id.button2);


b2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String url ="https://ramiro.uttics.com/api/enviarnumero";
        JSONObject jsonBody = new JSONObject();
        try {
        JSONObject persona= new JSONObject().put("persona",new JSONObject().put("nombre","Jesus Daniel Gasca Alvarado").put("numero",suma));


            JsonObjectRequest request= new JsonObjectRequest(Request.Method.POST, url, persona, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity3.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
                }


            });
            mQueue.add(request);

        } catch (JSONException e) {
            e.printStackTrace();
        }


      //  JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,url,jb)
    }
});

        bt1=findViewById(R.id.button);
        mQueue = SingletonRequest.getInstance(MainActivity3.this).getRequestQueue();
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vista=findViewById(R.id.textView1);
             //   vista2=findViewById(R.id.textView2);
                String url ="https://ramiro.uttics.com/api/numero";
                JsonObjectRequest request= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Gson gson=new Gson();
                        respuesta_de_numeros respuesta=gson.fromJson(response.toString(),respuesta_de_numeros.class);
                        numero=Integer.parseInt(respuesta.getNumero());
                        sumador=1+sumador;

results[sumador]=numero;
for (int i=sumador;i>=0;i--)
{
    suma=suma+results[i];
}
if (suma<21)
{
    vista.setText(respuesta.getNumero());
    suma=0;

}else if (suma==21)
{

    vista.setText("Ganastes en total llevas: " +suma );
sumador=0;
    suma=0;
    results=new int [7];
}


else {

    vista.setText("perdistes son 21 y tu total es : "+suma+" Ultimo numero"+respuesta.getNumero());

    sumador=0;
    results=new int [7];
    suma=0;


}



                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                mQueue.add(request);
            }
        });
        b2=findViewById(R.id.button3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vamosal3();
            }
        });

    }


    private void vamosal3() {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }


}