package org.threadinformation;

import static java.lang.Thread.sleep;

public class Main {
    private static ThreadGroup createDummyThreadGroup() {
        ThreadGroup thGroup1 = new ThreadGroup("Root thread group");
        ThreadGroup thGroup2 = new ThreadGroup(thGroup1,"Child thread group");
        ThreadGroup thGroup3 = new ThreadGroup(thGroup1,"Other child thread group");
        ThreadGroup thGroup4 = new ThreadGroup(thGroup3,"Yet another thread group");

        Thread someThread = new Thread(thGroup3, () -> { while(true) {} });
        someThread.start();

        Thread shortThread = new Thread(thGroup2, () -> {
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        shortThread.start();

        return thGroup1;
    }
    public static void main(String[] args) {
        ThreadGroup group = createDummyThreadGroup();
        group.list();

        ThreadInformationPrinter printer = new ThreadInformationPrinter(group, 1000);
    }
}