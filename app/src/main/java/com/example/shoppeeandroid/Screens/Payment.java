package com.example.shoppeeandroid.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.shoppeeandroid.R;


public class Payment extends AppCompatActivity {
    private TextView payment;
    private ImageView navigate;
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.payment_main);
        getViewScreenPayment();
        confirmPayment();
        navigateToCart();
    }
    private void getViewScreenPayment(){
        payment=(TextView) findViewById(R.id.btnPayment);
        navigate = (ImageView) findViewById(R.id.navigatePayment);
    }
    private void confirmPayment(){
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Thanh toán thành công!");


            }
        });
    }
    private void navigateToCart(){
        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Payment.this, Cart.class);
                startActivity(intent);
            }
        });
    }

}
