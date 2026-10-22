import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Write {
    public Write() {
    }

    public static void doWrite(Game game) {
        System.out.println(game.getX() + " " + game.getY());
        ArrayList<Ghost> allGhost = new ArrayList<>();
        allGhost.addAll(game.getRed());
        allGhost.addAll(game.getBlue());
        Comparator<Ghost> compare = Comparator.comparing(Ghost::getX).thenComparing(Ghost::getY).thenComparing(Ghost::getColor);
        List<Ghost> list = allGhost.stream().sorted(compare).collect(Collectors.toList());

        for (Ghost ghost : list) {
            System.out.println(ghost.getColor() + " " + ghost.getX() + " " + ghost.getY());
        }
    }
}
