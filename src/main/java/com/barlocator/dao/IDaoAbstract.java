package main.java.com.barlocator.dao;

import com.locator.algorithms.datastructures.Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class IDaoAbstract<T> {
    protected List<T> data ;
    protected Graph<T> graph;
    protected String filePath;
    protected InputStream in;
    protected OutputStream out;
    protected ObjectInputStream objectInputStream;
    protected ObjectOutputStream objectOutputStream;

    public IDaoAbstract(String filePath)  {
        this.filePath = filePath;
        this.data = new ArrayList<>();
    }

    public void openFileToRead() throws IOException {
        this.in = new FileInputStream(filePath);
        this.objectInputStream = new ObjectInputStream(in);
    }

    public void closeFileToRead() throws IOException {
        this.objectInputStream.close();
        this.in.close();
    }

    public void openFileToWrite() throws IOException {
        this.out = new FileOutputStream(filePath);
        this.objectOutputStream = new ObjectOutputStream(out);
    }

    public void closeFileToWrite() throws IOException {
        this.objectOutputStream.close();
        this.out.close();
    }

    public Graph<T> getGraph() {
        return graph;
    }

    public void setGraph(Graph<T> graph) {
        this.graph = graph;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public InputStream getIn() {
        return in;
    }

    public void setIn(InputStream in) {
        this.in = in;
    }

    public OutputStream getOut() {
        return out;
    }

    public void setOut(OutputStream out) {
        this.out = out;
    }

    public ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }

    public void setObjectInputStream(ObjectInputStream objectInputStream) {
        this.objectInputStream = objectInputStream;
    }

    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }

    public void setObjectOutputStream(ObjectOutputStream objectOutputStream) {
        this.objectOutputStream = objectOutputStream;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
