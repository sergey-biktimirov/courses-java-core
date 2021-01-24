package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson14.messanger;

import com.google.gson.Gson;

import java.util.UUID;

public class Message {
    private UUID fromUUID;
    private UUID toUUID;
    private String message;

    public UUID getFromUUID() {
        return fromUUID;
    }

    public Message setFromUUID(UUID fromUUID) {
        this.fromUUID = fromUUID;
        return this;
    }

    public UUID getToUUID() {
        return toUUID;
    }

    public Message setToUUID(UUID toUUID) {
        this.toUUID = toUUID;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Message setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
