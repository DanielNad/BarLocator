package main.java.com.barlocator.service;

import com.locator.algorithms.BasicDistanceAlgo;
import com.locator.algorithms.DijkstraDistanceAlgo;
import com.locator.algorithms.IAlgoDistance;
import com.locator.algorithms.datastructures.Graph;
import main.java.com.barlocator.dao.IDao;

import java.io.IOException;

public class LocationService <T, U, V, S> {
    private IAlgoDistance algoDistance;
    private IDao dataManager;

    public LocationService(IAlgoDistance algoDistance, IDao dataManager) {
        this.algoDistance = algoDistance;
        this.dataManager = dataManager;
    }

    public Graph<T> getGraph(){
        return dataManager.getGraph();
    }

    public int[] calculateDistance(Graph var1, int var2){
        return algoDistance.calculateDistance(var1,var2);
    }

    public boolean remove (S object) throws IOException{
        return dataManager.remove(object);
    }

    public boolean readAll (){
        return dataManager.readAll();
    }

    public boolean write (T object){
        return dataManager.write(object);
    }

    public boolean remove (S object, S object1) throws IOException{
        return dataManager.remove(object,object1);
    }

    public boolean write (S object, U object1){
        return dataManager.write(object,object1);
    }

    public boolean remove (S object, S object1, S object2){
        return dataManager.remove(object,object1,object2);
    }

    public boolean write (S object, S object1, V object2){
        return dataManager.write(object,object1,object2);
    }

    public boolean addEdge (S objectFrom, S objectTo, int weight ){
        return dataManager.addEdge(objectFrom,objectTo,weight);
    }

    public boolean removeAll() throws IOException {
        return this.dataManager.removeAll();
    }

    public void setAlgo(boolean key){
        if(key){
            this.algoDistance = new DijkstraDistanceAlgo();
        }
        this.algoDistance = new BasicDistanceAlgo();
    }
}
