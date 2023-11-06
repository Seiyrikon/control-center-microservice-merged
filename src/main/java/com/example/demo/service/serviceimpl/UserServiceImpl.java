package com.example.demo.service.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.UserInfoOutput;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    public UserDao userDao;
    
    @Override
    public UserInfoOutput getUserById(String id) {
        try {
        UserInfoOutput user = userDao.getUserById(id);

        List<String> userRoleLevelList = new ArrayList<>();

        Map<String, Object> role_user_level = new HashMap<>();

        String[] parts = user.getRole_user_level_string().split(",");

        // Create a list to store the objects
        List<String> objectList = new ArrayList<>();

        // Convert the substrings to integers and add them to the list
        for (String part : parts) {
        try {
        objectList.add(part);
        } catch (NumberFormatException e) {
        // Handle parsing errors if necessary
        System.err.println("Failed to parse: " + part);
        }
        }

        role_user_level.put("role_user_level", objectList);
        // for(String userRoleLevel : user.getRole_user_level()) {
        // userRoleLevelList.add(userRoleLevel);
        // }

        // user.setRole_user_level(userRoleLevelList);
        user.setRole_user_level(role_user_level);

        System.out.println("User" + user);
        System.out.println("User Role Level String: " +
        user.getRole_user_level_string());
        System.out.println("User Role Level: " + user.getRole_user_level());

        return user;
        } catch (Exception e) {
        System.out.println("User" + e.getMessage());
        System.out.println("User Role Level: " + e.getMessage());
        return null;
        }
    }
}