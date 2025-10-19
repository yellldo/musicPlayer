create database music_system;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

drop table if exists dict_info;
create table dict_info (
  id bigint primary key auto_increment not null comment '主键',
  dict_type varchar(50) default null comment '字典类型',
  dict_code varchar(50) comment '字典编码',
  dict_name varchar(50) comment '字典名称',
  dict_status char(1) default '0' comment '状态 0、正常 1、禁用',
  dict_remark varchar(30) default null comment '备注',
  sort int comment '排序',
  is_delete char(1) default '0' comment '删除标志位0、未删除1、已删除',
  create_time datetime comment '创建时间',
  update_time datetime comment '更新时间',
  create_by bigint default null comment '创建人',
  update_by bigint default null comment '更新人'
)
comment '字典表' charset = utf8mb4;
drop table if exists dict_detail;
create table dict_detail(
	id bigint primary key auto_increment not null comment '主键',
	parent_id bigint not null,
	dict_label varchar(50) comment '',
	dict_value varchar(10) comment '',
	dict_remark varchar(100) comment '',
	dict_status char(1) comment '',
	sort int comment '排序',
  	is_delete char(1) default '0' comment '删除标志位0、未删除1、已删除',
	create_time datetime comment '创建时间',
  	update_time datetime comment '更新时间',
  	create_by bigint default null comment '创建人',
  	update_by bigint default null comment '更新人'
) comment '字典明细表' charset = utf8mb4;

drop table if exists sys_user;
create table sys_user(
    user_id bigint primary key not null,
    login_name varchar(10) not null comment '登录账号',
    nick_name varchar(20) null comment '昵称',
    password varchar(50) not null comment '密码',
    user_status char(1) default '0' comment '状态0、正常1、禁用',
    remark varchar(100) null comment '用户备注',
    error_count int null comment '错误次数',
    is_reset char(1) default '0' comment '是否要重置密码 0、否 1、是 ',
    is_super char(1) default '0' comment '是否超级用户 0、否 1、是',
    is_delete char(1) default '0' comment '删除状态 0、未删除 1、已删除',
    create_time datetime null comment '创建时间',
    update_time datetime null comment '更新时间',
    create_by bigint comment '创建人',
    update_by bigint comment '更新人'
) comment '后台用户表' charset = utf8mb4;

drop table if exists sys_role;
create table sys_role(
    role_id bigint primary key not null,
    role_name varchar(10) comment '角色名称',
    role_remark varchar(50) comment '角色描述',
    role_status char(1) default '0' comment '角色状态 0、正常 1、禁用',
    is_delete char(1) default '0' comment '删除状态 0、未删除 1、已删除',
    create_time datetime null comment '创建时间',
    update_time datetime null comment '更新时间',
    create_by bigint comment '创建人',
    update_by bigint comment '更新人'
) comment '后台角色表' charset = utf8mb4;

drop table if exists sys_user_role;
create table sys_user_role(
    user_id bigint not null,
    role_id bigint not null
) comment '后台用户角色关联表' charset = utf8mb4;

alter table sys_user_role add primary key (user_id, role_id);

drop table if exists sys_menu;
create table sys_menu(
    menu_id bigint primary key not null,
    parent_id bigint not null comment '父级菜单id',
    menu_name varchar(10) comment '菜单名称',
    icon varchar(10) comment '菜单图标',
    level int comment '菜单级别',
    permission varchar(20) comment '权限',
    menu_type char(10) comment '菜单类型',
    menu_path varchar(20) comment '菜单路径',
    menu_status char(1) default '0' comment '菜单状态 0、启用 1、禁用',
    component_path varchar(50) comment '组件路径',
    is_delete char(1) default '0' comment '删除状态 0、未删除 1、已删除',
    create_time datetime null comment '创建时间',
    update_time datetime null comment '更新时间',
    create_by bigint comment '创建人',
    update_by bigint comment '更新人'
) comment '后台菜单表' charset = utf8mb4;

drop table if exists sys_role_menu;
create table sys_role_menu(
    role_id bigint not null,
    menu_id bigint not null
) comment '后台角色菜单关联表' charset = utf8mb4;

alter table sys_role_menu add primary key (role_id, menu_id);