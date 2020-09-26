package main.java.com.barlocator.server;

import java.io.Serializable;

public class Header implements Serializable {
    private static final long serialVersionUID = -6180414304259211341L;
    private String action;

    public Header(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
