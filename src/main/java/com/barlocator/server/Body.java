package main.java.com.barlocator.server;

import com.locator.algorithms.datastructures.Graph;
import main.java.com.barlocator.dm.Bar;
import main.java.com.barlocator.dm.DistanceDict;
import main.java.com.barlocator.dm.Item;
import main.java.com.barlocator.dm.Menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Body implements Serializable {
    private static final long serialVersionUID = 4526101460377019373L;
    private Bar bar;
    private Menu menu;
    private Item item;
    private Graph<Bar> graph;
    private String type;
    private String barName;
    private String menuName;
    private String itemName;
    private String barTo;
    private int weight;
    private int i;
    private ArrayList<DistanceDict> distance;
    private String status;

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

    public Graph<Bar> getGraph() {
        return graph;
    }

    public void setGraph(Graph<Bar> graph) {
        this.graph = graph;
    }

    public String getBarTo() {
        return barTo;
    }

    public void setBarTo(String barTo) {
        this.barTo = barTo;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public ArrayList<DistanceDict> getDistance() {
        return distance;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setDistance(ArrayList<DistanceDict> distance) {
        this.distance = distance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
