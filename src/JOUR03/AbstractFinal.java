/*package JOUR03;

public class AbstractFinal {
    public static void main(String[] args) {
        A[] tab = new A[3];
        tab[0] = new A(); // 'A' is abstract; cannot be instantiated
        tab[1] = new B();
        tab[2] = new C();
        tab[1].b = 2; // tab[1] non convert into B objet
        ((C)tab[2]).c = 3; // cannot change c because is a final type
    }
}

abstract class A {
    int a;
}

class B extends A {
    int b;
}

class C extends A {
    final double c = 1;
}

abstract class D extends A {
    double d;

    int operation(int a) {
        return (a*2);
    }

    abstract int calcul(int b) {} // abstract methode cannot have a body
}*/
