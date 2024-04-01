drop table if exists infra_api_access_log;
create table infra_api_access_log
(
    id               bigint auto_increment comment '日志主键'
        primary key,
    trace_id         varchar(64)   default ''                not null comment '链路追踪编号',
    user_id          bigint        default 0                 not null comment '用户编号',
    user_type        tinyint       default 0                 not null comment '用户类型',
    application_name varchar(50)                             not null comment '应用名',
    request_method   varchar(16)   default ''                not null comment '请求方法名',
    request_url      varchar(255)  default ''                not null comment '请求地址',
    request_params   varchar(8000) default ''                not null comment '请求参数',
    user_ip          varchar(50)                             not null comment '用户 IP',
    user_agent       varchar(512)                            not null comment '浏览器 UA',
    begin_time       datetime                                not null comment '开始请求时间',
    end_time         datetime                                not null comment '结束请求时间',
    duration         int                                     not null comment '执行时长',
    result_code      int           default 0                 not null comment '结果码',
    result_msg       varchar(512)  default ''                null comment '结果提示',
    creator          varchar(64)   default ''                null comment '创建者',
    create_time      datetime      default CURRENT_TIMESTAMP not null comment '创建时间',
    updater          varchar(64)   default ''                null comment '更新者',
    update_time      datetime      default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    deleted          bit           default b'0'              not null comment '是否删除',
    tenant_id        bigint        default 0                 not null comment '租户编号'
)
    comment 'API 访问日志表' charset = utf8mb4;

create index idx_create_time
    on infra_api_access_log (create_time);