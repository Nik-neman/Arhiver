package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Введите адрес сервера");
        String adress = null;
        try {
            adress = ConsoleHelper.readString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return adress;
    }

    protected int getServerPort(){
        ConsoleHelper.writeMessage("Введите порт");
        int port = 0;
        port = ConsoleHelper.readInt();
        return port;
    }

    protected String getUserName(){
        ConsoleHelper.writeMessage("Введите имя пользователя");
        String userName = null;
        try {
            userName = ConsoleHelper.readString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userName;
    }

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка отправки сообщения");
            clientConnected = false;
            e.printStackTrace();
        }
    }


    public class SocketThread extends Thread {

        public void run(){

        }
    }

}
