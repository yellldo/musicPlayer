create database music_content;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


drop table artists;
create table artists(
	art_id bigint primary key not null comment '主键',
	user_id bigint not null comment '用户id',
	art_name varchar(20) comment '歌手名',
	alias varchar(100) comment '别名',
	avatar_url varchar(500) comment '歌手头像',
	cover_url varchar(500) comment '歌手封面图',
	description text comment '歌手介绍',
	music_size int comment '歌曲数量',
	album_size int comment '专辑数量',
	create_time datetime null comment '创建时间',
	update_time datetime null comment '更新时间',
  	create_by bigint comment '创建人',
  	update_by bigint comment '更新人'
) comment '歌手表',


