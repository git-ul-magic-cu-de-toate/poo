import java.util.List;

public interface Context {
    void setStrategy(Strategy strategy);
    void setNumbers(List<Integer> numbers);
    void print();
}
