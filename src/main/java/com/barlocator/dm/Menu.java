package main.java.com.barlocator.dm;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Menu implements Serializable {
    private static final long serialVersionUID = 8708767200345467078L;
    private String subMenuName;
    private Map<String,Item> items;

    public Menu(String subMenuName) {
       this.subMenuName = subMenuName;
        this.items = new HashMap<>();
    }

    public void addToMenu(Item item){
       this.items.put(item.getItemName(),item);
    }

    public void removeFromMenu(String itemName){
        this.items.remove(itemName);
    }

    public String getSubMenuName() {
        return subMenuName;
    }

    public void setSubMenuName(String subMenuName) {
        this.subMenuName = subMenuName;
    }

    public Map<String, Item> getItems() {
        return items;
    }

    public void setItems(Map<String, Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return subMenuName.equals(menu.subMenuName) &&
                items.equals(menu.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subMenuName, items);
    }
}
