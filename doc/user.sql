create database music_user;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

drop table if exists user_info;
create table user_info(
	user_id bigint primary key not null comment '主键',
	user_type char(2) default '0' comment '用户类型 0、普通用户 1、VIP用户',
	membership_level int default 0 comment '会员等级',
	user_status char(2) default '0' comment '用户状态0、正常1、禁用2、删除',
	nick_name varchar(50) not null comment '昵称',
    art_id bigint  null comment '作者id',
	profile varchar(500) null comment '简介',
	phone varchar(15) null comment '手机号',
	avatar varchar(100) null comment '头像',
	gender char(1) default '2' comment '性别0、男 1、女 2、未知',
	birthday varchar(10) null comment '生日',
	province varchar(20) null comment '省份',
	city varchar(10) null comment '城市',
	grade int default 0 comment '等级',
	follower_count bigint default 0 comment '粉丝数',
	following_count bigint default 0 comment '关注数',
	is_artist char(1) default '0' comment '是否认证作者 0、否 1、是',
	is_authentication char(1) default '0' comment '是否实名认证 0、否 1、是',
	is_delete char(1) null comment '是否删除0、未删除1、已删除',
	create_time datetime null comment '创建时间',
	update_time datetime null comment '更新时间',
  	create_by bigint comment '创建人',
  	update_by bigint comment '更新人'
) comment '用户表' charset = utf8mb4;

drop table if exists user_message;
create table user_message(
	id bigint primary key not null comment '主键',
	message_title varchar(200) comment '消息标题',
	message_type char(2) comment '消息类型',
	message_content text comment '消息内容',
	is_read char(1) default '0' comment '是否已读，0、否 1、是',
	send_id bigint not null comment '发送方',
	receive_id bigint not null comment '接收方',
	create_time datetime null comment '创建时间',
	update_time datetime null comment '更新时间',
    create_by bigint comment '创建人',
    update_by bigint comment '更新人'
) comment '用户消息' charset = utf8mb4;

drop table if exists user_points;
create table points(

)


drop table if exists user_login_log;
create table user_login_log(
    id bigint primary key not null,
    user_id bigint not null,
    login_name varchar(50) not null comment '登陆账号',
    is_success char(1) comment '登陆结果 0、成功 1、失败',
    ip varchar(15) null comment '登录ip',
    device varchar(20) null comment '登录设备',
 	create_time datetime  comment '创建时间'
) comment '登录日志表' charset = utf8mb4;

drop table if exists user_relationship;
create table user_relationship(
    id bigint not null,
    follower_id bigint not null comment '关注者ID',
    followed_id bigint not null comment '被关注者ID',
    create_time datetime comment '被关注的时间'
) comment '用户社交关系表' charset = utf8mb4;

alter table user_relationship add unique (follower_id,followed_id);

drop table if exists user_message;
create table user_message(
    id bigint not null,
    user_id bigint not null comment '接收方',
    is_read char(1) not null comment '阅读标记 0、未读 1、已读',
    message_type char(2) not null comment '消息类型 0、官方推送 ',
    message_title varchar(20) not null comment '消息标题',
    message_content varchar(1000) not null comment '消息内容',
    create_time datetime comment '被关注的时间'
) comment '用户关注表' charset = utf8mb4;


drop table if exists user_favorite_song;
create table user_favorite_song(
(
    id bigint primary key not null,
    user_id bigint not null comment '用户ID',
    song_id bigint not null comment '歌曲ID',
    create_time datetime comment '收藏时间'
) comment '用户收藏歌曲表' charset = utf8mb4;


-- ========== 会员管理模块 ==========

drop table if exists member;
create table member(
    id bigint primary key not null comment '主键',
    user_id bigint comment '关联用户ID',
    username varchar(50) comment '用户名',
    nickname varchar(50) comment '昵称',
    avatar varchar(200) comment '头像',
    phone varchar(15) comment '手机号',
    gender char(1) default 'U' comment '性别 M=男 F=女 U=未知',
    birthday date comment '生日',
    level_id bigint comment '会员等级ID',
    group_id bigint comment '会员分组ID',
    tag_ids varchar(500) comment '标签ID列表，逗号分隔',
    points int default 0 comment '积分',
    status char(1) default '0' comment '状态 0=正常 1=冻结',
    is_delete char(1) default '0' comment '是否删除 0=未删除 1=已删除',
    create_by bigint comment '创建人',
    create_time datetime comment '创建时间',
    update_by bigint comment '更新人',
    update_time datetime comment '更新时间'
) comment '会员表' charset = utf8mb4;

drop table if exists member_level;
create table member_level(
    id bigint primary key not null comment '主键',
    name varchar(50) not null comment '等级名称',
    level int not null comment '等级数值，越大越高',
    icon varchar(200) comment '图标URL',
    discount int comment '折扣百分比，如90表示9折',
    description varchar(500) comment '描述',
    sort int default 0 comment '排序',
    status char(1) default '0' comment '状态 0=启用 1=禁用',
    is_delete char(1) default '0' comment '是否删除 0=未删除 1=已删除',
    create_by bigint comment '创建人',
    create_time datetime comment '创建时间',
    update_by bigint comment '更新人',
    update_time datetime comment '更新时间'
) comment '会员等级表' charset = utf8mb4;

drop table if exists member_tag;
create table member_tag(
    id bigint primary key not null comment '主键',
    name varchar(50) not null comment '标签名称',
    color varchar(20) comment '标签颜色，如 #FF5722',
    sort int default 0 comment '排序',
    status char(1) default '0' comment '状态 0=启用 1=禁用',
    is_delete char(1) default '0' comment '是否删除 0=未删除 1=已删除',
    create_by bigint comment '创建人',
    create_time datetime comment '创建时间',
    update_by bigint comment '更新人',
    update_time datetime comment '更新时间'
) comment '会员标签表' charset = utf8mb4;

drop table if exists member_group;
create table member_group(
    id bigint primary key not null comment '主键',
    name varchar(50) not null comment '分组名称',
    sort int default 0 comment '排序',
    status char(1) default '0' comment '状态 0=启用 1=禁用',
    is_delete char(1) default '0' comment '是否删除 0=未删除 1=已删除',
    create_by bigint comment '创建人',
    create_time datetime comment '创建时间',
    update_by bigint comment '更新人',
    update_time datetime comment '更新时间'
) comment '会员分组表' charset = utf8mb4;
