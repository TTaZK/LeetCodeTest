package test;

public class A {
    private B b;

    public void a() {
        System.out.println("this is a");
    }

    public static void main(String[] args) {
        A a = new A();
        a.a();
    }
}

class B {
    private A a;
}


