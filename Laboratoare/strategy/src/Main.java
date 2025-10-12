import java.util.List;

public class Main {
    public static void main(String[] args) {
        Context context = new ConcreteContext();
        context.setNumbers(List.of(1, -4, 6, 100, -10));

        context.setStrategy(new PositiveOnly());
        context.print();

        context.setStrategy(new NegativeOnly());
        context.print();
    }
}
