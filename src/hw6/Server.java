package hw6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
    private static int PORT = 8189;
    static ServerSocket server = null;
    static Socket socket = null;
    static DataInputStream in;
    static DataOutputStream out;
    static boolean test = true;

    public static void main(String[] args) {

        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен");

            socket = server.accept();
            System.out.println("Клиент подключился");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    input();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    output();
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void input() {
        try {
            in = new DataInputStream(socket.getInputStream());

            while (test) {

                try {
                    String str = null;
                    str = in.readUTF();
                    if (str.equals("/end")) {
                        System.out.println("Клиент отключился");
                        break;
                    }
                    System.out.println("Клиент: " + str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void output() {
        while (test) {
            Scanner in = new Scanner(System.in);

            String str = in.nextLine();
            try {
                out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(str);
                if (str.equals("/end")) {
                    System.out.println("Конец связи");
                    test = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            server.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
