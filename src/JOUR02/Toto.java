package JOUR02;

public class Toto {
    int toto = 0;
    static int titi =0;
    Toto() {
        toto = toto + 1;
    }
    public static void main(String[] tutu) {
        Toto t1 = new Toto();
        Toto t2 = new Toto();
        System.out.println("Toto : " + titi);
        System.out.println("Toto t1 : " + t1.toto);
        System.out.println("Toto t2 : " + t2.toto);
    }
}

// the code no works because: "non-static variable toto cannot be referenced from a static context"
// a static method can only access to the static members.
// to access to the non-static members, need to create an instance of the class
