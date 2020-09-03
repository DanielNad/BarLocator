package main.java.com.barlocator.dao;

import main.java.com.barlocator.dm.Bar;
import main.java.com.barlocator.dm.Item;
import main.java.com.barlocator.dm.Menu;

import java.io.IOException;
import java.util.ArrayList;

public class DaoFileImpl extends IDaoAbstract<Bar> implements IDao<Bar, Menu, Item, String> {

    public DaoFileImpl(String filePath) {
        super(filePath);
    }

    private int findBar(String barName) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getBarName().equals(barName)) {
                return i;
            }
        }
        return -1;
    }

    private Menu findMenu(String barName ,String menuName) {
        int i = findBar(barName);
        if (i !=- 1) {
            return this.data.get(i).getMenu().get(menuName);
        }
        return null;
    }

    private boolean writeAll() {
        try {
            this.openFileToWrite();
            this.getObjectOutputStream().writeObject(data);
            this.closeFileToWrite();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public boolean remove(String barName) throws IOException {
                int i = findBar(barName);
                if (i != -1)
                    data.remove(i);
                return writeAll();
    }

    @Override
    public boolean readAll() {
        try {
            this.openFileToRead();
            data = (ArrayList<Bar>) this.getObjectInputStream().readObject();
            this.closeFileToRead();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean write(Bar object) {
        data.add(object);
        return writeAll();
    }

    @Override
    public boolean remove(String barName, String menuName) throws IOException {
        int i = findBar(barName);
        if (i != -1) {
            this.data.get(i).getMenu().remove(menuName);
            return (writeAll());
        }
        return false;
    }

    @Override
    public boolean write(String barName, Menu menu) {
        int i = findBar(barName);
        if (i !=- 1)
        {
            this.data.get(i).getMenu().put(menu.getSubMenuName(),menu);
            return (writeAll());
        }
        return false;
    }

    @Override
    public boolean remove(String barName, String menuName, String itemName) {
        Menu menu = findMenu(barName,menuName);
        if(menu != null) {
            menu.removeFromMenu(itemName);
            return writeAll();
        }
        return false;
    }

    @Override
    public boolean write(String barName, String menuName, Item item) {
        Menu menu = findMenu(barName , menuName);
        if(menu != null){
            menu.addToMenu(item);
            return writeAll();
        }
        return false;
    }
}
