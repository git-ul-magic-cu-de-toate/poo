package users;

import common.Right;

public class Teacher implements User {
    @Override
    public Right getRights() {
        return Right.SOME;
    }
}
