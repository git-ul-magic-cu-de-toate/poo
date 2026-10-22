import java.util.ArrayList;

class Game {
    private int N;
    private int X;
    private int Y;
    private int R;
    private ArrayList<Ghost> red;
    private int A;
    private ArrayList<Ghost> blue;
    private int moves;
    private ArrayList<String> direction;
    private ArrayList<ArrayList<String>> table;

    public Game() {
        this.red = new ArrayList<>();
        this.blue = new ArrayList<>();
        this.direction = new ArrayList<>();
        this.table = new ArrayList<>();
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getR() {
        return R;
    }

    public void setR(int r) {
        R = r;
    }

    public ArrayList<Ghost> getRed() {
        return red;
    }

    public void setRed(ArrayList<Ghost> red) {
        this.red = red;
    }

    public int getA() {
        return A;
    }

    public void setA(int a) {
        A = a;
    }

    public ArrayList<Ghost> getBlue() {
        return blue;
    }

    public void setBlue(ArrayList<Ghost> blue) {
        this.blue = blue;
    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public ArrayList<String> getDirection() {
        return direction;
    }

    public void setDirection(ArrayList<String> direction) {
        this.direction = direction;
    }

    public ArrayList<ArrayList<String>> getTable() {
        return table;
    }

    public void setTable(ArrayList<ArrayList<String>> table) {
        this.table = table;
    }
}
