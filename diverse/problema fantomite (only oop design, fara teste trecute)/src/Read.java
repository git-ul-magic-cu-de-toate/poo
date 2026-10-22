import java.util.Scanner;

class Read {
    public Read() {
    }

    public static void doRead(Game game) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        game.setN(n);
        game.setX(scan.nextInt());
        game.setY(scan.nextInt());

        game.setR(scan.nextInt());
        for (int i = 1; i <= game.getR(); i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            Ghost idk = new Ghost(x, y);
            idk.setColor("R");
            game.getRed().add(idk);
        }

        game.setA(scan.nextInt());
        for (int i = 1; i <= game.getA(); i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            Ghost idk = new Ghost(x, y);
            idk.setColor("B");
            game.getBlue().add(idk);
        }

        game.setMoves(scan.nextInt());
        scan.nextLine();

        for (int i = 1; i <= game.getMoves(); i++) {
            game.getDirection().add(scan.nextLine());
        }
    }
}
