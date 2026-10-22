public class Main {
    public static void main(String[] args) {
        Person pete = new Person("pete");
        Person dave = new Doctor("dave");
        pete.greet(dave);
        pete.askForHelp(dave);
        dave.askForHelp(pete);

    }
}

class Person {
    protected String name ;
    public Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name ;
    }
    public void greet(Person otherPerson ) {
        System.out.println ("Hi "+ otherPerson.getName () ) ;
    }

    public void askForHelp(Person someone) {
        // if run-time type not checked: ClassCastException
        ((Doctor)someone).treat(this);
    }

//    public void askForHelp(Person someone) {
//        if (someone instanceof Doctor)
//            ((Doctor)someone).treat(this);
//    }

//    public void askForHelp(Doctor doctor) {
//        doctor.treat(this);
//    }
//    public void askForHelp(Person someone) {
//        System.out.println("call a doctor");
//    }
}

class Doctor extends Person {
    public Doctor(String name) {
        super(name);
    }

    public String getName() {
        return " dr " + name;
    }

    public void treat(Person p) {
        System.out.println("treatment");
    }
}