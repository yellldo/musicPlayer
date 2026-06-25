create
database music_content;
SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;


drop table if exists artists;
create table artists
(
    art_id      bigint primary key not null comment '主键',
    user_id     bigint             not null comment '用户id',
    art_name    varchar(20) comment '歌手名',
    alias       varchar(100) comment '别名',
    art_status  char(1) default '0' comment '歌手状态',
    avatar_url  varchar(500) comment '歌手头像',
    cover_url   varchar(500) comment '歌手封面图',
    description text comment '歌手介绍',
    music_size  int     default 0 comment '歌曲数量',
    album_size  int     default 0 comment '专辑数量',
    is_delete   char(1) null comment '是否删除0、未删除1、已删除',
    create_time datetime null comment '创建时间',
    update_time datetime null comment '更新时间',
    create_by   bigint comment '创建人',
    update_by   bigint comment '更新人'
) comment '歌手表' CHARSET = utf8mb4;

drop table if exists artists_audit;
create table artists_audit
(
    id             bigint primary key not null comment '主键',
    user_id        bigint             not null comment '用户id',
    audit_status   char(1)            not null default 1 comment '审核状态: 1-待审核, 2-审核通过, 3-审核驳回, 4-已撤销',
    audit_type     char(1)            not null comment '审核类型: 1-创建, 2-修改',
    reject_reason  text null comment '驳回原因 (当 audit_status=3 时必填)',
    submitted_data json               not null comment '提交的完整艺术家数据(json)，包含所有变更字段',
    auditor_id     bigint unsigned null comment '审核人id (关联 users.user_id)',
    audit_notes    text null comment '审核备注 (内部使用)',
    audited_time   datetime null comment '审核时间',
    is_delete      char(1) null comment '是否删除0、未删除1、已删除',
    create_time    datetime null comment '创建时间',
    update_time    datetime null comment '更新时间',
    withdrawn_time datetime null comment '撤销时间 (当 audit_status=4 时)',
    create_by      bigint comment '创建人',
    update_by      bigint comment '更新人'
) comment '歌手审核表' CHARSET = utf8mb4;


-- ----------------------------
-- 广告投放表
-- ----------------------------
DROP TABLE IF EXISTS advertise;
CREATE TABLE advertise
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT  NOT NULL  COMMENT '主键',
    title       VARCHAR(100) NOT NULL COMMENT '广告标题',
    type        VARCHAR(20)  NOT NULL COMMENT '广告类型: splash=开屏, feed=信息流, audio=音频贴片',
    image_url   VARCHAR(500) NULL      COMMENT '广告图片URL',
    link_url    VARCHAR(500) NULL      COMMENT '跳转链接',
    position    VARCHAR(100) NULL      COMMENT '投放位置',
    sort_order  INT     DEFAULT 0 NULL      COMMENT '排序',
    start_time  DATETIME NULL      COMMENT '开始时间',
    end_time    DATETIME NULL      COMMENT '结束时间',
    status      CHAR(1) DEFAULT '1' NULL      COMMENT '状态: 0=上线, 1=下线',
    remark      VARCHAR(500) NULL      COMMENT '备注',
    is_delete   CHAR(1) DEFAULT '0' NULL      COMMENT '是否删除: 0=未删除, 1=已删除',
    create_time DATETIME NULL      COMMENT '创建时间',
    update_time DATETIME NULL      COMMENT '更新时间',
    create_by   BIGINT NULL      COMMENT '创建人',
    update_by   BIGINT NULL      COMMENT '更新人'
) COMMENT '广告投放表' CHARSET = utf8mb4;

-- ----------------------------
-- 活动运营表
-- ----------------------------
DROP TABLE IF EXISTS activity;
CREATE TABLE activity
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT  NOT NULL  COMMENT '主键',
    name        VARCHAR(100) NOT NULL COMMENT '活动名称',
    type        VARCHAR(20)  NOT NULL COMMENT '活动类型: platform=平台活动, brand=品牌合作, campus=校园推广',
    cover_url   VARCHAR(500) NULL      COMMENT '封面图URL',
    description VARCHAR(2000) NULL      COMMENT '活动描述',
    start_time  DATETIME NULL      COMMENT '开始时间',
    end_time    DATETIME NULL      COMMENT '结束时间',
    status      CHAR(1) DEFAULT '0' NULL      COMMENT '状态: 0=进行中, 1=已结束',
    remark      VARCHAR(500) NULL      COMMENT '备注',
    is_delete   CHAR(1) DEFAULT '0' NULL      COMMENT '是否删除: 0=未删除, 1=已删除',
    create_time DATETIME NULL      COMMENT '创建时间',
    update_time DATETIME NULL      COMMENT '更新时间',
    create_by   BIGINT NULL      COMMENT '创建人',
    update_by   BIGINT NULL      COMMENT '更新人'
) COMMENT '活动运营表' CHARSET = utf8mb4;

-- ----------------------------
-- 歌单审核表
-- ----------------------------
DROP TABLE IF EXISTS playlist_audit;
CREATE TABLE playlist_audit
(
    id               BIGINT PRIMARY KEY AUTO_INCREMENT  NOT NULL  COMMENT '主键',
    playlist_name    VARCHAR(100) NOT NULL COMMENT '歌单名称',
    cover_url        VARCHAR(500) NULL      COMMENT '封面图URL',
    description      VARCHAR(2000) NULL      COMMENT '歌单描述',
    tags             VARCHAR(500) NULL      COMMENT '标签，逗号分隔',
    song_list        TEXT NULL      COMMENT '歌曲列表JSON，存歌曲ID和名称',
    submit_user_id   BIGINT       NOT NULL COMMENT '提交用户ID',
    submit_user_name VARCHAR(50) NULL      COMMENT '提交用户名',
    audit_status     VARCHAR(20) DEFAULT 'pending' NULL      COMMENT '审核状态: pending=待审核, approved=已通过, rejected=已驳回',
    audit_opinion    VARCHAR(1000) NULL      COMMENT '审核意见',
    audit_user_id    BIGINT NULL      COMMENT '审核人ID',
    audit_user_name  VARCHAR(50) NULL      COMMENT '审核人用户名',
    audit_time       DATETIME NULL      COMMENT '审核时间',
    is_delete        CHAR(1)     DEFAULT '0' NULL      COMMENT '是否删除: 0=未删除, 1=已删除',
    create_time      DATETIME NULL      COMMENT '创建时间',
    update_time      DATETIME NULL      COMMENT '更新时间',
    create_by        BIGINT NULL      COMMENT '创建人',
    update_by        BIGINT NULL      COMMENT '更新人'
) COMMENT '歌单审核表' CHARSET = utf8mb4;

-- ----------------------------
-- 音乐类型表
-- ----------------------------
DROP TABLE IF EXISTS genre;
CREATE TABLE genre
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT  NOT NULL  COMMENT '主键',
    name        VARCHAR(100) NOT NULL COMMENT '类型名称',
    description VARCHAR(500) NULL      COMMENT '类型描述',
    sort_order  INT     DEFAULT 0 NULL      COMMENT '排序',
    status      CHAR(1) DEFAULT '0' NULL      COMMENT '状态: 0=启用, 1=禁用',
    remark      VARCHAR(500) NULL      COMMENT '备注',
    is_delete   CHAR(1) DEFAULT '0' NULL      COMMENT '是否删除: 0=未删除, 1=已删除',
    create_time DATETIME NULL      COMMENT '创建时间',
    update_time DATETIME NULL      COMMENT '更新时间',
    create_by   BIGINT NULL      COMMENT '创建人',
    update_by   BIGINT NULL      COMMENT '更新人'
) COMMENT '音乐类型表' CHARSET = utf8mb4;

SET
FOREIGN_KEY_CHECKS = 1;
