package main.java.com.barlocator.dao;

import com.locator.algorithms.datastructures.Graph;
import main.java.com.barlocator.dm.Bar;
import main.java.com.barlocator.dm.Item;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface IDao<T,U,V,S> {
     Graph<T> getGraph();
     boolean remove (S object) throws IOException;
     boolean readAll ();
     boolean write (T object);
     boolean remove (S object, S object1) throws IOException;
     boolean write (S object, U object1);
     boolean remove (S object, S object1, S object2);
     boolean write (S object, S object1, V object2);
     boolean addEdge (S objectFrom, S objectTo, int weight );
}
