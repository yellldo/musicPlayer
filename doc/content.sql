create database music_content;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


drop table if exists  artists;
create table artists(
	art_id bigint primary key not null comment '主键',
	user_id bigint not null comment '用户id',
	art_name varchar(20) comment '歌手名',
	alias varchar(100) comment '别名',
    art_status char(1) default '0' comment '歌手状态',
	avatar_url varchar(500) comment '歌手头像',
	cover_url varchar(500) comment '歌手封面图',
	description text comment '歌手介绍',
	music_size int default 0 comment '歌曲数量',
	album_size int default 0 comment '专辑数量',
	is_delete char(1) null comment '是否删除0、未删除1、已删除',
	create_time datetime null comment '创建时间',
	update_time datetime null comment '更新时间',
  	create_by bigint comment '创建人',
  	update_by bigint comment '更新人'
) comment '歌手表';

drop table if exists artists_audit;
create table artists_audit (
  id bigint primary key not null comment '主键',
  user_id bigint not null comment '用户id',
  audit_status char(1) not null default 1 comment '审核状态: 1-待审核, 2-审核通过, 3-审核驳回, 4-已撤销',
  audit_type char(1) not null comment '审核类型: 1-创建, 2-修改',
  reject_reason text null comment '驳回原因 (当 audit_status=3 时必填)',
  submitted_data json not null comment '提交的完整艺术家数据(json)，包含所有变更字段',
  auditor_id bigint unsigned null comment '审核人id (关联 users.user_id)',
  audit_notes text null comment '审核备注 (内部使用)',
  audited_time datetime null comment '审核时间',
  is_delete char(1) null comment '是否删除0、未删除1、已删除',
  create_time datetime null comment '创建时间',
  update_time datetime null comment '更新时间',
  withdrawn_time datetime null comment '撤销时间 (当 audit_status=4 时)',
  create_by bigint comment '创建人',
  update_by bigint comment '更新人'
) comment '歌手审核表';