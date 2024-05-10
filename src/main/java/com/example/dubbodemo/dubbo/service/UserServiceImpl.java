package com.example.dubbodemo.dubbo.service;

import com.example.dubbodemo.demos.web.User;
import com.example.dubbodemo.dubbo.api.UserService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.HashMap;
import java.util.Map;

@DubboService
public class UserServiceImpl implements UserService {
    private static Map<Integer, User> userMap = new HashMap<>();

    static {
        User user1 = new User();
        user1.setName("zhangsan");
        user1.setAddress("Beijing");
        user1.setAge(20);
        user1.setId(1);
        User user2 = new User();
        user2.setName("lisi");
        user2.setAddress("Shanghai");
        user2.setAge(22);
        user2.setId(2);
        userMap.put(1, user1);
        userMap.put(2, user2);
    }

    @Override
    public String getUserName(Integer id) {
        User user = userMap.get(id);
        if (user == null) {
            return "User not found";
        }
        return user.getName();
    }

    @Override
    public String getUserAddress(Integer id) {
        User user = userMap.get(id);
        if (user == null) {
            return "User not found";
        }
        return user.getAddress();
    }
}
