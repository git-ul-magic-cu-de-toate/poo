import java.util.List;

public class NegativeOnly implements Strategy {
    @Override
    public void execute(List<Integer> numbers) {
        System.out.println("Negative only strategy");
        for (Integer number : numbers) {
            if (number < 0) {
                System.out.println(number);
            }
        }
    }
}
