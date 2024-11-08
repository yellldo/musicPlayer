

drop table if exists user_info;
create table user_info
 (
     user_id     bigint                             not null
         primary key,
     user_name   varchar(50)                        not null comment '姓名',
     login_type  char                               not null comment '登录方式',
     user_type   char                               null comment '用户类型 0、普通用户1、认证音乐人、2、歌手等',
     password    varchar(100)                       null comment '密码',
     phone       varchar(20)                        null comment '手机号',
     email       varchar(50)                        null comment '邮箱',
     user_status char     default '0'               not null comment '状态',
     is_delete   char     default '0'               null comment '删除状态 0、否1、是',
     is_vip      char     default '0'               null comment '是否vip 0、否1、是',
     vip_level   int      default 0                 null comment 'vip等级',
     create_time datetime default CURRENT_TIMESTAMP null
 )
     comment '门户用户' charset = utf8mb4;

drop table if exists user_author_info;
create table user_author_info
(
    user_id     bigint not null comment '用户id',
    author_id   bigint not null comment '作者id',
    is_delete   char(1)  default '0' comment '删除标志位0、未删除1、已删除',
    create_time datetime default now() comment '创建时间',
    primary key (user_id, author_id)
) comment '用户作者关联表' charset = utf8mb4;



