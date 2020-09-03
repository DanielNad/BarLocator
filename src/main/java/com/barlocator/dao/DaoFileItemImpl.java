package main.java.com.barlocator.dao;

import main.java.com.barlocator.dm.Bar;
import main.java.com.barlocator.dm.Item;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class DaoFileItemImpl extends IDaoAbstract implements IDao <Item> {

    public DaoFileItemImpl(String filePath) throws IOException {
        super(filePath);
    }

    @Override
    public boolean remove(Item object, ArrayList<Bar> data) throws IOException {
        return false;
    }

    @Override
    public ArrayList<Item> read() {
        return null;
    }

    @Override
    public boolean write(Item object, ArrayList<Bar> data) {
        return false;
    }
}
