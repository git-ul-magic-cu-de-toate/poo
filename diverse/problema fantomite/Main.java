package profu;

import java.util.*;

public class Main {

    Board b;
    PacMan p;
    List<NonPlayingCharacter> nonPlayingCharacters = new ArrayList<>();
    List<java.lang.Character> moves = new ArrayList<>();

    public static void main(String[] args) {
        Main m = new Main();
        m.input();
        m.simulate();
        m.output();
    }

    void input() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        b = new Board(n);

        int x = scan.nextInt();
        int y = scan.nextInt();
        p = new PacMan(b, x, y);

        int r = scan.nextInt();
        for (int i=0; i<r; i++) {
            x = scan.nextInt();
            y = scan.nextInt();
            nonPlayingCharacters.add(new RedPhantom(b,x,y));
        }

        int a = scan.nextInt();
        for (int i=0; i<a; i++) {
            x = scan.nextInt();
            y = scan.nextInt();
            nonPlayingCharacters.add(new BluePhantom(b,x,y));
        }

        int m = scan.nextInt();
        for (int i=0; i<m; i++) {
            moves.add(scan.next().charAt(0));
        }
    }

    void simulate() {
        for (char move : moves) {
            p.move(move);
            for (NonPlayingCharacter npc : nonPlayingCharacters) {
                npc.move();
                if (p.getX() == npc.getX() && p.getY() == npc.getY())
                    return;
            }
        }
    }

    void output() {
        p.print();
        Collections.sort(nonPlayingCharacters);
        for (NonPlayingCharacter npc : nonPlayingCharacters) {
            npc.print();
        }
    }

}

class Board {
    int N;
    Board(int n) {
        this.N = n;
    }
    void move(Character c, int dx, int dy) {
        int newX = c.getX() + dx;
        int newY = c.getY() + dy;
        if (newX >= 1 && newX <= N) c.setX(newX);
        if (newY >= 1 && newY <= N) c.setY(newY);
    }
}

abstract class Character {
    Board b;
    int x;
    int y;
    Character(Board b, int x, int y) {
        this.b = b;
        this.x = x;
        this.y = y;
    }
    void print() {
        System.out.println(x+" "+y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

abstract class PlayingCharacter extends Character {
    PlayingCharacter(Board b, int x, int y) {
        super(b, x, y);
    }

    abstract void move(java.lang.Character direction);
}

abstract class NonPlayingCharacter extends Character implements Comparable<NonPlayingCharacter> {
    NonPlayingCharacter(Board b, int x, int y) {
        super(b, x, y);
    }

    char kind;

    abstract void move();

    @Override
    public int compareTo(NonPlayingCharacter o) {
        if (x == o.getX()) {
            if (y == o.getY()) {
                return kind - o.kind;
            }
            return y - o.getY();
        }
        return x - o.getX();
    }

    void print() {
        System.out.println(kind + " " + x + " " + y);
    }
}

class PacMan extends PlayingCharacter {
    PacMan(Board b, int x, int y) {
        super(b, x, y);
    }

    void move(java.lang.Character direction) {
        switch (direction) {
            case 'U': b.move(this, 0, 1); break;
            case 'D': b.move(this, 0, -1); break;
            case 'L': b.move(this, -1, 0); break;
            case 'R': b.move(this, 1, 0); break;
        }
    }
}

class RedPhantom extends NonPlayingCharacter {
    int direction; // -1 for left, 1 for right
    RedPhantom(Board b, int x, int y){
        super(b,x,y);
        kind = 'R';
        direction = -1;
    }
    void move() {
        b.move(this,direction, 0);
        if (x == 1 || x==b.N) {
            direction *= -1;
        }
    }
}

class BluePhantom extends NonPlayingCharacter {
    int direction; // -1 for down, 1 for up
    BluePhantom(Board b, int x, int y){
        super(b,x,y);
        kind = 'B';
        direction = -1;
    }
    void move() {
        b.move(this,0, direction);
        if (y == 1 || y==b.N) {
            direction *= -1;
        }
    }
}