package com.cg.onlinetest.service;

import com.cg.onlinetest.entity.User;
import com.cg.onlinetest.exceptions.LoginException;

public interface LoginService {
    public User doLogin(int userId, String password)throws LoginException;
    public String encryptUser(User user);
    
}
