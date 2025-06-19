package JOUR04;

import java.lang.Thread;

public class MyThread extends Thread {
   @Override
   public void run() {
       System.out.println("Mon projet est en cours");
   }
}
