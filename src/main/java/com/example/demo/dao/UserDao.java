package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.UserInfoOutput;
import com.example.demo.model.UserOutput;

@Mapper
public interface UserDao {

  UserOutput getAllUser();

  UserOutput getByUsername(String username);

  UserInfoOutput getUserById(String id);

  // get multiple user using request paran
  List<UserInfoOutput> getMultipleUserById(String id);

}
