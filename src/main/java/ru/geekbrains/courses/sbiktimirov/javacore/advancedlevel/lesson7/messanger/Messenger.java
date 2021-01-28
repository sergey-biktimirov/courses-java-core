package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.messanger;

import com.google.gson.Gson;

import java.io.*;

public abstract class Messenger {

    public abstract InputStream getInputStream() throws IOException;

    public abstract OutputStream getOutputStream() throws IOException;


    public Message getMessage() throws IOException {
        Message msg;
        msg = new Gson().fromJson(new DataInputStream(getInputStream()).readUTF(), Message.class);

        return msg;
    }

    public void sendMessage(Message message) throws IOException {
        DataOutputStream dos;

        dos = new DataOutputStream(getOutputStream());
        dos.writeUTF(message.toString());
        dos.flush();
    }
}
