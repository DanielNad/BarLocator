package main.java.com.barlocator.dao;

import main.java.com.barlocator.dm.Bar;
import main.java.com.barlocator.dm.Item;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface IDao<T,U,V,S> {
     boolean remove (S object) throws IOException;
     List<T> readAll ();
     boolean write (T object);
     boolean remove (S object, S object1) throws IOException;
     boolean write (S object, U object1);
     boolean remove (S object, S object1, S object2);
     boolean write (S object, S object1, V object2);
}
