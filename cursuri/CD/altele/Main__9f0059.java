import java.util.Arrays;
import java.util.Comparator;

public class Main {

    @FunctionalInterface
    interface Sayable{
        String say(String msg);
    }

    @FunctionalInterface
    interface IsOdd {
        Boolean isOdd(Integer n);
    }

    @FunctionalInterface
    interface IsYes {
        Boolean isYes(String c);
    }

//n -> n % 2 != 0;
//(char c) -> c == 'y';
//(x, y) -> x + y;
//(int a, int b) -> a * a + b * b;
//() -> 42
//        () -> { return 3.14 };
//(String s) -> { System.out.println(s); };
//() -> { System.out.println("Hello World!"); };

    public static void main(String[] args) {
        Sayable greet = (m) -> "Hello "+m;
        System.out.println(greet.say("Mihai"));

        IsOdd isOddObj = n -> n % 2 != 0;
        System.out.println(isOddObj.isOdd(5));

        IsYes isYesObj = (c) -> c == "ydefiowhfpiowerhgfrweauhge";
        System.out.println(isYesObj.isYes("ydefiowhfpiowerhgfrweauhge"));

    /*
        String[] array = { "abc", "aa", "abcd" };
        //Arrays.sort(array, (String s1, String s2) -> s2.length() - s1.length());
        //Arrays.sort(array, (s1, s2) -> s2.length() - s1.length());
        //Arrays.sort(array, Comparator.comparingInt(s -> s.length()).reversed());
        //Arrays.sort(array, Comparator.comparingInt((String s) -> s.length()).reversed());
        for (String s : array) {
            System.out.print(s + " ");
        }

     */

    }


}
