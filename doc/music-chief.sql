drop table if exists auth_info;
create table auth_info
(
    auth_id     bigint      not null primary key comment '主键',
    auth_name   varchar(50) not null comment '作者名称',
    auth_status char(1)  default '0' comment '状态',
    is_delete   char(1)  default '0' comment '删除标志位0、未删除1、已删除',
    create_time datetime default now() comment '创建时间'
) comment '作者' charset = utf8mb4;