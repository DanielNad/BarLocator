package main.java.com.barlocator.dao;

import com.locator.algorithms.datastructures.Graph;
import java.io.IOException;


public interface IDao<T,U,V,S> {
     Graph<T> getGraph();
     boolean removeAll() throws IOException;
     boolean remove (S object) throws IOException;
     boolean readAll ();
     boolean write (T object);
     boolean remove (S object, S object1) throws IOException;
     boolean write (S object, U object1);
     boolean remove (S object, S object1, S object2);
     boolean write (S object, S object1, V object2);
     boolean addEdge (S objectFrom, S objectTo, int weight );
}
