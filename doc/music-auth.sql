drop table if exists sys_user;
create table sys_user
(
    user_id     bigint primary key   not null,
    user_name   varchar(50)          not null comment '姓名',
    login_type  char(1)              not null comment '登录方式',
    password    varchar(100)         null comment '密码',
    phone       varchar(20)          null comment '手机号',
    email       varchar(50)          null comment '邮箱',
    user_status char(1)  default '0' not null comment '状态',
    is_delete   char(1)  default '0' comment '删除状态 0、否1、是',
    create_time datetime default now(),
    is_vip int DEFAULT NULL COMMENT '是否vip',
)
    comment '后台用户' charset = utf8mb4;