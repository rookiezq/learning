package com.rookied.learning.network.common.server;

import com.rookied.learning.network.common.client.LoginThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhangqiang
 * @date 2021/4/21
 */
public class LoginServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10001);
        while (true){
            Socket server = serverSocket.accept();
            LoginThread loginThread = new LoginThread(server);
            new Thread(loginThread).start();
        }
    }
}
