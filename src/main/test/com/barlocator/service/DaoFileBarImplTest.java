package main.test.com.barlocator.service;

import main.java.com.barlocator.dao.DaoFileBarImpl;
import main.java.com.barlocator.dao.IDao;
import main.java.com.barlocator.dm.Bar;
import main.java.com.barlocator.dm.Item;
import main.java.com.barlocator.dm.Menu;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DaoFileBarImplTest {
    private static IDao<Bar> iDao;
    private static List<Bar> list;
    private static Bar bar = new Bar("Zoypher","test bar");
    private static Menu menu = new Menu();
    private static Item item1 = new Item("Coca-Cola",10);
    private static Item item2 = new Item("Cake",28);
    private static Item item3 = new Item("Fries",21);
    private static Item item4 = new Item("Pizza",69);

    @Before
    public void creation() throws IOException {
        iDao = new DaoFileBarImpl("src/main/resources/dataResource.txt");
        list = new ArrayList<>();
        bar.setMenu(menu);
        menu.addSubMenu("Drinks");
        menu.addSubMenu("Side Dishes");
        menu.addSubMenu("Meals");
        menu.addSubMenu("Deserts");
        bar.getMenu().addToMenu("Drinks",item1);
        bar.getMenu().addToMenu("Side Dishes",item2);
        bar.getMenu().addToMenu("Meals",item3);
        bar.getMenu().addToMenu("Deserts",item4);
    }


    @Before
    public void write() {
        assertTrue(iDao.write(bar, (ArrayList<Bar>) list));
    }


    @Test
    public void read() {
        list = iDao.read();
        assertEquals(bar,list.get(0));
    }

    @After
    public void remove() throws IOException {
        assertTrue(iDao.remove(bar, (ArrayList<Bar>) list));
    }




}