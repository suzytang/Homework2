package com.example.homework2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {
    //CLASS IS NOT USED. couldn't get recyclerview to display the images based on intent so used a scrollview instead


    private static final String TAG = "ImageAdapter";

    final Restaurant restaurant = new Restaurant();
    ArrayList<Restaurant> restaurants = new ArrayList<>();


    public ImageAdapter(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_image, parent, false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

            holder.gallery.setImageResource(restaurant.getRestaurants().get(position).getImage());

            holder.gallery.setImageResource(restaurant.getRestaurants().get(position).getImage1());
            holder.gallery.setImageResource(restaurant.getRestaurants().get(position).getImage2());
            holder.gallery.setImageResource(restaurant.getRestaurants().get(position).getImage3());




    }

    @Override
    public int getItemCount() {
        return restaurant.getRestaurants().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView gallery;

        public MyViewHolder( View itemView) {
            super(itemView);

            this.gallery = itemView.findViewById(R.id.gallery);


        }

    }


}
