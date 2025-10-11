create database music_infra;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

drop table if exists dict_info;
create table dict_info (
  id bigint primary key auto_increment not null comment '主键',
  parent_id bigint default null comment '父级id',
  dict_type varchar(50) default null comment '类型',
  dict_key varchar(50) not null comment '字典key',
  dict_value varchar(200) not null comment '字典值',
  dict_status char(1) default '0' comment '状态 0、正常 1、禁用',
  dict_remark varchar(30) default null comment '备注',
  is_delete char(1) default '0' comment '删除标志位0、未删除1、已删除',
  create_time datetime comment '创建时间',
  update_time datetime comment '更新时间',
  create_by bigint default null comment '创建人',
  update_by bigint default null comment '更新人'
)
comment '字典表' charset = utf8mb4;

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