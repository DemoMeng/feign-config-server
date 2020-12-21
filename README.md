#分布式配置中心

###配置文件名与URL的映射关系
    
    Config Server 中配置文件的 HTTP 资源操作方式如下
    
    /{application}/{profile}[/{label}]
    /{application}-{profile}.yml
    /{label}/{application}-{profile}.yml
    /{application}-{profile}.properties
    /{label}/{application}-{profile}.properties
    
    其中，配置中心的客户端访问配置中心的配置文件规则： feign-client-consumer-dev.yml 其中，feign-client-consumer 是应用名，dev是文件
    {application} 被用于 spring 配置的配置文件名称，在 spring boot 中通常默认为 application；
    {profile} 表示激活的配置文件，通常用于区分开发(dev)/测试(test)/生产环境(prod)；
    {label} 则表示 git 的分支，默认为 master。
    
    
### 三种方式实现配置文件读取：

`1.git方式：`
    
       a : git仓库创建一个config仓库， https://github.com/DemoMeng/config
            创建配置文件，文件名称规范为： {application}-{profile}.properties
            
       b : 启动类上加上 @EnableConfigServer 注解
       
       c : application.yml 配置文件配置：
       
           spring:
             application:
               name: feign-config-server
             profiles:
               active: git #设置使用本地配置(默认是git,可以设置：subversion(SVN)，native(本地))
             cloud:
               config:
                 server:
                   #如下是GIT配置
                   git:
                     uri: https://github.com/DemoMeng/config     # 配置git仓库的地址（最后不需要带/，否则会出现：No custom http config found for URL: XXX）
                     search-paths: config                             # git仓库地址下的相对搜索地址（可用使用通配符），可以配置多个，用,分割。可以{application}实现按应用查配置
                     username:                                             # git仓库的账号（公开仓库无需账号信息）
                     password:                                             # git仓库的密码（公开仓库无需账号信息）
                     default-label: master                             #git默认分支

`2.svn方式：`
    

`3.本地方式：`
   
    参考本项目的application.yml配置
    


![直接访问配置中心](/Applications/mqz/feign-config-server/images/配置中心-配置中心客户端bootstrap配置.jpg)
    
### 配置成功

![直接访问配置中心](/Applications/mqz/feign-config-server/images/配置中心-直接访问配置中查看配置信息.jpg)
    

    


