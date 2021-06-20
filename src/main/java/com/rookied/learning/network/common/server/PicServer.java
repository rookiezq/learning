package com.rookied.learning.network.common.server;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhangqiang
 * @date 2021/4/21
 */
public class PicServer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(10001);
        Socket server = serverSocket.accept();

        InputStream inputStream = server.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("nb.jpg");
        byte[] buff = new byte[1024];
        int length = 0;
        while((length = inputStream.read(buff)) != -1){
            fileOutputStream.write(buff,0,length);
        }
        server.shutdownInput();

        OutputStream outputStream = server.getOutputStream();
        outputStream.write("图片上传成功".getBytes());
        server.shutdownOutput();

        outputStream.close();
        fileOutputStream.close();
        inputStream.close();
        server.close();
        serverSocket.close();

    }
}
