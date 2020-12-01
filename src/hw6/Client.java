package hw6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    private static final String IP_ADDRESS = "localhost";
    private static final int PORT = 8189;
    static Socket socket;
    static DataOutputStream out;
    static DataInputStream in;
    static boolean test = true;

    public static void main(String[] args) {

        try {
            socket = new Socket(IP_ADDRESS, PORT);

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

                    System.out.println("Сервер: " + str);
                    if (str.equals("/end")) {
                        System.out.println("Сервер отключился");
                        test = false;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
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
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
