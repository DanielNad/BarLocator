package main.java.com.barlocator.server;

import main.java.com.barlocator.dm.Bar;
import main.java.com.barlocator.dm.Item;
import main.java.com.barlocator.dm.Menu;

public class BodyBuilder {
    private Bar bar;
    private Menu menu;
    private Item item;
    private String type;
    private String barName;
    private String menuName;
    private String itemName;

    public BodyBuilder bar (Bar bar){
        this.bar = bar;
        return this;
    }

    public BodyBuilder menu (Menu menu){
        this.menu = menu;
        return this;
    }

    public BodyBuilder item (Item item){
        this.item = item;
        return this;
    }

    public BodyBuilder type (String type){
        this.type = type;
        return this;
    }

    public BodyBuilder barName (String barName){
        this.barName = barName;
        return this;
    }

    public BodyBuilder menuName (String menuName){
        this.menuName = menuName;
        return this;
    }

    public BodyBuilder itemName (String itemName){
        this.itemName = itemName;
        return this;
    }

    public  Body build(){
        Body body = new Body();
        body.setBar(bar);
        body.setMenu(menu);
        body.setItem(item);
        body.setType(type);
        body.setBarName(barName);
        body.setMenuName(menuName);
        body.setItemName(itemName);
        return body;
    }
}
