package com.example.demo;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();
    User findOne(long id);
}