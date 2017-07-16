package com.ammase.latihanprodukdetail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ammase.latihanprodukdetail.R;
import com.ammase.latihanprodukdetail.model.listuser.DataItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lincoln on 31/03/16.
 */

public class adapterListUser extends RecyclerView.Adapter<adapterListUser.MyViewHolder> {
    private List<DataItem> resultsList;
    private Context mContext;

    public adapterListUser(Context context, List<DataItem> images) {
        this.mContext = context;
        this.resultsList = images;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_user, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.mNama.setText(resultsList.get(position).getName());
        holder.mHarga.setText(resultsList.get(position).getEmail());
        holder.mUraian.setText(resultsList.get(position).getRegistered());

    }

    @Override
    public int getItemCount() {
        return resultsList.size();

    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textViewName) TextView mNama;
        @BindView(R.id.textViewEmail) TextView mHarga;
        @BindView(R.id.textViewRegister) TextView mUraian;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }
}