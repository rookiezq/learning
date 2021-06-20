package com.rookied.learning.network.common.client;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zhangqiang
 * @date 2021/4/21
 */
public class LoginClient {
    public static void main(String[] args) throws Exception{
        Socket client = new Socket("localhost",10001);
        User user = getUser();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
        objectOutputStream.writeObject(user);
        client.shutdownOutput();

        DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
        System.out.println(dataInputStream.readUTF());
        client.shutdownInput();

        dataInputStream.close();
        objectOutputStream.close();
        client.close();
    }

    private static User getUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        return new User(username,password);
    }
}
