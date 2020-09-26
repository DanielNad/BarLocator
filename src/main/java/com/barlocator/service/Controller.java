package main.java.com.barlocator.service;

import com.locator.algorithms.DijkstraDistanceAlgo;
import main.java.com.barlocator.dao.DaoFileImpl;

public class Controller<T,U,V,S> {
    private LocationService <T,U,V,S> locationService;

    public Controller() {
        locationService = new LocationService<>(new DijkstraDistanceAlgo(),DaoFileImpl.getInstance("src/main/resources/dataResource.txt"));
    }

    public boolean write (T object){
        return locationService.write(object);
    }
}
