import java.util.ArrayList;
import java.util.HashMap;

public class ScoreVisitor implements Visitor {
    private HashMap<Teacher, ArrayList<Tuple<String, String, Double>>> examScores = new HashMap<>();
    private HashMap<Assistant, ArrayList<Tuple<String, String, Double>>> partialScores = new HashMap<>();

    public void visit(Assistant assistant, Grade grade) {
        Tuple<String, String, Double> newGrade = new Tuple<>(
                grade.getStudent().getFirstName() + " " + grade.getStudent().getLastName(),
                grade.getCourse(),
                grade.getPartialScore()
        );

        if (!partialScores.containsKey(assistant)) {
            ArrayList<Tuple<String, String, Double>> arr = new ArrayList<>();
            arr.add(newGrade);
            partialScores.put(assistant, arr);
        } else {
            ArrayList<Tuple<String, String, Double>> arr = partialScores.get(assistant);
            arr.add(newGrade);
            partialScores.put(assistant, arr);
        }

        Catalog catalog = Catalog.getCatalog();
        ArrayList<Course> courses = catalog.courses;

        // this grade needs to be added only once since a grade is formed
        // from a partial part and an exam part
        // adding it 2 times for each functions introduces a duplicate
        for (Course course : courses) {
            if (course.getName().compareTo(grade.getCourse()) == 0) {
                course.addGrade(grade);
            }
        }

        catalog.notifyObservers(grade);
    }

    public void visit(Teacher teacher, Grade grade) {
        Tuple<String, String, Double> newGrade = new Tuple<>(
                grade.getStudent().getFirstName() + " " + grade.getStudent().getLastName(),
                grade.getCourse(),
                grade.getPartialScore()
        );

        if (!examScores.containsKey(teacher)) {
            ArrayList<Tuple<String, String, Double>> arr = new ArrayList<>();
            arr.add(newGrade);
            examScores.put(teacher, arr);
        } else {
            ArrayList<Tuple<String, String, Double>> arr = examScores.get(teacher);
            arr.add(newGrade);
            examScores.put(teacher, arr);
        }
    }

    class Tuple<K, V, L> {
        private K first;
        private V second;
        private L third;

        Tuple(K first, V second, L third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public void setFirst(K first) {
            this.first = first;
        }
        public void setSecond(V second) {
            this.second = second;
        }
        public void setThird(L third) {
            this.third = third;
        }
        public K getFirst() {
            return this.first;
        }
        public V getSecond() {
            return this.second;
        }
        public L getThird() {
            return this.third;
        }
    }
}
