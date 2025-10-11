create database music_infra;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;



drop table if exists infra_api_error_log;
create table infra_api_error_log
(
    id bigint auto_increment not null comment '主键' primary key,
    user_id bigint not null comment '用户id',
    user_type char(3) not null comment '用户类型',
    trance_id varchar(50) null comment '链路追踪编号',
    application_name varchar(50) null comment '应用名称',
    request_url varchar(100) null comment '访问地址',
    request_method varchar(100) null comment '访问方法',
    request_param varchar(5000) null comment '请求参数',
    exception_name varchar(100) null comment '异常名',
    exception_time datetime null comment '异常发生时间',
    exception_message text null comment '异常导致的消息',
    exception_root_cause_message text null comment '异常导致的根消息',
    exception_class_name varchar(1000) null comment '异常发生的类全名',
    exception_method_name varchar(1000) null comment '异常发生的方法名'
)
    comment '系统异常日志' charset = utf8mb4;