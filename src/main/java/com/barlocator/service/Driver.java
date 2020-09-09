package main.java.com.barlocator.service;

import com.locator.algorithms.DijkstraDistanceAlgo;
import main.java.com.barlocator.dao.DaoFileImpl;
import main.java.com.barlocator.dao.IDao;
import main.java.com.barlocator.dm.Bar;
import main.java.com.barlocator.dm.Item;
import main.java.com.barlocator.dm.Menu;

import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException {
        LocationService<Bar, Menu, Item, String> service = new LocationService(new DijkstraDistanceAlgo(), DaoFileImpl.getInstance("src/main/resources/dataResource.txt"));

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

        service.readAll();
        System.out.println("Test");

        menu1.addToMenu(item1);
        menu1.addToMenu(item2);
        bar1.addToMenu(menu1);
        bar1.addToMenu(menu3);

        service.write(bar1);
        service.write(bar2);
        service.write(bar2.getBarName(),menu2);
        service.write(bar2.getBarName(),menu4);
        service.write(bar2.getBarName(),menu2.getSubMenuName(),item1);
        service.addEdge(bar1.getBarName(),bar2.getBarName(),10);

    }
}
