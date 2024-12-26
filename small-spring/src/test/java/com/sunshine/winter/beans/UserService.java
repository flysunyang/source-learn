package com.sunshine.winter.beans;

public class UserService {

    private UserDao userDao;
    
    public void queryName(String id) {
        String name = userDao.queryUserName(id);
        System.out.printf("id:%s -> name:%s\n", id, name);
    }
    
    public void queryUserInfo() {
        System.out.println("query user info");
    }
    
}
