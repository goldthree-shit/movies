# 工程简介
电影管理网站后端，springboot

实现用户的登录注册，使用jwt进行验证。需要在请求头里携带token信息

电影的基本增删改查需求，分页查询。
dev模式 http://localhost:8000/swagger-ui.html
上线模式 http://localhost:80

本来删除应该是逻辑删除的，同时应该加上gmt_create,gmt_update字段，但是
mybatis做起来比较麻烦。同时乐观锁什么的没有做。

