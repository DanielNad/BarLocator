package main.java.com.barlocator.server;

public class Response {
    private Body body;

    public Response(Body body) {
        this.body = body;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
