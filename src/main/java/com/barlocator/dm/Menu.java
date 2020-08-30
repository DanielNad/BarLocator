package main.java.com.barlocator.dm;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<String,Map<String,Double>> menu;

    public Menu() {
       this.menu = new HashMap<>();
    }

    public void addSubMenu(String subMenuName){
        this.menu.put(subMenuName,new HashMap<>());
    }

    public void deleteSubMenu(String subMenuName){
        this.menu.remove(subMenuName);
    }

    public void addToMenu(String subMenu,Item item){
       this.menu.get(subMenu).put(item.getItemName(),item.getPrice());
    }

    public void removeFromMenu(String subMenu, Item item){
        this.menu.get(subMenu).remove(item.getItemName());
    }

    public Map<String, Map<String, Double>> getMenu() {
        return menu;
    }

    public void setMenu(Map<String, Map<String, Double>> menu) {
        this.menu = menu;
    }
}
