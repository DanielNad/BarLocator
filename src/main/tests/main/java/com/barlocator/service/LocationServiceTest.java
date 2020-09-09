package main.java.com.barlocator.service;

import com.locator.algorithms.DijkstraDistanceAlgo;
import main.java.com.barlocator.dao.DaoFileImpl;
import main.java.com.barlocator.dm.Bar;
import main.java.com.barlocator.dm.Item;
import main.java.com.barlocator.dm.Menu;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocationServiceTest {

    static LocationService<Bar, Menu, Item, String> service = new LocationService<>(
            new DijkstraDistanceAlgo(),
            DaoFileImpl.getInstance("src/main/resources/dataResource.txt")
    );
    private static Bar bar1 = new Bar("Zoypher","Keep your distance from the pool near the bar!");;
    private static Item item1 = new Item("Steak", 90);
    @Before
    public void create(){
        bar1 = new Bar("Zoypher","Keep your distance from the pool near the bar!");
        Menu menu1 = new Menu("Deals");
        Menu menu2 = new Menu("Deserts");
        item1 = new Item("Steak", 90);
        Item item2 = new Item("Pizza",65);
        Item item3 = new Item("Ice cream", 30);
        Item item4 = new Item("Cake",25);

        menu1.addToMenu(item1);
        menu1.addToMenu(item2);
        menu2.addToMenu(item3);
        menu2.addToMenu(item4);
        bar1.addToMenu(menu1);
        bar1.addToMenu(menu2);
        service.write(bar1);
    }

    public boolean validateBar(Bar bar){
        for (int i:service.getGraph().getBars().keySet()) {
            if( bar.getBarName().equals(service.getGraph().getBars().get(i).getBarName())){
                return true;
            }
        }
        return false;
    }

    public boolean validateMenu(Bar bar ,String menu){
        return bar.getMenu().containsKey(menu) ? true : false;
    }

    public boolean validateItem(Bar bar, Menu menu, String item){
        return bar.getMenu().get(menu.getSubMenuName()).getItems().containsKey(item) ? true : false;
    }

    @Test
    public void removeBar() throws IOException {
        Bar bar2 = new Bar("Teder","Great pizza but a bit expensive");
        service.write(bar2);
        service.remove(bar2.getBarName());
        if(validateBar(bar2))
            assertTrue(false);
        else
            assertTrue(true);
    }

    @Test
    public void readAll() {
        service.readAll();
        if(validateBar(bar1))
            assertTrue(true);
        else
            assertTrue(false);
    }

    @Test
    public void writeBar() throws IOException {
        Bar bar2 = new Bar("Teder","Great pizza but a bit expensive");
        service.write(bar2);
        if(validateBar(bar2))
            assertTrue(true);
        else
            assertTrue(false);
    }

    @Test
    public void removeMenu() throws IOException {
        service.remove(bar1.getBarName(),bar1.getMenu().get("Deals").getSubMenuName());
        if(validateMenu(bar1, "Deals"))
            assertTrue(false);
        else
            assertTrue(true);
    }

    @Test
    public void writeMenu() {
        service.write(bar1.getBarName(),new Menu("Drink"));
        if(validateMenu(bar1,"Drink"))
            assertTrue(true);
        else
            assertTrue(false);
    }

    @Test
    public void removeItem() {
        service.remove(bar1.getBarName(),bar1.getMenu().get("Deals").getSubMenuName(),item1.getItemName());
        if(validateItem(bar1,bar1.getMenu().get("Deals"),"Steak"))
            assertTrue(false);
        else
            assertTrue(true);
    }

    @Test
    public void writeItem() {
        service.write(bar1.getBarName(),bar1.getMenu().get("Deals").getSubMenuName(),new Item("Fish",70));
        if(validateItem(bar1,bar1.getMenu().get("Deals"),"Fish"))
            assertTrue(true);
        else
            assertTrue(false);
    }
}
