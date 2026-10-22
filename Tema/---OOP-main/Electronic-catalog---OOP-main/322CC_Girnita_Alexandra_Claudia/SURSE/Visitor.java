public interface Visitor {
    void visit(Assistant assistant, Grade grade);
    void visit(Teacher teacher, Grade grade);
}
