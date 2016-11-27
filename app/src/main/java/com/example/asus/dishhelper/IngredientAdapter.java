package com.example.asus.dishhelper;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by asus on 2016-08-26.
 */
public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.MyViewHolder> {

    private List<Product> productList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //public TextView title, year, genre;
        @BindView(R.id.ingredientTextView) TextView nameTextView;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);

        }
    }


    public IngredientAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ingredient_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.nameTextView.setText(product.getName());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}