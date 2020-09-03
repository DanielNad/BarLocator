package main.java.com.barlocator.dao;

import main.java.com.barlocator.dm.Bar;

import java.io.IOException;
import java.util.ArrayList;

public class DaoFileMenuImpl extends IDaoAbstract implements IDao {
    private Bar bar;

    public DaoFileMenuImpl(String filePath ,Bar bar) {
        super(filePath);
        this.bar = bar;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    @Override
    public boolean remove(Object object, ArrayList data) throws IOException {
        return false;
    }

    @Override
    public ArrayList read() {
        return null;
    }

    @Override
    public boolean write(Object object, ArrayList data) {
        return false;
    }
}
