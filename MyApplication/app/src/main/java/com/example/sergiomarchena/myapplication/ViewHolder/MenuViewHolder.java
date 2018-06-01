package com.example.sergiomarchena.myapplication.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sergiomarchena.myapplication.ItemOnClickListener;
import com.example.sergiomarchena.myapplication.R;

/**
 * Created by SergioMarchena on 3/14/18.
 */

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    public TextView txtMenuName;
    public ImageView imageView;
    private ItemOnClickListener itemOnClickListener;

    public MenuViewHolder(View itemView) {
        super(itemView);

        txtMenuName = (TextView)itemView.findViewById(R.id.menu_name);
        imageView = (ImageView)itemView.findViewById(R.id.menu_image);

        itemView.setOnClickListener(this);
    }


    public void setItemOnClickListener(ItemOnClickListener itemOnClickListener) {
        this.itemOnClickListener = itemOnClickListener;
    }

    @Override
    public void onClick(View view) {

        itemOnClickListener.OnClick(view,getAdapterPosition(),false);

    }
}
