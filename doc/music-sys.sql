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
    create_time datetime default CURRENT_TIMESTAMP
)
    comment '后台用户' charset = utf8mb4;