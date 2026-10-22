class Move {
    public Move() {
    }

    public static void doMove(Game game) {
        for (String move : game.getDirection()) {
            switch (move) {
                case "D": {
                    game.setX(game.getX() - 1);
                    break;
                }
                case "U": {
                    game.setX(game.getX() + 1);
                    break;
                }
                case "R": {
                    game.setY(game.getY() + 1);
                    break;
                }
                case "L": {
                    game.setY(game.getY() - 1);
                    break;
                }
            }
        }
    }
}
