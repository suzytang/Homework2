package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    //call restaurant class where arraylist is stored
    final Restaurant restaurant = new Restaurant();
    ArrayList<Restaurant> restaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: starting");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restaurants = new ArrayList<Restaurant>();

        Log.d(TAG, "onCreate: made array");

        //initialise recyclerview from activity_main.xml
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        Log.d(TAG, "onCreate: initialised up recyclerview");

        //initialise layoutManager for the recyclerView
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Log.d(TAG, "onCreate: layout manager made");

        //listener for when one of the items in the recyclerview is clicked (based on position
        //used to determine which Restaurant to populate the DetailActivity with
        MyAdapter.RecyclerViewClickListener listener = new MyAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                clickResponse(position);
            }
        };
        Log.d(TAG, "onCreate: made listener");

        //creating the adapter object from the MyAdapter class
        adapter = new MyAdapter(restaurant.getRestaurants(), listener);
        //attaching adapter to recyclerview
        recyclerView.setAdapter(adapter);

        Log.d(TAG, "onCreate: complete");
    }

    public void clickResponse (int position){

        //creating a new intent to move to the DetailActivity class
        Intent intent = new Intent(this, DetailActivity.class);
        //intent to identify the restaurant by its "identifier" variable in the arraylist, pass intent to DetailActivity
        intent.putExtra("restaurant", restaurant.getRestaurants().get(position).getIdentifier());

        startActivity(intent);

        Log.d(TAG, "clickResponse: pressed " + position);
    }
}




