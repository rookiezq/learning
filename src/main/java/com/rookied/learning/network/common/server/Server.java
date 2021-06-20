package com.rookied.learning.network.common.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhangqiang
 * @date 2021/4/21
 */
public class Server {
    public static void main(String[] args) {


        ServerSocket serverSocket = null;
        Socket server = null;
        //服务端接收
        InputStream inputStream = null;
        DataInputStream dis = null;
        //Scanner sc = new Scanner(System.in);
        try {
            serverSocket = new ServerSocket(10001);
            server = serverSocket.accept();
            inputStream = server.getInputStream();
            dis = new DataInputStream(inputStream);
            while (true){
                String str = dis.readUTF();
                if("dd".equals(str)) break;
                System.out.println(str);
            }
            //客户端接收
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert dis != null;
                dis.close();
                server.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
