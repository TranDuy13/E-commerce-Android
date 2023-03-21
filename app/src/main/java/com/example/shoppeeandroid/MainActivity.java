package com.example.shoppeeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView btnBuyCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.home_main);
        getViewActivityCart();
        buyCart();
    }
    private void getViewActivityCart(){
        btnBuyCart = (TextView) findViewById(R.id.btnBuyCart);
    }
    private void buyCart(){
        btnBuyCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Payment.class);
                startActivity(intent);
            }
        });
    }


}