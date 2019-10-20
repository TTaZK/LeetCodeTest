package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketPackageTest {
    public static void server(int port) throws IOException, InterruptedException {
        ServerSocket server = new ServerSocket(port);
        Socket s = server.accept();
        OutputStream outputStream = s.getOutputStream();
        while (true) {
            outputStream.write("this is message 1".getBytes());
            //Thread.sleep(90);
            outputStream.write("this is message 2".getBytes());
            //Thread.sleep(900);
            outputStream.write("This is a test".getBytes());
            //Thread.sleep(50);
        }
    }

    public static void client(String host, int port) throws IOException {
        Socket client = new Socket(host, port);
        InputStream inputStream = client.getInputStream();
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes) > 0) {
            System.out.println(new String(bytes));
            bytes = new byte[1024];
        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                server(8088);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                client("127.0.0.1", 8088);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
