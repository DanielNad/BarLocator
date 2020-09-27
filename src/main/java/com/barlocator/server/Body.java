package main.java.com.barlocator.server;

import main.java.com.barlocator.dm.Bar;
import main.java.com.barlocator.dm.Item;
import main.java.com.barlocator.dm.Menu;

import java.io.Serializable;

public class Body implements Serializable {
    private static final long serialVersionUID = 4526101460377019373L;
    private Bar bar;
    private Menu menu;
    private Item item;
    private String type;
    private String barName;
    private String menuName;
    private String itemName;

    public static BodyBuilder builder(){
        return new BodyBuilder();
    }

    public Body() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
