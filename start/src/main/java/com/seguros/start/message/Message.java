package com.seguros.start.message;
import lombok.Data;

public class Message {
    private String message, id;
    private Object data;

    public Message(String message, String id, Object data) {
        this.message = message;
        this.id = id;
        this.data = data;
    }

    public Message(String s, String seCreóConÉxito, String s1) {
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
