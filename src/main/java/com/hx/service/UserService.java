package com.hx.service;

import com.hx.entity.User;

import java.util.Map;

public interface UserService {
    Map<String, String> saveUser(Map<String, String> map);
    Map<String, String> loginUser(Map<String, String> map);
}
