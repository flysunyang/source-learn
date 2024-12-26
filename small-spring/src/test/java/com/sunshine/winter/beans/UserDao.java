package com.sunshine.winter.beans;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    
    private static Map<String, String> userMap = new HashMap<>();
    
    static {
        userMap.put("1001", "Alice");
        userMap.put("1002", "Bob");
        userMap.put("1003", "Charles");
    }
    
    public String queryUserName(String id) {
        return userMap.get(id);
    }
}
