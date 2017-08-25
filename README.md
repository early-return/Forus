# Forus
一个轻量级的论坛程序

## 使用

1. 初始化数据库： 

按顺序执行 `src/sql` 目录下的SQL文件.

2. 添加自己的配置文件： 

以 `src/main/resources` 目录下的 `app-dev.properties` 文件为模板，添加 `app-prod.properties` 并修改其中的值。

3. 打包：

在命令行中输入 `mvn war:war`

4. 激活配置文件：

在Web容器中添加JVM参数： `-Dspring.profiles.active="prod"`

5. 运行：

在 `target/` 目录中找到 `forus.war` 文件并发布到Web容器中。

## 目录结构

```
|——src                          #源文件
   |——main                      #主目录
      |——java                   #java源文件
         |——info/zhiqing/forus  #包名
            |——api              #API控制器
            |——config           #配置文件
            |——controllers      #控制器
            |——exceptions       #异常类
            |——intercepters     #拦截器
            |——mappers          #数据库映射
            |——models           #模型
            |——services         #服务
            |——utils            #工具类
         |——resources           #资源目录
            |——mybatis          #myBatis相关配置
            |——spring           #spring相关配置
            |——app.properties   #应用配置文件（分为dev、test、prod四类）
         |——webapp              #Web应用相关
            |——img              #图片
               |——avatar        #默认头像
            |——WEB-INF          #Web应用配置相关
   |——sql                       #用于初始化数据库的SQL文件
   |——test                      #测试用例（子目录结构与main类似）
```

