package com.dmslob.spring.aop.basic.simplearoundadvice;

public class WorkerBean {

    public void doSomeWork(int noOfTimes) {
        for (int x = 0; x < noOfTimes; x++) {
            work();
        }
    }

    private void work() {
        System.out.print("");
    }
}
