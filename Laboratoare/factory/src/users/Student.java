package users;

import common.Right;

public class Student implements User {
    @Override
    public Right getRights() {
        return Right.NONE;
    }
}
