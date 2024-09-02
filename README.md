## 🐯 项目介绍

> 磊哥的音乐播放器

* Java后端：`master`分支为 JDk11 + SpringBoot 2.7.18
* 后端采用Spring Cloud Alibaba 微服务架构，注册中心 + 配置中心 Nacos，定时任务 XXL-job，服务保障 Sentinel，服务网关
  Gateway，分布式事物 Seata
* 数据库可使用 Mysql，基于 Mybatis plus 、 Redis + Redisson操作
* 消息队列可使用 RocketMq、Redis

## 🐼 内置功能

* 系统功能
* 基础设施
* 用户中心

### 系统功能

| 功能描述 | 描述                     |
|------|------------------------|
| 用户管理 | 用户是系统操作者，该功能主要完成系统用户配置 |
| 在线用户 | 当前系统中活跃用户状态监控，支持手动踢下线  |
| 角色管理 | 角色菜单权限分配、设置角色          |

