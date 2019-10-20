package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class SocketTest {
    public static void main(String[] args) throws IOException {
        new Thread(() -> {
            try {
                server(8099);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                server(8090);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        Socket client = new Socket();
        client.setReuseAddress(true);
        client.bind(new InetSocketAddress(8888));

//        Socket client_2 = new Socket();
//        client_2.setReuseAddress(true);
//        client_2.bind(new InetSocketAddress(8888));

        client.connect(new InetSocketAddress(8099));
        System.out.println(client.isBound());
        System.out.println(client.isConnected());
        client.connect(new InetSocketAddress(8090));
        System.out.println("hello");
    }

    public static void server(int port) throws IOException {
        ServerSocket server = new ServerSocket(port);
        server.accept();
        System.out.println("server : " + port);
    }
}


