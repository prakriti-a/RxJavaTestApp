package com.prakriti.rxjavatestapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RVCustomAdapter extends RecyclerView.Adapter<RVCustomAdapter.MyViewHolder> {
// MyViewHolder is an inner class here
// Adapter is used to inflate custom row on recycler view
// modified to use entries instead of strings

    private final List<Entry> entryList = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // return type is of custom inner class created here
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        // parent is MainActivity class, where recycler view is shown
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // access values to show in recycler view by 'holder' parameter
        Entry entry = entryList.get(position);
        holder.setTxtName(entry.getEntryName()); // setters in MyViewHolder class
        holder.setTxtPrice(entry.getEntryPrice());
        holder.setTxtDate(entry.getEntryDate());
    }

    @Override
    public int getItemCount() {
        return entryList.size();
    }

    public void addEntryToList(Entry item) {
        entryList.add(item);
        // inform recycler view
        notifyItemInserted(entryList.size() - 1); // item was added at last index
        // inserts item in recycler view
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtName) TextView txtName; // declare the views to put in the viewholder
        @BindView(R.id.txtPrice) TextView txtPrice;
        @BindView(R.id.txtDate) TextView txtDate;

        private final NumberFormat PRICE_FORMAT = new DecimalFormat("$#0.00"); // java.text
        // format of price -> can also mention currency unit

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView); // imp for initialisation to work
        }

        public void setTxtName(String name) {
            this.txtName.setText(name);
        }

        public void setTxtPrice(BigDecimal price) {
            this.txtPrice.setText(PRICE_FORMAT.format(price.doubleValue()));
        }

        public void setTxtDate(Date date) {
            this.txtDate.setText(android.text.format.DateFormat.format("yyyy-MM-dd hh:mm", date));
        }

    }

}