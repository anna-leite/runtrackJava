package JOUR04;

import java.util.Scanner;

public class PrintCount {
    private int maxCount = 0;

    public PrintCount() {}

    public int getMaxCount() {
        return this.maxCount;
    }

    public void setMaxCount(int newMaxCount) {
        this.maxCount = newMaxCount;
    }

    public void askMaxCount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the max count :");
        this.maxCount = sc.nextInt();
    }

    public void printCount() {
        for (int i = 1; i <=  maxCount; i++) {
            System.out.println(i);
        }
    }
}

class CountThread extends Thread {
    private final PrintCount pc;

    public CountThread(PrintCount pc) {
        this.pc = pc;
    }

    @Override
    public void run() {
        pc.printCount();
    }
}

class CountMain {
    public static void main(String[] args) {
        PrintCount pc = new PrintCount();
        pc.askMaxCount();

        long start = System.nanoTime();
        CountThread ct = new CountThread(pc);
        ct.start();

        try {
            ct.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Duration : " + duration + " nanoseconds");
    }
}
