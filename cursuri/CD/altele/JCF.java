import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public class JCF {
    public static void main(String[] args) {
        List<Student> personLst = new ArrayList<>();
        personLst.add(new Student("Peter", 21));
        personLst.add(new Student("Paul", 18));
        personLst.add(new Student("John", 60));

        Predicate<Person> adult = p -> p.getAge() >= 20;
        //personLst.removeIf(adult);

        personLst.stream().filter(adult);

        //personLst.sort();

        Collections.sort(personLst);
        System.out.println(personLst);

        List<Nota> note = new ArrayList<>();
        note.add(new Nota(10));
        note.add(new Nota(9));
        Student s = new Student("Andrei", 20, 9);
        note.remove(s);
        System.out.println(note);
    }
}

class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }
}

class Student extends Person {
    int nota;

    public Student(String name, int age) {
        super(name, age);
    }

    public Student(String name, int age, int nota) {
        super(name, age);
        this.nota = nota;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Nota) {
            Nota n = (Nota) obj;
            return n.equals(nota);
        }
        return super.equals(obj);
    }
}

class Nota {

    Number n;

    public Nota(Number value) {
        this.n = value;
    }

    @Override
    public String toString() {
        return n.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student s = (Student) obj;
            return n.equals(s.nota);
        }
        return super.equals(obj);
    }
}


