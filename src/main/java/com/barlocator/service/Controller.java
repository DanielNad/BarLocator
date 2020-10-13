package main.java.com.barlocator.service;

import com.locator.algorithms.DijkstraDistanceAlgo;
import com.locator.algorithms.datastructures.Graph;
import main.java.com.barlocator.dao.DaoFileImpl;
import main.java.com.barlocator.dm.DistanceDict;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controller<T,U,V,S> {
    private LocationService <T,U,V,S> locationService;

    public Controller() {
        locationService = new LocationService<>(new DijkstraDistanceAlgo(),DaoFileImpl.getInstance("src/main/resources/dataResource.txt"));
    }

    public boolean write (T object){
        return locationService.write(object);
    }

    public Graph<T> getGraph(){
        return locationService.getGraph();
    }

    public List<DistanceDict> calculateDistance(Graph var1, int var2){
        return locationService.calculateDistance(var1,var2);
    }

    public boolean remove (S object) throws IOException {
        return locationService.remove(object);
    }

    public boolean readAll (){
        return locationService.readAll();
    }

    public boolean remove (S object, S object1) throws IOException{
        return locationService.remove(object,object1);
    }

    public boolean write (S object, U object1){
        return locationService.write(object,object1);
    }

    public boolean remove (S object, S object1, S object2){
        return locationService.remove(object,object1,object2);
    }

    public boolean write (S object, S object1, V object2){
        return locationService.write(object,object1,object2);
    }

    public boolean addEdge (S objectFrom, S objectTo, int weight ){
        return locationService.addEdge(objectFrom,objectTo,weight);
    }

    public boolean removeAll() throws IOException {
        return this.locationService.removeAll();
    }

    public void setAlgo(boolean key){
        locationService.setAlgo(key);
    }
}
