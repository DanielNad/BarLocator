package main.java.com.barlocator.service;

import com.locator.algorithms.IAlgoDistance;
import main.java.com.barlocator.dao.IDao;

public class LocationService {
    private IAlgoDistance algoDistance;
    private IDao dataManager;

    public LocationService(IAlgoDistance algoDistance, IDao dataManager) {
        this.algoDistance = algoDistance;
        this.dataManager = dataManager;
    }

    public IAlgoDistance getAlgoDistance() {
        return algoDistance;
    }

    public void setAlgoDistance(IAlgoDistance algoDistance) {
        this.algoDistance = algoDistance;
    }

    public IDao getDataManager() {
        return dataManager;
    }

    public void setDataManager(IDao dataManager) {
        this.dataManager = dataManager;
    }
}
