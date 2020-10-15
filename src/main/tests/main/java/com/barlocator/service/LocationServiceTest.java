package main.java.com.barlocator.service;

import com.locator.algorithms.DijkstraDistanceAlgo;
import main.java.com.barlocator.dao.DaoFileImpl;
import main.java.com.barlocator.dm.Bar;
import main.java.com.barlocator.dm.Item;
import main.java.com.barlocator.dm.Menu;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class LocationServiceTest {

    static LocationService<Bar, Menu, Item, String> service = new LocationService<>(
            new DijkstraDistanceAlgo(),
            DaoFileImpl.getInstance("src/main/resources/dataResource.txt")
    );
    static Bar bar = new Bar("Teder","Great pizza but a bit expensive");
    static Menu menu = new Menu("Deals");
    static Item item = new Item("Steak", 90);
    static int i = 0;

    @Before
    public void beforeEach() throws IOException {
        service.removeAll();
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
        service.write(bar);
        service.remove(bar.getBarName());
        assertFalse(validateBar(bar));
    }

    @Test
    public void readAll() throws IOException {
        service.readAll();
        assertFalse(validateBar(bar));
    }

    @Test
    public void writeBar() throws IOException {
        service.write(bar);
        assertTrue(validateBar(bar));
    }

    @Test
    public void removeMenu() throws IOException {
        bar.addToMenu(menu);
        service.write(bar);
        service.remove(bar.getBarName(),bar.getMenu().get("Deals").getSubMenuName());
        assertFalse(validateMenu(bar,"Deals"));
    }

    @Test
    public void writeMenu() {
        service.write(bar.getBarName(),menu);
        assertTrue(validateMenu(bar,menu.getSubMenuName()));
    }

    @Test
    public void removeItem() {
        bar.addToMenu(menu);
        menu.addToMenu(item);
        service.write(bar);
        service.remove(bar.getBarName(),bar.getMenu().get("Deals").getSubMenuName(),item.getItemName());
        assertFalse(validateItem(bar,menu,item.getItemName()));

    }

    @Test
    public void writeItem() {
        bar.addToMenu(menu);
        service.write(bar);
        service.write(bar.getBarName(),bar.getMenu().get("Deals").getSubMenuName(),item);
        assertTrue(validateItem(bar,menu,item.getItemName()));
    }
}
