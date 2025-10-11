create database music_user;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

drop table if exists user_info;
create table user_info(
	user_id bigint primary key not null comment '主键',
	user_type char(2) default '0' comment '用户类型 0、普通用户 1、VIP用户',
	user_status char(2) default '0' comment '用户状态0、正常1、禁用2、删除',
	nick_name varchar(50) not null comment '昵称',
	profile varchar(500) null comment '简介',
	phone varchar(15) null comment '手机号',
	email varchar(50) null comment '邮箱',
	avatar varchar(100) null comment '头像',
	gender char(1) default '0' comment '性别0、未知1、男2、女',
	birthday varchar(10) null comment '生日',
	province varchar(20) null comment '省份',
	city varchar(10) null comment '城市',
	is_delete char(1) null comment '是否删除0、未删除1、已删除',
	create_time datetime null comment '创建时间',
	update_time datetime null comment '更新时间',
  	create_by bigint comment '创建人',
  	update_by bigint comment '更新人'
)
