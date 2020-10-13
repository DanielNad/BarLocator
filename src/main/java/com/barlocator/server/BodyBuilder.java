package main.java.com.barlocator.server;

import com.locator.algorithms.datastructures.Graph;
import main.java.com.barlocator.dm.Bar;
import main.java.com.barlocator.dm.DistanceDict;
import main.java.com.barlocator.dm.Item;
import main.java.com.barlocator.dm.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BodyBuilder {
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
    private List<DistanceDict> distance;
    private String status;

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

    public BodyBuilder graph(Graph graph){
        this.graph = graph;
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

    public BodyBuilder barTo (String barTo){
        this.barTo = barTo;
        return this;
    }

    public BodyBuilder i (int i){
        this.i = i;
        return this;
    }

    public BodyBuilder distance (ArrayList<DistanceDict> distance){
        this.distance = distance;
        return this;
    }

    public BodyBuilder weight (int weight){
        this.weight = weight;
        return this;
    }

    public BodyBuilder status(String status){
        this.status = status;
        return this;
    }

    public  Body build(){
        Body body = new Body();
        body.setBar(bar);
        body.setMenu(menu);
        body.setItem(item);
        body.setGraph(graph);
        body.setType(type);
        body.setBarName(barName);
        body.setMenuName(menuName);
        body.setItemName(itemName);
        body.setI(i);
        body.setBarTo(barTo);
        body.setStatus(status);
        body.setDistance(distance);
        body.setWeight(weight);
        return body;
    }
}
