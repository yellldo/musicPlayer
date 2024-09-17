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

### 基础设施

| 功能描述 | 描述                      |
|------|-------------------------|
| 系统日志 | 用户的所有操作都是记录             |
| 字典配置 | 系统内的                    |
| 角色管理 | 角色菜单权限分配、设置角色           |
| 文件服务 | 支持将文件存储到 S3、本地、FTP、数据库等 |

## 🐨 技术栈

### 微服务

| 项目                 | 说明           |
|--------------------|--------------|
| music-dependencies | Maven 依赖版本管理 |
| music-framework    | Java 框架拓展    |
| music-auth-mgt     | 用户管理模块       |
| music-infra-mgt    | 基础设施模块       |
| music-message-mgt  | 消息模块         |
| music-pay-mgt      | 支付模块         |
|                    |              |

### 框架

| 框架                   | 说明             | 版本          | 学习指南 |
|----------------------|----------------|-------------|------|
| Spring Cloud Alibaba | 微服务框架          | 2021.0.6.0  |      |
| Nacos                | 配置中心 & 注册中心    | 2.0.0       |      |
| Spring Cloud Gateway | 服务网关           | 3.1.9       |      |
| Mysql                | 数据库            | 5.7/8.0     |      |
| Mybatis plus         | Mybatis增强框架    | 3.5.5       |      |
| Redis                | key-value 数据库  | 5.0/6.0     |      |
| Druid                | JDBC 连接池、监控组件  | 1.2.8       |      |
| Redisson             | Redis 客户端      | 3.1.18      |      |
| Knife4j              | Swagger 增强UI实现 | 3.0.2       |      |
| Fastjson2            | JSON 工具库       |             |      |
| Mapstrut             | Java Bean 转换   | 1.4.2.Final |      |
| Lombok               | 消除冗长的 Java 代码  | 1.18.30     |      |
|                      |                |             |      |
|                      |                |             |      |

