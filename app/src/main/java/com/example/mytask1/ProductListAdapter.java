package com.example.mytask1;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.RecyclerViewHolder> {
    private ArrayList<ProductModel>ProductArray;
    private Context context;

    public ProductListAdapter(ArrayList<ProductModel>ProductArray,Context context){
        this.ProductArray=ProductArray;
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_product_list_adapter,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListAdapter.RecyclerViewHolder holder, int position) {
        ProductModel productModel=ProductArray.get(position);
      //  holder.pImage.setImageResource(productModel.getImage());
        holder.pName.setText(productModel.getTitle());
        holder.pPrice.setText(productModel.getId());
        Picasso.get().load(productModel.getImage()).into(holder.pImage);
    }

    @Override
    public int getItemCount() {
        return ProductArray.size();
    }
    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private ImageView pImage;
        private TextView pName;
        private TextView pPrice;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            pImage=itemView.findViewById(R.id.productImage);
            pName=itemView.findViewById(R.id.productName);
            pPrice=itemView.findViewById(R.id.productPrice);
        }
    }
}