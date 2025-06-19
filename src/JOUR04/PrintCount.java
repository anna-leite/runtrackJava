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

    public void calculateTotalCount() {
        int totalCount = 0;
        for (int i = 1; i <=  maxCount; i++) {
            totalCount += i;
        }
        System.out.println("The total count is : " + totalCount);
    }

    public static void main(String[] args) {
        PrintCount pc = new PrintCount();
        pc.askMaxCount();
        long start = System.nanoTime();
        pc.calculateTotalCount();
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Duration : " + duration + " nanoseconds");
    }
}

