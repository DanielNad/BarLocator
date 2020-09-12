package main.java.com.barlocator.dao;

import com.locator.algorithms.datastructures.Graph;
import main.java.com.barlocator.dm.Bar;
import main.java.com.barlocator.dm.Item;
import main.java.com.barlocator.dm.Menu;
import java.io.IOException;
import java.util.ArrayList;

public class DaoFileImpl extends IDaoAbstract<Bar> implements IDao<Bar, Menu, Item, String> {

    private static DaoFileImpl instance = null;

    private DaoFileImpl(String filePath) {
        super(filePath);
        this.graph = new Graph<>(data.size() , this.data);
    }

    public static DaoFileImpl getInstance(String filePath){
        if(instance == null)
             instance = new DaoFileImpl(filePath);
        return instance ;
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
            this.getObjectOutputStream().writeObject(graph);
            this.closeFileToWrite();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public boolean removeAll() throws IOException {
        this.data = new ArrayList<>();
        this.graph = new Graph<>(0,data);
        return writeAll();
    }

    @Override
    public boolean remove(String barName) throws IOException {
                int i = findBar(barName);
                if (i != -1) {
                    data.remove(i);
                    graph = new Graph<>(data.size(),data);
                }
                return writeAll();
    }

    @Override
    public boolean readAll() {
        try {
            this.openFileToRead();
            graph = (Graph<Bar>) this.getObjectInputStream().readObject();
            for (int i:graph.getBars().keySet()) {
                data.add(graph.getBars().get(i));
            }
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
        graph = new Graph<>(data.size(), data);
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

    @Override
    public boolean addEdge(String barName1, String barName2, int weight) {
        int source = -1;
        int destination = -1;
        for (int i = 0; i <  data.size(); i++) {
            if(data.get(i).getBarName() == barName1){
                source = i;
            } else if (data.get(i).getBarName() == barName2){
                destination = i;
            }
        }
        if(source != -1 && destination != -1){
        graph.addEdge(source,destination,weight);
        return writeAll();
        }
        return false;
    }
}
