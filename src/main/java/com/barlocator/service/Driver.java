package main.java.com.barlocator.service;

import main.java.com.barlocator.dao.DaoFileImpl;
import main.java.com.barlocator.dao.IDao;
import main.java.com.barlocator.dm.Bar;
import main.java.com.barlocator.dm.Item;
import main.java.com.barlocator.dm.Menu;

import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException {
        IDao<Bar,Menu,Item,String> dataService = new DaoFileImpl("src/main/resources/dataResource.txt");
        dataService.readAll();
        Bar bar1 = new Bar("Zoypher","test bar");
        Bar bar2 = new Bar("Alenbi 69","best sex bar");
        Menu menu1 = new Menu("Deals");
        Menu menu2 = new Menu("Deals");
        Menu menu3 = new Menu("Deserts");
        Menu menu4 = new Menu("Deserts");
        Item item1 = new Item("Steak", 90);
        Item item2 = new Item("Pizza",65);
        Item item3 = new Item("Ice cream", 30);
        Item item4 = new Item("Cake",25);
        dataService.remove(bar1.getBarName());
        boolean sun  = dataService.readAll();
        System.out.println(sun);

    }
}
