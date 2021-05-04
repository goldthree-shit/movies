package com.hx.controller;

import com.hx.entity.User;
import com.hx.service.UserService;
import com.hx.utils.JWTUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(description = "用户相关的api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user/register")
    @ApiOperation(value = "注册")
    public Map<String,String> register(@RequestBody Map<String, String> map) {
        Map<String, String> result = userService.saveUser(map);
        return result;
    }

    @PostMapping("/user/login")
    @ApiOperation(value = "登录")
    public Map<String,String> login(@RequestBody Map<String, String> map) {
        Map<String, String> result = userService.loginUser(map);
        return result;
    }

    @GetMapping("/getUser")
    public User getUser() {
        return new User();
    }
}
