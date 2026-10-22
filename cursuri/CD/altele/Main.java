public class Main {

    public static void main(String[] args) {
        System.out.println(Ball.size);
        System.out.println(Basketball.size);

        Ball ball = new Ball();
        System.out.println(ball.size);

        Ball.size = 20;
        System.out.println(Ball.size);
        System.out.println(ball.size);
    }
}


class Ball {
    static int size = 15;
}

class Basketball extends Ball {
     static float size = 12f;
}
