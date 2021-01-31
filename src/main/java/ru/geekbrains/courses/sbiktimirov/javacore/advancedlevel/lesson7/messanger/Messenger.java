package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.messanger;

import java.io.*;

public abstract class Messenger {

    public abstract InputStream getInputStream() throws IOException;

    public abstract OutputStream getOutputStream() throws IOException;


    public Message getMessage() throws IOException {
        Message msg = new Message().setResponseCode(ResponseCode.ERROR).setMessage("Не удалось прочить сообщение от сервера!");
        try {
            ObjectInputStream ois = new ObjectInputStream(getInputStream());
            msg = (Message) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return msg;
    }

    public void sendMessage(Message message) throws IOException {
        ObjectOutputStream oos;
        oos = new ObjectOutputStream(getOutputStream());
        oos.writeObject(message);
        oos.flush();
    }
}
