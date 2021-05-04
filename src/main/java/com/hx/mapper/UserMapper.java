package com.hx.mapper;

import com.hx.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    void saveUser(User user);
    User findUserByUsername(String username);
}
