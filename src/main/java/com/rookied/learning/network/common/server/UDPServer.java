package com.rookied.learning.network.common.server;

import java.io.IOException;
import java.net.*;

/**
 * @author zhangqiang
 * @date 2021/4/21
 */
public class UDPServer {
    public static void main(String[] args) throws IOException {
        //创建服务端UDP的套接字 客户端发送数据端口和此一致
        DatagramSocket datagramSocket = new DatagramSocket(10001);
        byte[] buff = new byte[1024];
        //获取到的数据封装为数据包
        DatagramPacket datagramPacket = new DatagramPacket(buff,buff.length);
        //接收数据
        datagramSocket.receive(datagramPacket);
        //打印数据
        System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));
    }
}
