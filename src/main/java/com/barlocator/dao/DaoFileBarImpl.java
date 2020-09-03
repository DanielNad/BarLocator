package main.java.com.barlocator.dao;

import main.java.com.barlocator.dm.Bar;
import java.io.IOException;
import java.util.ArrayList;

public class DaoFileBarImpl extends IDaoAbstract<Bar> implements IDao<Bar> {
    public DaoFileBarImpl(String filePath) throws IOException {
        super(filePath);
    }

    @Override
    public boolean remove(Bar object) {
        for (int i = 0; i <data.size() ; i++) {
            if(data.get(i).getBarName().equals(object.getBarName())) {
                data.remove(i);
                try {
                    this.openFileToWrite();
                    this.getObjectOutputStream().writeObject(data);
                    this.closeFileToWrite();
                    return true;
                } catch (IOException e) {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public ArrayList<Bar> read() {
        ArrayList<Bar> data = new ArrayList<>();
        try {
            this.openFileToRead();
            data = (ArrayList<Bar>) this.getObjectInputStream().readObject();
            this.closeFileToRead();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public boolean write(Bar object, ArrayList<Bar> data) {
        data.add(object);
        try {
            this.openFileToWrite();
            this.getObjectOutputStream().writeObject(data);
            this.closeFileToWrite();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
