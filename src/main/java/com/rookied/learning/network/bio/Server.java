package com.rookied.learning.network.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhangqiang
 * @date 2021/5/2
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress("localhost", 8888));

        while (true) {
            Socket s = ss.accept(); //block main线程
            new Thread(() -> handle(s));
        }
    }

    private static void handle(Socket s) {
        try {
            byte[] bytes = new byte[1024];
            int read = s.getInputStream().read(bytes); //block
            System.out.println(new String(bytes, 0, read));

            s.getOutputStream().write(bytes, 0, read); //block
            s.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
