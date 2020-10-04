package main.java.com.barlocator.server;

public class Request {
    private Header header;
    private Body body;

    public Request(Header headers, Body body) {
        this.header = headers;
        this.body = body;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
