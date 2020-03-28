package com.example.homework2;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class DetailActivity extends AppCompatActivity {

    private static final String TAG = "DetailActivity";


    private TextView name;
    private TextView cuisine;
    private TextView location;
    private TextView rating;
    private TextView cost;
    private TextView open;
    private TextView address;
    private Button googleMaps;
    private Button viewMenu;
    private ImageView ratingColour;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    /*RecyclerView recyclerView2;
    RecyclerView.Adapter adapter;
    private ImageView gallery;
    RecyclerView.LayoutManager layoutManager;*/
    final Restaurant restaurant = new Restaurant();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: starting");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //get intent from main
        Intent intent = getIntent();
        //assign intent, "identifier" from array to String called "search"
        final String search = intent.getStringExtra("restaurant");


        //initialise
        name = (TextView) findViewById(R.id.name);
        cuisine = (TextView) findViewById(R.id.cuisine);
        location = (TextView) findViewById(R.id.location);
        rating = (TextView) findViewById(R.id.rating);
        cost = (TextView) findViewById(R.id.cost);
        open = (TextView) findViewById(R.id.open);
        address = (TextView) findViewById(R.id.address);
        viewMenu = (Button) findViewById(R.id.viewMenu);
        googleMaps = (Button) findViewById(R.id.googleMaps);
        ratingColour = (ImageView) findViewById(R.id.ratingColour);
        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);
        //gallery = (ImageView) findViewById(R.id.gallery);


        //method to bring rating in front of coloured imageview
        rating.bringToFront();

        //set views. array is queried based on search intent and each item is extracted using their respective getters
        name.setText(restaurant.searchRestaurant(search).getName());
        cuisine.setText(restaurant.searchRestaurant(search).getCuisine());
        location.setText(restaurant.searchRestaurant(search).getLocation());
        rating.setText(Double.toString(restaurant.searchRestaurant(search).getRating()));
        cost.setText(restaurant.searchRestaurant(search).getCost());
        open.setText(restaurant.searchRestaurant(search).getOpen());
        address.setText(restaurant.searchRestaurant(search).getAddress());
        image1.setImageResource(restaurant.searchRestaurant(search).getImage());
        image2.setImageResource(restaurant.searchRestaurant(search).getImage1());
        image3.setImageResource(restaurant.searchRestaurant(search).getImage2());
        image4.setImageResource(restaurant.searchRestaurant(search).getImage3());


        //if and else if statements to determine the colour of the imageview behind the rating. green for ratings >= 4 etc.
        //cute pastel colours :)
        if(restaurant.searchRestaurant(search).getRating() >= 4){
            ratingColour.setColorFilter(Color.rgb(226,240,203));
        }
        else if(restaurant.searchRestaurant(search).getRating() >= 3){
            ratingColour.setColorFilter(Color.rgb(253,244,171));
        }
        else if(restaurant.searchRestaurant(search).getRating() >= 2) {
            ratingColour.setColorFilter(Color.rgb(255,218,193));
        }
        else{
            ratingColour.setColorFilter(Color.rgb(255, 154, 162));
        }


        Log.d(TAG, "onCreate: complete");

        //listener for view menu button. brings the user to zomato menu page
        viewMenu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.zomato.com/sydney/" + restaurant.searchRestaurant(search).getIdentifier() + "/menu")));
            }
        });

        //getting address for each restaurant in the arraylist and replacing spaces with + to pass into google maps url
        final String addressString = restaurant.searchRestaurant(search).getAddress();
        final String addressString2 = addressString.replaceAll("\\s+","+");

        //listener for googleMaps button that puts the address of the restaurant into the google maps url and sets it as the location
        googleMaps.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com/maps/dir//" + addressString2)));
            }
        });


        /*
        tried to implement a recyclerview for the images but couldn't figure out how to pass the intent to the adapter
        to display the correct images. just resorted to using a scrollview

        recyclerView2 = findViewById(R.id.recyclerView2);
        //setting horizontal layout for recyclerview
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView2.setHasFixedSize(true);


        adapter = new ImageAdapter(restaurant.getRestaurants());
        recyclerView2.setAdapter(adapter);*/

        Log.d(TAG, "onCreate: complete");
    }

}




