package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DevicesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices);
        ScrollView sv = (ScrollView) findViewById(R.id.sv_devices_id);

        RequestQueue queue = Volley.newRequestQueue (this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                "http://happyresto.enseeiht.fr/smartHouse/api/v1/./devices/id/4", null,
                requestSuccessListener(), volleyErrorListener());
        queue.add(jsonObjectRequest);

        StringRequest sr = new StringRequest(Request.Method.POST,
                "http://happyresto.enseeiht.fr/smartHouse/api/v1/./devices/id/4",
                requestSuccessListener(), volleyErrorListener()){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                params.put("deviceId", String.valueOf(
                        "http://happyresto.enseeiht.fr/smartHouse/api/v1/./devices/id/4/3"));

                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-TYpe", "application/x-www-urlencoded");
                return params;
            }
        };
        queue.add(sr);
    }

    public void createDeviceView(){
        RelativeLayout layout = new RelativeLayout(this);

        RelativeLayout.LayoutParams paramsTopLeft = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        paramsTopLeft.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        paramsTopLeft.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);

        TextView someTextView = new TextView(this);
        someTextView.setText("Hello World");
        layout.addView(someTextView, paramsTopLeft);
    }

    private Response.Listener<JSONObject> requestSuccessListener() {
        return new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("success", response.toString());
            }
        };
    }

    private Response.ErrorListener volleyErrorListener(){
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", error.getMessage());
            }
        };
    }
}