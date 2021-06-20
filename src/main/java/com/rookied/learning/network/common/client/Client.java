package com.rookied.learning.network.common.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zhangqiang
 * @date 2021/4/21
 */
public class Client {
    public static void main(String[] args) {


        Socket client = null;

        //客户端发送
        OutputStream outputStream = null;
        DataOutputStream dos = null;
        Scanner sc = new Scanner(System.in);

        //客户端接收
        InputStream inputStream = null;
        DataInputStream dis = null;
        try {
            client = new Socket("localhost", 10001);
            outputStream = client.getOutputStream();
            dos = new DataOutputStream(outputStream);
            inputStream = client.getInputStream();
            dis = new DataInputStream(inputStream);
            while (true) {
                String str = sc.nextLine();
                if ("dd".equals(str)) break;
                dos.writeUTF(str);


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                sc.close();
                assert dos != null;
                dos.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
