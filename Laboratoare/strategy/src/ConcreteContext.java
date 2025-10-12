import java.util.List;

public class ConcreteContext implements Context {
    private List<Integer> numbers;
    private Strategy strategy;

    @Override
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void print() {
        strategy.execute(numbers);
    }
}
