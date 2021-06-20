package com.rookied.learning.network.common.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author zhangqiang
 * @date 2021/4/21
 */
public class LoginThread implements Runnable{
    private Socket socket;

    public LoginThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            User user = (User) objectInputStream.readObject();
            String res;
            if("zq".equals(user.getUsername()) && "zq".equals(user.getPassword())){
                System.out.println("欢迎"+user.getUsername());
                res = "登录成功";
            }else{
                res = "登录失败";
            }
            socket.shutdownInput();

            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(res);
            socket.shutdownOutput();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                assert dataOutputStream != null;
                dataOutputStream.close();
                objectInputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
