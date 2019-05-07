package com.dev.java.thread.chapter03.pipe;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author: dengxin.chen
 * @date: 2018/11/19 15:00
 * @description:利用管道流进行线程间通信
 */
public class WirteData {

    /**
     * 一个线程向管道输出流中写数据
     *
     * @param out
     */
    public void writeData(PipedOutputStream out) {
        try {
            System.out.println("write:");
            for (int i = 0; i < 60; i++) {
                String outData = "" + (i + 1);
                out.write(outData.getBytes());
                System.out.print(outData);
            }
            System.out.println();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ReadData {

    /**
     * 另一个线程中管道输入流中读取数据
     *
     * @param in
     */
    public void readData(PipedInputStream in) {
        try {

            System.out.println("read :");
            byte[] bytes = new byte[20];
            int readLen = -1;
            while ((readLen = in.read(bytes)) != -1) {
                String data = new String(bytes, 0, readLen);
                System.out.print(data);
            }
            System.out.println();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class TestRun {

    public static void main(String[] args) throws Exception {
        WirteData wirteData = new WirteData();
        ReadData readData = new ReadData();

        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream();

//        out.connect(in);
        in.connect(out);

        Thread read = new Thread(() -> readData.readData(in));
        Thread write = new Thread(() -> wirteData.writeData(out));
        write.start();
        Thread.sleep(2000);
        read.start();


    }
}
