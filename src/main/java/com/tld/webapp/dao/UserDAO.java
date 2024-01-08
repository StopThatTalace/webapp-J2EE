package com.tld.webapp.dao;



public interface UserDAO {
    boolean getUserByUsernamePassword(String username, String password);
}
