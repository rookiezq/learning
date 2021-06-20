package com.rookied.learning.map;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhangqiang
 * @date 2021/4/15
 */
public class MapDemo2 {
    public static void main(String[] args) throws IOException {
        File file = new File("jack");
        InputStream in = new FileInputStream(file);
        int length = 0;
        byte[] buffer = new byte[1024];
        System.out.println(buffer.length);
        while ((length = in.read(buffer,0,5)) != -1) { // read()返回的是当前字节 自动转为int，如果为-1说明到文件末尾了
            System.out.println(new String(buffer, 0, length)); // 输出当前字节的unicode
        }
    }

    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 10000000) ? 10000000 : n + 1;
    }
}
