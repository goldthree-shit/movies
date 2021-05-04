package com.hx.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户实体类") // 给生成的文档加注释
public class User {
    @ApiModelProperty("用户id")
    private Long uid;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("用户密码，存进数据库之前经过MD5加密")
    private String password;
    @ApiModelProperty("是否具有管理员权限，1表示具有，0表示不具有")
    private String isAdmin;

}
