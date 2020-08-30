package main.java.com.barlocator.dm;

public class Bar {
    private String streetName;
    private String description;
    private double rating;
    private Menu menu;

    public Bar(String streetName, String description, double rating) {
        this.streetName = streetName;
        this.description = description;
        this.rating = rating;
        this.menu = new Menu();
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
