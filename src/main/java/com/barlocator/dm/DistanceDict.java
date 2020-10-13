package main.java.com.barlocator.dm;

public class DistanceDict implements Comparable<DistanceDict>{

    private int index;
    private int distance;

    public DistanceDict(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(DistanceDict o) {
        return this.distance - o.distance;
    }
}
