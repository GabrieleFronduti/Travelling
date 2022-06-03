package com.example.travelling;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    private Button btnRequest;
    private RequestQueue queue;
    private StringRequest stringRequest;
    private TextView textView;
    private String url="https://run.mocky.io/v3/e1f4e618-24fd-4171-a4e3-5ee10fcff91e";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRequest = (Button) findViewById(R.id.btnRequest);
        textView = (TextView) findViewById(R.id.textView);

        public void onclick(View view){
            getData();
        };
    }
}
    private void getData() {
        queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView.setText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("Errore");
            }
        });
        queue.add(stringRequest);
    }
}
