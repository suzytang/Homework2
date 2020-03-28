package com.example.homework2;

import java.util.ArrayList;

public class Restaurant {
    private String identifier;
    private String name;
    private String cuisine;
    private String location;
    private double rating;
    private String cost;
    private String open;
    private String address;
    private int image;
    private int image1;
    private int image2;
    private int image3;


    //empty constructor to be called to get arraylist in MainActivity and DetailaActivity
    public Restaurant(){
    }

    public Restaurant(String identifier, String name, String cuisine, String location,
                      double rating, String cost, String open, String address, int image, int image1, int image2, int image3){
        this.identifier = identifier;
        this.name = name;
        this.cuisine = cuisine;
        this.location = location;
        this.rating = rating;
        this.cost = cost;
        this.open = open;
        this.address = address;
        this.image = image;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;

    }

    //getters and setters for each variable
    public String getIdentifier() {
        return identifier;
    }
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public int getImage3() {
        return image3;
    }

    public void setImage3(int image3) {
        this.image3 = image3;
    }

    //arraylist listing details of top 10 restaurants
    public static ArrayList<Restaurant> getRestaurants() {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("sokyo-pyrmont","Sokyo","Japanese","Pyrmont",4.5, "A$140 for two people (approx.) Without alcohol", "12noon – 3pm, 5:30pm – 9pm", "50 Murray Street, Darling Harbour, Sydney", R.drawable.sokyo1, R.drawable.sokyo2, R.drawable.sokyo3, R.drawable.sokyo4));
        restaurants.add(new Restaurant("its-time-for-thai-haymarket","Time for Thai","Thai","Haymarket",3.8, "A$60 for two people (approx.)", "11am – 10:30pm", "767-769 George Street, Haymarket, Sydney", R.drawable.timeforthai1, R.drawable.timeforthai2, R.drawable.timeforthai3, R.drawable.timeforthai4));
        restaurants.add(new Restaurant("fresh-and-hot-ma-la-tang-chippendale","Fresh and Hot","Chinese",
                "Chippendale",5.0, "A$40 for two people (approx.)", "10am - 8pm", "Level 2, Central Park Mall, " +
                "28 Broadway, Chippendale, Sydney", R.drawable.freshandhot1, R.drawable.freshandhot2, R.drawable.freshandhot3, R.drawable.freshandhot4));
        restaurants.add(new Restaurant("tan-viet-noodle-house-haymarket","Tan Viet","Vietnamese","Haymarket",4.0, "A$35 for two people (approx.)", "11am – 9pm", "74 Tumbalong Boulevard, Haymarket, Sydney\n" +
                "\n", R.drawable.tanviet1, R.drawable.tanviet2, R.drawable.tanviet3, R.drawable.tanviet4));
        restaurants.add(new Restaurant("fratelli-fresh-cbd","Fratelli Fresh","Italian","CBD",4.1, "A$90 for two people (approx.) Without alcohol", "12noon – 9pm", "11 Bridge Street, CBD, Sydney", R.drawable.fratellifresh1, R.drawable.fratellifresh2, R.drawable.fratellifresh3, R.drawable.fratellifresh4));
        restaurants.add(new Restaurant("encasa-haymarket","Encasa","Spanish","Haymarket",4.5, "A$80 for two people (approx.) Without alcohol", "12noon – 2:30pm, 5:30pm – 10:30pm", "423 Pitt Street, Haymarket, Sydney", R.drawable.encasa1, R.drawable.encasa2, R.drawable.encasa3, R.drawable.encasa4));
        restaurants.add(new Restaurant("arisun-cbd","Arisun","Korean","CBD",4.1, "A$100 for two people (approx.) Without alcohol", "11am – 11:30pm", "Shop 35, 1 Dixon Street, Chinatown, CBD, Sydney", R.drawable.arisun1, R.drawable.arisun2, R.drawable.arisun3, R.drawable.arisun4));
        restaurants.add(new Restaurant("bar-luca-cbd","Bar Luca","Modern Australian","CBD",4.6, "A$60 for two people (approx.) Without alcohol", "11am – 12midnight", "52 Phillip Street, CBD, Sydney", R.drawable.barluca1, R.drawable.barluca2, R.drawable.barluca3, R.drawable.barluca4));
        restaurants.add(new Restaurant("ippudo-cbd","Ippudo","Japanese","CBD",3.9, "A$40 for two people (approx.)", "11am – 10pm", "Shop 5021, Level 5, Westfield Pitt Street Mall, CBD, Sydney", R.drawable.ippudo1, R.drawable.ippudo2, R.drawable.ippudo3, R.drawable.ippudo4));
        restaurants.add(new Restaurant("the-little-snail-darling-harbour","The Little Snail","French","Darling Harbour",4.4, "A$140 for two people (approx.) Without alcohol", "12noon – 3pm, 5:30pm – 9pm", "50 Murray Street, Darling Harbour, Sydney", R.drawable.thelittlesnail1, R.drawable.thelittlesnail2, R.drawable.thelittlesnail3, R.drawable.thelittlesnail4));

        return restaurants;
    }

    //searchRestaurant class to filter through the arraylist based on a string passed into it i.e. the intent
    public static Restaurant searchRestaurant(String search){

        ArrayList<Restaurant> restaurants = Restaurant.getRestaurants();
        int i;

        //for loop that denotes that if one of the elements in the arraylist contains the search variable
        //passed into the method, then that element is returned
        for(i= 0; i < restaurants.size(); i++){
            if(getRestaurants().get(i).identifier.contains(search)){
                return restaurants.get(i);
            }
        }
        return null;

    }

    /*public static Restaurant getImages(String search){
        ArrayList<Restaurant> restaurants = Restaurant.getRestaurants();
        int i;

        for(i= 0; i < restaurants.size(); i++){
            if(getRestaurants().get(i).identifier.contains(search)){
                return restaurants.get(i+8);

            }
        }
        return null;
    }*/

}

