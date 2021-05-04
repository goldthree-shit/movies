package com.hx.service;

import com.hx.mapper.UserMapper;
import com.hx.entity.User;
import com.hx.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String, String> saveUser(Map<String,String> map) {
        Map<String, String> result = new HashMap<>();
        String username = map.get("username");
        if (userMapper.findUserByUsername(username) != null) {
            result.put("msg","用户名已存在，请更改用户名！");
            return result;
        }

        String password = DigestUtils.md5DigestAsHex(map.get("password").getBytes());
        String isAdmin = map.get("isAdmin");
        userMapper.saveUser(new User(null, username, password, isAdmin));
        result.put("msg","注册成功！");
        result.put("username", username);
        result.put("isAdmin", isAdmin);
        String token = JWTUtils.getToken(result);
        result.put("token", token);
        return result;
    }

    @Override
    public Map<String, String> loginUser(Map<String, String> map) {
        Map<String, String> result = new HashMap<>();
        String username = map.get("username");
        User user = userMapper.findUserByUsername(username);
        if (user == null) {
            result.put("msg","用户名不存在!");
            return result;
        }
        String password = DigestUtils.md5DigestAsHex(map.get("password").getBytes());
        if (password.equals(user.getPassword())) {
            result.put("msg", "登陆成功!");
            result.put("username", username);
            result.put("isAdmin", user.getIsAdmin());
            String token = JWTUtils.getToken(result);
            result.put("token", token);
            return result;
        }
        result.put("msg", "密码错误");
        return result;
    }
}
