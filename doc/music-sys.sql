drop table if exists sys_log;
create table sys_log
(
    id          bigint                  not null comment '编号'
        primary key,
    log_type    char        default '0' null comment '日志类型',
    title       varchar(255)            null comment '日志标题',
    service_id  varchar(32)             null comment '服务ID',
    create_by   varchar(64) default ' ' null comment '创建人',
    update_by   varchar(64) default ' ' null comment '修改人',
    create_time datetime                null comment '创建时间',
    update_time datetime                null comment '更新时间',
    remote_addr varchar(255)            null comment '远程地址',
    user_agent  varchar(1000)           null comment '用户代理',
    request_uri varchar(255)            null comment '请求URI',
    method      varchar(10)             null comment '请求方法',
    params      text                    null comment '请求参数',
    time        bigint                  null comment '执行时间',
    del_flag    char        default '0' null comment '删除标志',
    exception   text                    null comment '异常信息'
)
    comment '日志表' collate = utf8mb4_general_ci;

create index sys_log_create_date on sys_log (create_time);

create index sys_log_request_uri on sys_log (request_uri);

create index sys_log_type on sys_log (log_type);

drop table if exists sys_menu;
create table sys_menu
(
    menu_id     bigint                                                not null comment '菜单ID'
        primary key,
    menu_name   varchar(32)                                           null comment '菜单名称',
    en_name     varchar(128)                                          null comment '英文名称',
    permission  varchar(32)                                           null comment '权限标识',
    path        varchar(128)                                          null comment '路由路径',
    parent_id   bigint                                                null comment '父菜单ID',
    icon        varchar(64)                                           null comment '菜单图标',
    visible     char                        default '1'               null comment '是否可见，0隐藏，1显示',
    sort_order  int                         default 1                 null comment '排序值，越小越靠前',
    keep_alive  char                        default '0'               null comment '是否缓存，0否，1是',
    embedded    char                                                  null comment '是否内嵌，0否，1是',
    menu_type   char                        default '0'               null comment '菜单类型，0目录，1菜单，2按钮',
    create_by   varchar(64) charset utf8mb3 default ' '               null comment '创建人',
    create_time datetime                    default CURRENT_TIMESTAMP null comment '创建时间',
    update_by   varchar(64) charset utf8mb3 default ' '               null comment '修改人',
    update_time datetime                                              null on update CURRENT_TIMESTAMP comment '更新时间',
    del_flag    char                        default '0'               null comment '删除标志，0未删除，1已删除'
)
    comment '菜单权限表' collate = utf8mb4_general_ci;

drop table if exists sys_role;
create table sys_role
(
    role_id     bigint                                                not null comment '角色ID'
        primary key,
    role_name   varchar(64)                                           null comment '角色名称',
    role_code   varchar(64)                                           null comment '角色编码',
    role_desc   varchar(255)                                          null comment '角色描述',
    create_by   varchar(64) charset utf8mb3 default ' '               not null comment '创建人',
    update_by   varchar(64) charset utf8mb3 default ' '               not null comment '修改人',
    create_time datetime                    default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time datetime                                              null on update CURRENT_TIMESTAMP comment '更新时间',
    del_flag    char                        default '0'               null comment '删除标记，0未删除，1已删除'
)
    comment '系统角色表' collate = utf8mb4_general_ci;

create index role_idx_role_code on sys_role (role_code);
