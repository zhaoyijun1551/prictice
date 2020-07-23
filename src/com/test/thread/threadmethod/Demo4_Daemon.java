package com.test.thread.threadmethod;


public class Demo4_Daemon {
    /**
     * 守护线程
      * @param args
     */
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                for(int i = 0; i < 3; i++) {
                    System.out.println(getName() + "...aaaaaaaaaaaaaaaaaaaa");
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                for(int i = 0; i < 50; i++) {
                    System.out.println(getName() + "...bb");
                }
            }
        };

        t2.setDaemon(true);							//设置为守护线程

        t1.start();
        t2.start();
    }
}
