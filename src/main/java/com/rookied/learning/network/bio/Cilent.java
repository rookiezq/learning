package com.rookied.learning.network.bio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author zhangqiang
 * @date 2021/5/2
 */
public class Cilent {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 8888);
        s.getOutputStream().write("hello".getBytes()); //block
        s.getOutputStream().flush();
        System.out.println("write over,waiting for msg back...");

        byte[] bytes = new byte[1024];
        int read = s.getInputStream().read(bytes); //block
        System.out.println(new String(bytes, 0, read));
        s.close();
    }
}
