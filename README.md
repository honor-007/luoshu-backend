# springcloud-base

#### 介绍
搭建一个基于spring3+版本和java17的微服务框架,实现高可用、可扩展和灵活部署。系统由多个微服务组成，通过服务注册与发现、配置管理、分布式事务等机制进行协同工作

springcloud-base为纯净版cloud,可以快速搭建后学习使用

develop分支在纯净版基础上开发的中后台基座,可满足快速开发的需求

以下内容介绍都是develop基座相关

#### 软件架构

#### 主要组件
* Nacos 服务注册中心和配置中心：负责微服务的注册与发现，确保各个服务之间能够相互找到和通信。
* Gateway 作为系统的统一入口，进行路由转发、安全控制、限流等操作
* Redis 用于缓存高频访问的数据，提升系统性能和响应速度。
* Minio 用于对象存储，提供可靠的非结构化数据存储服务。
* MapStruct：用于高效的 Java 对象映射转换
* saToken 轻量级的 Java 权限认证框架，主要解决登录认证、权限认证、Session 会话、单点登录、OAuth2.0、微服务网关鉴权等一系列权限相关问题
* OpenFeign 对Feign的进一步扩展和优化,对 Spring Cloud 生态的更好集成,进行服务间通信
* Knife4j 是一个基于 Swagger 2 的在线 API 文档框架,为 Java MVC 框架集成 Swagger 生成 API 文档提供了增强解决方案

#### 工程结构
``` 
Springcloud-base
├── auth -- 授权服务提供
├── common -- 常用工具封装包 通用配置文件
├── gateway -- Spring Cloud 网关
├── service -- 业务模块
├    ├── demo -- demo模块 
├    ├── system -- 系统模块 
├    ├── user -- 用户模块 
├    └── ... -- 扩展模块 
├── service-api -- 业务模块api封装
├    ├── demo-api -- 工作台api 
├    ├── system-api -- 系统api 
└──  ├── user-api -- 用户api 
├    └── ... -- 扩展api 
```

#### 安装教程

1.  xxxx
2.  xxxx
3.  xxxx

#### 使用说明

1.  xxxx
2.  xxxx
3.  xxxx

#### 交流

| 简介   | 内容                      |
|------|-------------------------|
| 交流一群 | `111111111` (满)         |
| 交流二群 | `222222222` (满)         |
| 交流三群 | `333333333` (满)         |
| 交流四群 | `444444444` (满)         |
| 交流五群 | `555555555` (满)         |
| 交流六群 | `666666666` (满)         |
| 交流七群 | `以上纯属扯淡,如有需要,请issues留言` |


#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
