package JOUR01;

public class Job3 {
    public static void Array() {
        int[] array = new int[10];
        for(int i =0; i<array.length; i++) {
            array[i] = i;
        }

        System.out.println("the value with the index 0 is : " +  array[0]);
        System.out.println("the value with the index 1 is : " +  array[1]);
        System.out.println("the value with the index 5 is : " +  array[5]);
        System.out.println("the value with the index 9 is : " +  array[9]);
//        System.out.println("the value with the index 10 is : " +  array[10]);  Index 10 out of bounds for length 10
    }
}

