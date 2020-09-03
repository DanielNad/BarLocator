package main.java.com.barlocator.dm;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Bar implements Serializable {

    private static final long serialVersionUID = 7157510047459638910L;
    private String barName;
    private String description;
    private double rating;
    private Map<String,Menu> menu;


    public Bar(String barName, String description) {
        this.barName = barName;
        this.description = description;
        this.rating = 0;
        this.menu = new HashMap<>();
    }

    public void addToMenu(Menu subMenu){
        this.menu.put(subMenu.getSubMenuName(),subMenu);
    }

    public void removeFromMenu(Menu subMenu){
        this.menu.remove(subMenu.getSubMenuName());
    }

    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName;
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
        if(rating <= 5 && rating >= 0)
            this.rating = rating;
    }

    public Map<String, Menu> getMenu() {
        return menu;
    }

    public void setMenu(Map<String, Menu> menu) {
        this.menu = menu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bar bar = (Bar) o;
        return Double.compare(bar.rating, rating) == 0 &&
                barName.equals(bar.barName) &&
                description.equals(bar.description) &&
                menu.equals(bar.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barName, description, rating, menu);
    }
}
