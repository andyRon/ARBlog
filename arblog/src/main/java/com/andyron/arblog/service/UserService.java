package com.andyron.arblog.service;

import com.andyron.arblog.po.User;

public interface UserService {

    User checkUser(String username, String password);
}
