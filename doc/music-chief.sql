drop table if exists author_info;
create table author_info
(
    author_id   bigint      not null primary key comment '主键',
    author_name varchar(50) not null comment '作者名称',
    gender      char(1) comment '性别 0、男 1、女',
    country     varchar(5) comment '国家编码',
    city        varchar(5) comment '城市编码',
    auth_status char(1)  default '0' comment '状态',
    is_delete   char(1)  default '0' comment '删除标志位0、未删除1、已删除',
    create_time datetime default now() comment '创建时间'
) comment '作者' charset = utf8mb4;

drop table if exists author_apply_info;
create table author_apply_info
(
    author_apply_id bigint        not null primary key comment '主键',
    user_id         bigint        not null comment '用户id',
    author_name     varchar(50)   not null comment '作者名称',
    gender          char(1) comment '性别 0、男 1、女',
    country         varchar(5) comment '国家编码',
    city            varchar(5) comment '城市编码',
    audit_status    char(1)  default '0' comment '审核状态 0、待审核 1、通过 2、拒绝',
    audit_remark    varchar(1000) null comment '审核备注',
    is_delete       char(1)  default '0' comment '删除标志位0、未删除1、已删除',
    create_time     datetime default now() comment '创建时间'
) comment '作者申请表' charset = utf8mb4;
