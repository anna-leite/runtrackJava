package JOUR04;

import java.util.Random;
import java.util.Scanner;
import java.lang.StringBuilder;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class LenghtString {
    private int lenghtStr;
    private String str;

    public LenghtString() {}

    public int getLenghtStr() {
        return this.lenghtStr;
    }

    public String getStr() {
        return this.str;
    }

    public void setLenghtStr(int newLenghtStr) {
        this.lenghtStr = newLenghtStr;
    }

    public void setStr(String newStr) {
        this.str = newStr;
    }

    public void askLenght() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a length for a string :");
        this.lenghtStr = sc.nextInt();
    }

    public void generateString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.lenghtStr; i++) {
            Random rand = new Random();
            int randomNumber = rand.nextInt(26);
            char randomChar = (char) ('a' + randomNumber);
            sb.append(randomChar);
        }
        this.str = sb.toString();
    }

    public void writeStringInFile() {
        try (FileWriter writer = new FileWriter("output.txt", true)) {
            writer.write(this.str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readStringFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LenghtString ls = new LenghtString();
        ls.askLenght();
        ls.generateString();
        ls.writeStringInFile();
//        ls.readStringFromFile();
    }
}

class LsThread extends Thread {
    private final LenghtString ls;

    public LsThread(LenghtString ls) {
        this.ls = ls;
    }

    @Override
    public void run() {
        ls.generateString();
        ls.writeStringInFile();
    }
}

class Main {
    public static void main(String[] args) {
        LenghtString ls = new LenghtString();
        ls.askLenght();

        long start = System.nanoTime();
        LsThread lsThread = new LsThread(ls);
        lsThread.start();

        try {
            lsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Duration : " + duration + " nanoseconds");
    }
}
