package com.example.homework2;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

// adapter class for the recyclerview displaying the list of restaurants
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private static final String TAG = "MyAdapter";


    RecyclerViewClickListener listener;
    final Restaurant restaurant = new Restaurant();
    ArrayList<Restaurant> restaurants = new ArrayList<>();

    public MyAdapter(ArrayList<Restaurant> restaurants, RecyclerViewClickListener listener) {
        this.restaurants = restaurants;
        this.listener = listener;
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    //setting list_item xml as the view to be displayed in the recyclerview
    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(restaurant.getRestaurants().get(position).getName());
        holder.cuisine.setText(restaurant.getRestaurants().get(position).getCuisine());
        holder.location.setText(restaurant.getRestaurants().get(position).getLocation());
        holder.rating.setText(Double.toString(restaurant.getRestaurants().get(position).getRating()));
        holder.image.setImageResource(restaurant.getRestaurants().get(position).getImage());


        //method to bring rating in front of coloured imageview
        holder.rating.bringToFront();
        //holder.ratingColour.invalidate();

        //if and else if statements to determine the colour of the imageview behind the rating in list_item. green for ratings >= 4 etc.
        //cute pastel colours :)
        if(restaurant.getRestaurants().get(position).getRating() >= 4){
            holder.ratingColour.setColorFilter(Color.rgb(226,240,203));
        }
        else if(restaurant.getRestaurants().get(position).getRating() >= 3){
            holder.ratingColour.setColorFilter(Color.rgb(253,244,171));
        }
        else if(restaurant.getRestaurants().get(position).getRating() >= 2) {
            holder.ratingColour.setColorFilter(Color.rgb(255,218,193));
        }
        else{
            holder.ratingColour.setColorFilter(Color.rgb(255, 154, 162));
        }

    }

    @Override
    public int getItemCount() {
        return restaurant.getRestaurants().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name;
        TextView cuisine;
        TextView location;
        TextView rating;
        ImageView image;
        ImageView ratingColour;
        RecyclerViewClickListener listener;

        public MyViewHolder( View itemView, RecyclerViewClickListener listener) {
            super(itemView);

            itemView.setOnClickListener(this);

            this.listener = listener;
            this.name = itemView.findViewById(R.id.name);
            this.cuisine = itemView.findViewById(R.id.cuisine);
            this.location = itemView.findViewById(R.id.location);
            this.rating = itemView.findViewById(R.id.rating);
            this.image = itemView.findViewById(R.id.image);
            this.ratingColour = itemView.findViewById(R.id.ratingColour);

        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick: inside myadapter on click");
            listener.onClick(v,getAdapterPosition());
        }
    }
}
