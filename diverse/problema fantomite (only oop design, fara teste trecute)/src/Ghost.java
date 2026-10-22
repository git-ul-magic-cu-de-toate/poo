class Ghost {
    private int X;
    private int Y;
    private int okRed;
    private int okBlue;
    private String color;

    void moveRed(Ghost ghost, Game game) {
        if (ghost.getX() == game.getN()) {
            ghost.okRed = 0;
        }
        if (ghost.getX() == 1) {
            ghost.okRed = 1;
        }

        switch (ghost.okRed) {
            case 0: {
                ghost.setX(getX() - 1);
                break;
            }
            case 1: {
                ghost.setX(getX() + 1);
                break;
            }
        }
    }

    void moveBlue(Ghost ghost, Game game) {
        if (ghost.getY() == game.getN()) {
            ghost.okBlue = 0;
        }
        if (ghost.getY() == 1) {
            ghost.okBlue = 1;
        }

        switch (ghost.okBlue) {
            case 0: {
                ghost.setY(getY() - 1);
                break;
            }
            case 1: {
                ghost.setY(getY() + 1);
                break;
            }
        }
    }

    public Ghost(final int X, final int Y) {
        this.X = X;
        this.Y = Y;
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

    public int getOkRed() {
        return okRed;
    }

    public void setOkRed(int okRed) {
        this.okRed = okRed;
    }

    public int getOkBlue() {
        return okBlue;
    }

    public void setOkBlue(int okBlue) {
        this.okBlue = okBlue;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
