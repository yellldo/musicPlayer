drop table if exists sys_log;
create table sys_log
(
    id          bigint not null comment '主键'
        primary key,
    log_type    char(3) comment '日志类型',
    user_id     bigint comment '用户编号',
    user_type   char(1) comment '用户类型',
    user_name   varchar(20) comment '用户名称',
    ip          varchar(50) comment 'ip',
    request_uri varchar(100) comment '地址',
    method      varchar(50) comment '方法',
    params      varchar(100) comment '入参',
    exception   varchar(500) comment '异常信息',
    create_time datetime default CURRENT_TIMESTAMP
)
    comment '后台用户' charset = utf8mb4;

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

drop table if exists dict_info;
create table dict_info
(
    id          int auto_increment                 not null comment '主键'
        primary key,
    parent_id   int                                null comment '父级id',
    dict_type   varchar(50)                        null comment '类型',
    dict_key    varchar(50)                        not null comment '字典key',
    dict_value  varchar(200)                       not null comment '字典值',
    dict_status char     default '0'               null comment '状态 0、正常 1、禁用',
    dict_remark varchar(30)                        null comment '备注',
    is_delete   char     default '0'               null comment '删除标志位0、未删除1、已删除',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP null comment '更新时间',
    create_by   bigint                             null comment '创建人',
    update_by   bigint                             null comment '更新人'
)
    comment '字典表' charset = utf8mb4;


drop table if exists infra_file;
create table infra_file
(
    file_id      bigint       not null primary key,
    file_name    varchar(100) not null comment '文件名称',
    file_url     varchar(255) not null comment '文件访问地址',
    file_size    integer      not null comment '文件大小',
    file_channel char(1)      not null comment '文件渠道',
    is_delete    char(1)  default '0' comment '删除标志位 0、未删除 1、已删除',
    create_time  datetime default CURRENT_TIMESTAMP comment '创建时间',
    update_time  datetime comment '修改时间'
) comment '文件表' charset = utf8mb4;