package com.example.shoppeeandroid.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.shoppeeandroid.R;
import com.example.shoppeeandroid.model.Cart;

import java.util.ArrayList;

public class CartAdapter extends ArrayAdapter<Cart>{
    Context context;
    ArrayList<Cart> cartArrayList;
    int layoutID;
    public CartAdapter(@NonNull Context context, @NonNull ArrayList<Cart>object, int resource){
        super(context, resource, object);
        this.cartArrayList=object;
        this.context=context;
        this.layoutID=resource;
    }
    @Override
    public int getCount(){
        return cartArrayList.size();
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater.from(context));
        convertView=inflater.inflate(R.layout.listitemcart, null);
        TextView seller = (TextView) convertView.findViewById(R.id.seller);

        TextView name_product = (TextView) convertView.findViewById(R.id.product);

        TextView price =(TextView) convertView.findViewById(R.id.price);

        EditText quantity =(EditText) convertView.findViewById(R.id.quantity);
        quantity.setText(cartArrayList.get(position).getQuantity()+"");
        seller.setText(cartArrayList.get(position).getSeller()+"");
        price.setText(cartArrayList.get(position).getPrice()+"");
        name_product.setText(cartArrayList.get(position).getProduct()+"");
        return convertView;
    }

}
