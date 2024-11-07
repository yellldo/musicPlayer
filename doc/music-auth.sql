drop table if exists sys_user;
create table sys_user
(
    user_id     bigint                             not null
        primary key,
    login_name  varchar(50)                        not null comment '登录名称',
    nick_name   varchar(20)                        null comment '昵称',
    password    varchar(100)                       null comment '密码',
    user_status char     default '0'               not null comment '状态',
    is_delete   char     default '0'               null comment '删除状态 0、否1、是',
    create_time datetime default CURRENT_TIMESTAMP null
)
    comment '后台用户' charset = utf8mb4;

create index idx_create_time on sys_user (create_time);

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

drop table if exists sys_menu;
create table sys_menu
(
    menu_id         bigint                             not null
        primary key,
    menu_name       varchar(50)                        not null comment '菜单名称',
    menu_url        varchar(50)                        not null comment '菜单路径',
    menu_permission varchar(255)                       not null comment '菜单权限',
    menu_type       char(1)                            not null comment '类型 0、菜单 1、按钮',
    menu_status     char(1)  default '0'               null comment '菜单状态 0、启用 1、禁用',
    menu_icon       varchar(255)                       null comment '菜单图标',
    level           int      default 0                 not null comment '菜单层级',
    parent_id       bigint                             null comment '上级菜单id',
    priority        int      default 0                 null comment '排序',
    is_delete       char(1)  default '0'               null comment '删除状态 0、否1、是',
    create_time     datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_time     datetime                           null comment '更新时间'
)
    comment '后台菜单' charset = utf8mb4;

drop table if exists sys_role;
create table sys_role
(
    role_id     bigint                             not null
        primary key,
    role_name   varchar(50)                        not null comment '角色名称',
    role_desc   varchar(500)                       null comment '角色说明',
    enable      char(1)  default '1'               not null comment '状态：1启用0、禁用',
    is_delete   char(1)                            null comment '删除状态 0、否1、是',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    create_by   bigint                             null comment '创建人',
    update_time datetime                           null comment '更新时间',
    update_by   bigint                             null comment '更新人'
)
    comment '后台角色' charset = utf8mb4;

drop table if exists sys_user_role;
create table sys_user_role
(
    user_id bigint not null comment '用户id',
    role_id bigint not null comment '角色id',
    primary key (user_id, role_id)
)
    comment '后台角色' charset = utf8mb4;

drop table if exists sys_role_menu;
create table sys_role_menu
(
    role_id bigint not null comment '角色id',
    menu_id bigint not null comment '菜单id',
    primary key (role_id, menu_id)
)
    comment '后台角色' charset = utf8mb4;


