import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Read.doRead(game);

        int stop = 0;
        Move.doMove(game);
        for (int i = 0; i < game.getMoves(); i++) {
            for (Ghost red : game.getRed()) {
                red.moveRed(red, game);
            }
            for (Ghost blue : game.getBlue()) {
                blue.moveBlue(blue, game);
            }

            for (Ghost red : game.getRed()) {
                if (red.getX() == game.getX()
                        && red.getY() == game.getY()) {
                    stop = 1;
                    break;
                }
            }
            if (stop == 1) {
                break;
            }
            for (Ghost blue : game.getBlue()) {
                if (blue.getX() == game.getX()
                        && blue.getY() == game.getY()) {
                    stop = 1;
                    break;
                }
            }
            if (stop == 1) {
                break;
            }
        }
        Write.doWrite(game);
    }
}
