package com.rookied.learning.network.netty.s2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author zhangqiang
 * @date 2021/5/6
 */
public class ClientFrame extends Frame {
    public static final ClientFrame INSTENCE = new ClientFrame();
    TextArea ta = new TextArea();
    TextField tf = new TextField();
    private Client client;

    public ClientFrame() {
        this.setSize(600, 400);
        this.setLocation(100, 20);
        this.setAlwaysOnTop(true);
        //对话框
        this.add(ta, BorderLayout.CENTER);
        //输入框
        this.add(tf, BorderLayout.SOUTH);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                client.closeConnect();
                System.exit(0);
            }
        });
        tf.addActionListener(e -> {
            client.send(tf.getText());
            tf.setText("");
        });
    }

    private void connectToServer() {
        client = new Client();
        client.connect();
    }

    public void updateTxt(String msg) {
        ta.setText(ta.getText() + System.getProperty("line.separator") + msg);
    }

    public static void main(String[] args) {
        INSTENCE.setVisible(true);
        INSTENCE.connectToServer();
    }
}
