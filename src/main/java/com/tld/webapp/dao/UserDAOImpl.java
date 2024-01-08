package com.tld.webapp.dao;

import com.tld.webapp.util.DatabaseConnection;

public class UserDAOImpl implements UserDAO {
    private DatabaseConnection databaseConnection;

    public UserDAOImpl() {
        this.databaseConnection = DatabaseConnection.getInstance();
    }

    @Override
    public boolean getUserByUsernamePassword(String username, String password) {

        return true;
    }

}
