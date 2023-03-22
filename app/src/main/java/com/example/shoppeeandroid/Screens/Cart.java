package com.example.shoppeeandroid.Screens;

import static com.example.shoppeeandroid.utils.LinkServer.BASE_URL;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shoppeeandroid.API.ApiCart;
import com.example.shoppeeandroid.Adapter.CartAdapter;

import com.example.shoppeeandroid.R;
import com.example.shoppeeandroid.interfaces.APIEvent;
import com.example.shoppeeandroid.utils.InternetConnect;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {
    private TextView btnBuyCart;
    ArrayList<com.example.shoppeeandroid.model.Cart> listCart = new ArrayList<>();

    private CartAdapter cart;
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.home_main);
        listView =(ListView)findViewById(R.id.listCartUser);





        listCart.add(new com.example.shoppeeandroid.model.Cart("Nuoc hoa mui huong 2phai manh gia cuc soc123","Nuoc ho3a nam511 nu unisex",399060,21));
        listCart.add(new com.example.shoppeeandroid.model.Cart("Nuoc hoa mui huong 2phai manh gia cuc soc123","Nuoc ho3a nam511 nu unisex",399060,21));
        listCart.add(new com.example.shoppeeandroid.model.Cart("Nuoc hoa mui huong 2phai manh gia cuc soc123","Nuoc ho3a nam511 nu unisex",399060,21));
        listCart.add(new com.example.shoppeeandroid.model.Cart("Nuoc hoa mui huong 2phai manh gia cuc soc123","Nuoc ho3a nam511 nu unisex",399060,21));
        listCart.add(new com.example.shoppeeandroid.model.Cart("Nuoc hoa mui huong 2phai manh gia cuc soc123","Nuoc ho3a nam511 nu unisex",399060,21));
        listCart.add(new com.example.shoppeeandroid.model.Cart("Nuoc hoa mui huong p1hai manh gia cuc s321oc","Nuoc h2oa nam nu uni12sex",3991000,22));
        listCart.add(new com.example.shoppeeandroid.model.Cart("Nuoc hoa m3ui huong phai manh gia cuc 51soc","Nuoc hoa nam nu12 uni1sex",399050,42));
        listCart.add(new com.example.shoppeeandroid.model.Cart("Nuoc ho2a mui huong phai manh gia cuc soc","Nuoc hoa nam nu unisex",399000,23));
        listCart.add(new com.example.shoppeeandroid.model.Cart("Nuoc hoa mui huong phai manh gia cuc s113oc","Nuoc hoa1 nam nu u51nisex",390020,232));
        listCart.add(new com.example.shoppeeandroid.model.Cart("Nuoc hoa mui huon4g phai manh gia cuc s623oc","Nuoc hoa 5nam nu u21nisex",399600,25));
        if (InternetConnect.isConnected(this)){
            try {
                ApiCart.getAPIJson(this, BASE_URL+"auth/login", new APIEvent() {
                    @Override
                    public void onSuccess(JSONObject response) {
                        System.out.println("DOne");
                        System.out.println(response);
                    }
                });
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        setItem();
        getViewActivityCart();
        buyCart();
        setItemOnView();}

    private void getViewActivityCart(){
        btnBuyCart = (TextView) findViewById(R.id.btnBuyCart);
    }
    private void setItem(){
        listView =(ListView) findViewById(R.id.listCartUser);
    }
    private void setItemOnView(){
        cart= new CartAdapter(Cart.this, listCart, R.layout.listitemcart);
        listView.setAdapter(cart);
    }
    private void buyCart(){
        btnBuyCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Cart.this, Payment.class);
                startActivity(intent);
            }
        });
    }


}