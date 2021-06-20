package com.rookied.learning.network.common.client;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author zhangqiang
 * @date 2021/4/21
 */
public class PicClient {
    public static void main(String[] args) throws  Exception{
        Socket client = new Socket("localhost",10001);
        FileInputStream fileInputStream = new FileInputStream("/Users/rookied/Desktop/马士兵/java-master/javase/note/线程池的分类.png");
        OutputStream outputStream = client.getOutputStream();
        byte[] buff = new byte[1024];
        int length=0;
        while((length = fileInputStream.read(buff)) != -1){
            outputStream.write(buff,0,length);
        }
        client.shutdownOutput();
        InputStream inputStream = client.getInputStream();
        length = inputStream.read(buff);
        System.out.println(new String(buff,0,length));
        client.shutdownInput();

        inputStream.close();
        outputStream.close();
        fileInputStream.close();
        client.close();
    }
}
