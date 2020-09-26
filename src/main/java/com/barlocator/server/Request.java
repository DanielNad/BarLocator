package main.java.com.barlocator.server;



public class Request {
    private Header headers;
    private Body body;

    public Request(Header headers, Body body) {
        this.headers = headers;
        this.body = body;
    }

    public Header getHeaders() {
        return headers;
    }

    public void setHeaders(Header headers) {
        this.headers = headers;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
