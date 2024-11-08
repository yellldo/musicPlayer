drop table if exists message_info;
create table message_info
(
    message_id       bigint primary key not null comment '主键',
    message_type     char(1) comment '消息类型 1、短信 2、邮件',
    message_title    varchar(50) comment '标题',
    message_content  varchar(500) comment '内容',
    message_status   char(1) comment '消息状态 0、未发送 1、发送成功 2、发送失败',
    message_receiver varchar(50) comment '收件人',
    retry_count      int      default 0 comment '重试次数',
    is_delete        char(1)  default '0' comment '删除标志位0、未删除1、已删除',
    create_time      datetime default now() comment '创建时间'
) comment '消息表' charset = utf8mb4;