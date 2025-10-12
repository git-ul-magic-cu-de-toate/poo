package users;

import common.Right;

public class Admin implements User {
    @Override
    public Right getRights() {
        return Right.ALL_IN;
    }
}
