package com.test.thread;

public class Demo1_Thread {

    /**
     * 证明jvm是多线程
     * @param args
     */
    public static void main(String[] args) {

        for(int i = 0; i < 1000000; i++) {
            new Demo();
        }

        for(int i = 0; i < 10000; i++) {
            System.out.println("我是主线程的执行代码");
        }
    }

}

class Demo{
    @Override
    protected void finalize() {
        System.out.println("垃圾被清扫了。。。");
    }
}
