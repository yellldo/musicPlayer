drop table if exists author_info;
create table author_info
(
    author_id        bigint      not null primary key comment '主键',
    author_name      varchar(50) not null comment '作者姓名',
    gender           char(1) comment '性别 0、男 1、女',
    id_number        varchar(20) comment '身份证',
    birthday         varchar(20) null comment '生日',
    school           varchar(30) null comment '学校',
    country          varchar(5) comment '国家编码',
    city             varchar(5) comment '城市编码',
    profile_photo    varchar(100) comment '头像',
    background_image varchar(100) comment '背景图',
    author_status    char(1)  default '0' comment '状态',
    is_delete        char(1)  default '0' comment '删除标志位0、未删除1、已删除',
    create_time      datetime default now() comment '创建时间'
) comment '作者' charset = utf8mb4;

create index idx_create_time_author_name on author_info (create_time, author_name);

drop table if exists author_apply_info;
create table author_apply_info
(
    author_apply_id  bigint        not null primary key comment '主键',
    user_id          bigint        not null comment '用户id',
    author_id        bigint comment '作者id',
    author_name      varchar(50)   not null comment '作者名称',
    gender           char(1) comment '性别 0、男 1、女',
    birthday         varchar(20)   null comment '生日',
    school           varchar(50)   null comment '学校',
    id_number        varchar(20) comment '身份证',
    country          varchar(5) comment '国家编码',
    city             varchar(5) comment '城市编码',
    profile_photo    varchar(100) comment '头像',
    background_image varchar(100) comment '背景图',
    audit_status     char(1)  default '0' comment '审核状态 0、待审核 1、通过 2、拒绝',
    audit_remark     varchar(1000) null comment '审核备注',
    is_delete        char(1)  default '0' comment '删除标志位0、未删除1、已删除',
    create_time      datetime default now() comment '创建时间'
) comment '作者申请表' charset = utf8mb4;

create index idx_create_time_author_name on author_apply_info (create_time, author_name);

drop table if exists music_info;
create table music_info
(
    music_id      bigint       not null primary key comment '主键',
    music_name    varchar(30)  not null comment '歌曲名称',
    author_id     bigint       not null comment '作者id',
    music_cover   varchar(500) null comment '封面',
    collect_count int          null comment '收藏数量',
    duration      int          null comment '时长',
    music_url     varchar(500) not null comment '歌曲链接',
    music_status  char(1)      null comment '歌曲状态 0、正常 1、上架 2、下架',
    is_delete     char(1)  default '0' comment '删除标志位0、未删除1、已删除',
    create_time   datetime default now() comment '创建时间'
) comment '歌曲表' charset = utf8mb4;

create index idx_create_time_music_name on music_info (create_time, music_name);

drop table if exists music_apply_info;
create table music_apply_info
(
    music_apply_id     bigint       not null primary key comment '主键',
    music_name         varchar(30)  not null comment '歌曲名称',
    author_id          bigint       not null comment '作者id',
    music_cover        varchar(500) null comment '封面',
    collect_count      int          null comment '收藏数量',
    duration           int          null comment '时长',
    music_url          varchar(500) not null comment '歌曲链接',
    music_apply_status char(1)  default '0' comment '审核状态 0、待审核 1、审核通过 2、审核拒绝',
    music_apply_remark varchar(500) comment '审核备注',
    is_delete          char(1)  default '0' comment '删除标志位0、未删除1、已删除',
    create_time        datetime default now() comment '创建时间'
) comment '歌曲表' charset = utf8mb4;

create index idx_create_time_music_name on music_apply_info (create_time, music_name);