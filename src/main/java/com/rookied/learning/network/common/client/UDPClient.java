package com.rookied.learning.network.common.client;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @author zhangqiang
 * @date 2021/4/21
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
        //创建客户端UDP的套接字 端口是客户端的,和服务端端口无关
        DatagramSocket datagramSocket = new DatagramSocket(10000);
        //从控制台输入
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //将输入封装为UDP数据包,地址和端口需要和服务端对应
        DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(),str.getBytes().length, InetAddress.getLocalHost(),10001);
        //发送数据包
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }
}
