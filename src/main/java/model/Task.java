package model;


import lombok.Data;
import server.entity.User;

@Data
public class Task {
    String type;
    Book book;
    String by;
    String value;
    User user;


    public Task(String type, Book book) {
        this.type = type;
        this.book = book;
        this.by = null;
        this.value = null;

    }

    public Task(String type, User user) {
        this.type = type;
        this.user = user;
        this.by = null;
        this.value = null;

    }
    public Task(String type, Book book, User user) {
        this.type = type;
        this.user = user;
        this.book = book;

    }

    public Task(String type, String by, String value) {
        this.type = type;
        this.book = null;
        this.by = by;
        this.value = value;
    }

    public Task(String type, String by, String value, User user) {
        this.type = type;
        this.book = null;
        this.by = by;
        this.value = value;
        this.user = user;
    }
}
