import java.util.ArrayList;
import java.util.List;

interface Visitor {
    public void visit(Student s);
    public void visit(Teacher t);
}

interface Visitable {
    public void accept(Visitor v);
}

class Student implements Visitable {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class Teacher implements Visitable {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class Exam implements Visitor {
    @Override
    public void visit(Student s) {
        System.out.println(s.getName() + " is taking an exam");
    }

    @Override
    public void visit(Teacher t) {
        System.out.println(t.getName() + " is leading an exam");
    }
}

class Call implements Visitor {
    @Override
    public void visit(Student s) {
        System.out.println("Student " + s.getName() + " got a call");
    }

    @Override
    public void visit(Teacher t) {
        System.out.println("Teacher " + t.getName() + " got a call");
    }
}

public class Main {
    public static void main(String[] args) {
        List<Visitable> visitableList = new ArrayList<>();
        List<Visitor> visitorList = new ArrayList<>();

        visitableList.add(new Student("ana"));
        visitableList.add(new Student("b"));
        visitableList.add(new Teacher("c"));

        visitorList.add(new Call());
        visitorList.add(new Exam());

        for (Visitor visitor : visitorList) {
            for (Visitable visitable : visitableList) {
                visitable.accept(visitor);
            }
        }
    }
}