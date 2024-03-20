drop table if exists sys_user;
create table sys_user
(
    user_id     bigint primary key   not null,
    user_name   varchar(50)          not null comment '姓名',
    login_type  char(1)              not null comment '登录方式',

    user_status char(1)  default '0' not null comment '状态',
    create_time datetime default now()
)
    comment '后台用户' charset = utf8mb4;