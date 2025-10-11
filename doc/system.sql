create database music_system;
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

drop table if exists sys_user;
create table sys_user(
    user_id bigint primary key not null,
    login_name varchar(10) not null comment '登录账号',
    password varchar(50) not null comment '密码',
    user_status char(1) default '0' comment '状态0、正常1、禁用',
    remark varchar(100) null comment '用户备注',
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
    menu_type char(1) comment '菜单类型 0、 菜单 1、按钮',
    is_show char(1) comment '是否展示 0、是 1、否',
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