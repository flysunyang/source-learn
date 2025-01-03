package com.sunshine.winter.beans;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    
    private static Map<String, String> userMap = new HashMap<>();
    
    public String queryUserName(String id) {
        return userMap.get(id);
    }
    
    public void initDataMethod() {
        System.out.println("execute init-method");
        userMap.put("1001", "Alice");
        userMap.put("1002", "Bob");
        userMap.put("1003", "Charles");
    }
    
    public void destroyDataMethod() {
        System.out.println("execute destroy-method");
        userMap.clear();
    }
    
}
