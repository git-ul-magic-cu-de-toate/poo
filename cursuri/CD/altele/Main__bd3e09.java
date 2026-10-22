public class Main {

    public static void main(String[] args) {
        Sub s = new Sub();
        s.doWork();
    }

}

class Base {
    Base() {
        System.out.println("base");
    }
    Base(String s) {
        System.out.println(s);
    }

    public void doWork() {
        System.out.println("work");
    }
}

class Sub extends Base {
    Sub() {
        super("param");
        System.out.println("sub");
    }

    public void doWork() {
        System.out.println("sub-work");
        super.doWork();
    }
}

