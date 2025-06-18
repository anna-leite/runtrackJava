/*package JOUR03;

class A {
    public A() {}
}

class B extends A {
    public B() {
        super();
    }
}

class C extends B {
    public C() {
        super();
    }
}

class D extends A {
    protected int d = 1;

    public D(int x) {
        super();
        d = x;
    }

    public D() {}
}

class E extends D {
    public E() {
        super();
    }
}

class F extends D {
    public F() {
        super();
    }
}

public class ABCDEF {
    public static void main(String[] args) {
        A a = new A(); // correct
        B b = new B(); // correct
        C c = new C(); // correct
        D d = new D(); // correct
        E e = new E(); // correct
        F f = new F(); // correct

        a = b; // correct
        b = a; // incorrect because A doesn't inherit B
        a = (A)b; // correct
        a = null; // correct
        null = a; // incorrect 'null' cannot be assigned
        a = d; // correct
        b = d; // incorrect because B and D are both daughter class from A
        a = e; // correct
        d = e; // correct

        A[] as = new A[10];
        as[0] = new A();
        as[1] = new B();
        as[2] = new D(2);
        as[3] = new E();
        as[4] = new C();
        as[5] = new D(4);
        as[6] = new B();

        research(as);
        add(as);
    }

    private static void research(A[] as) {
        int instancesOfClassB = 0;
        for (A a : as) {
            if (a instanceof B) {
                instancesOfClassB++;
            }
        }

        System.out.println("Number of instances of class B : " + instancesOfClassB);
    }

    private static void add(A[] as) {
        int dSum = 0;
        for (A a : as) {
            if (a instanceof D) {
                dSum += ((D)a).d;
            }
        }

        System.out.println("Sum of d : " + dSum);
    }
}*/

