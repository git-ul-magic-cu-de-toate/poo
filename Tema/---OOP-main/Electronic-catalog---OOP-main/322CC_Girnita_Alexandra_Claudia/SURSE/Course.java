import java.util.*;

public abstract class Course implements Element {
    private String name;
    private Teacher teacher;
    private HashSet<Assistant> assistants = new HashSet<>();
    // always make sure to sort it when something gets added
    private ArrayList<Grade> grades = new ArrayList<>();
    private HashMap<String, Group> groups = new HashMap<>();
    private int credits;
    private BestScoreStrategy bestScoreStrategy;
    private Snapshot snapshot = new Snapshot();

    public void setName(String name) {
        this.name = name;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public void setAssistants(HashSet<Assistant> assistants) {
        this.assistants = assistants;
    }
    public void setGrades(ArrayList<Grade> grades) {
        this.grades = grades;
    }
    public void setGroups(HashMap<String, Group> groups) {
        this.groups = groups;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
    public void setBestScoreStrategy(BestScoreStrategy bestScoreStrategy) {
        this.bestScoreStrategy = bestScoreStrategy;
    }

    public String getName() {
        return this.name;
    }
    public Teacher getTeacher() {
        return this.teacher;
    }
    public HashSet<Assistant> getAssistants() {
        return this.assistants;
    }
    public ArrayList<Grade> getGrades() {
        return this.grades;
    }
    public HashMap<String, Group> getGroups() {
        return this.groups;
    }
    public int getCredits() {
        return this.credits;
    }
    public BestScoreStrategy getBestScoreStrategy() {
        return this.bestScoreStrategy;
    }

    public void addAssistant(String ID, Assistant assistant) {
        groups.get(ID).setAssistant(assistant);
        if (!assistants.contains(assistant)) {
            assistants.add(assistant);
        }
    }

    public void addStudent(String ID, Student student) {
        this.groups.get(ID).add(student);
    }

    public void addGroup(Group group) {
        this.groups.put(group.getID(), group);
    }

    public void addGroup(String ID, Assistant assistant) {
        Group group = new Group(ID, assistant);
        this.groups.put(ID, group);
    }

    public void addGroup(String ID, Assistant assistant, Comparator<Student> comp) {
        Group group = new Group(ID, assistant, comp);
        this.groups.put(ID, group);
    }

    public void addGrade(Grade grade) {
        this.grades.add(grade);
        Collections.sort(this.grades);
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();

        for (Map.Entry<String, Group> entry : this.groups.entrySet()) {
            for (Student student : entry.getValue()) {
                students.add(student);
            }
        }

        return students;
    }

    public HashMap<Student, Grade> getAllStudentGrades() {
        ArrayList<Student> students = getAllStudents();
        HashMap<Student, Grade> studentGrades = new HashMap<>();

        for (Student student : students) {
            Grade studentGrade = null;
            for (Grade grade : grades) {
                if (grade.getStudent().compareTo(student) == 0) {
                    studentGrade = grade;
                    break;
                }
            }

            studentGrades.put(student, studentGrade);
        }

        return studentGrades;
    }

    public abstract ArrayList<Student> getGraduatedStudents();

    protected abstract class CourseBuilder {
        public abstract void buildName(String name);
        public abstract void buildTeacher(Teacher teacher);
        public abstract void buildAssistants(HashSet<Assistant> assistants);
        public abstract void buildGrades(ArrayList<Grade> grades);
        public abstract void buildGroups(HashMap<String, Group> groups);
        public abstract void buildCredits(int credits);
    }

    public Student getBestStudent() {
        return bestScoreStrategy.getBestStudent(this);
    }

    public void accept(Visitor visitor, Grade grade) {
        visitor.visit((Assistant) assistants.toArray()[0], grade);
        visitor.visit(teacher, grade);
    }

    // memento
    private class Snapshot {
        ArrayList<Grade> grades = null;

        public void makeBackup() {
            grades = new ArrayList<>();

            for (Grade grade : Course.this.grades) {
                try {
                    grades.add((Grade) grade.clone());
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void undo() {
            Course.this.grades = new ArrayList<>();

            for (Grade grade : this.grades) {
                Course.this.grades.add(grade);
            }
        }
    }

    public void makeBackup() {
        this.snapshot.makeBackup();
    }

    public void undo() {
        this.snapshot.undo();
    }
}
