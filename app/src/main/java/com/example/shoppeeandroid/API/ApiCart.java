package com.example.shoppeeandroid.API;

import android.content.Context;
import android.os.StrictMode;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shoppeeandroid.interfaces.APIEvent;


import org.json.JSONException;
import org.json.JSONObject;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;

public class ApiCart {

//    public interface VolleyCallback {
//        void onSuccess(JSONObject result) throws JSONException;
//        void onError(VolleyError error);
//    }



    public static void getAPIString(Context context, String url) {
        //init request
        RequestQueue queue = Volley.newRequestQueue(context);
        //add url in request
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                System.out.println(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(stringRequest);

    }


    public static void getAPIJson(Context context, String url, APIEvent listener) throws JSONException {
        RequestQueue queue = Volley.newRequestQueue(context);
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("username","adminchiba1");
        jsonBody.put("password","1234567");

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonBody,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
//
//                        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
//                                    .permitAll().build();
//                            StrictMode.setThreadPolicy(policy);
//
//                        try {
//                            InetAddress inet = InetAddress.getLocalHost();
//                            InetAddress[] ips = InetAddress.getAllByName(inet.getCanonicalHostName());
//                            if (ips  != null ) {
//                                for (int i = 0; i < ips.length; i++) {
//                                    System.out.println(ips[i]);
//                                }
//                            }
//                        } catch (UnknownHostException e) {
//
//                        }
                        listener.onSuccess(response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    System.out.println(error);
                } else if (error instanceof AuthFailureError) {
                    System.out.println("2");
                } else if (error instanceof ServerError) {
                    System.out.println("3");
                    NetworkResponse networkResponse = error.networkResponse;
                    if (networkResponse != null && networkResponse.data != null) {
                        String jsonError = new String(networkResponse.data);
                        System.out.println(jsonError);
                        System.out.println("status Server");
                        System.out.println(networkResponse.statusCode);
                    }
                } else if (error instanceof NetworkError) {
                    System.out.println("4");
                } else if (error instanceof ParseError) {
                    System.out.println("5");
                }
            }
        });

        queue.add(jsonObjectRequest);
    }



}
