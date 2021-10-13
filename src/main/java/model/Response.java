package model;

public class Response {
    String message;

    public Response(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Ответ сервера:" + message + '\n';
    }
}
