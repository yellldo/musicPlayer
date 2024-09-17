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