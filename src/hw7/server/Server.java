package hw7.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Server {

    private static int PORT = 8189;
    ServerSocket server = null;
    Socket socket = null;
    List<ClientHandler> clients;
    private AuthService authService;
    List<String> clientNumber;

    public Server() {
        clients = new Vector<>();
        authService = new SimpleAuthService();
        clientNumber = new ArrayList<String>();

        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void broadCastMsg(ClientHandler sender, String msg) {
        String message = String.format("%s : %s", sender.getNickname(), msg);
        for (ClientHandler client : clients) {
            client.sendMsg(message + "\n");
        }
    }

    void broadCastMsgUser(ClientHandler sender, String msg) {
        String message = String.format("%s : %s", sender.getNickname(), msg);
        String nick = msg.split("\\s")[1];

        for (String s : clientNumber) {
            if (s.equals(nick)) {
                clients.get(clientNumber.indexOf(nick)).sendMsg(message + "\n");
                clients.get(clients.indexOf(sender)).sendMsg(message + "\n");
                return;
            }
        }
        clients.get(clients.indexOf(sender)).sendMsg("Клиента с таким ником не авторизован!\n");
    }

    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    public void subscribeNumber(ClientHandler clientHandler) {
        clientNumber.add(clientHandler.getNickname());
    }

    public void unsubscribeNumber(ClientHandler clientHandler) {
        clientNumber.remove(clientHandler.getNickname());
    }

    public AuthService getAuthService() {
        return authService;
    }

}
