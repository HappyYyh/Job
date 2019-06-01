# 系统安装部署说明书

## 1、后端部署

### 运行

运行之前必须保证有JDk1.8

idea打开项目以后直接点击运行即可

### 打包

利用idea打开后端源码，进行Maven打包（点击Package按钮即可）

### 发布

进入到打包完成后的目录下，找到Job.jar文件，

```shell
#以后台运行，并且不输出日志（项目自带日志）
nohup java -jar job.jar  >/dev/null 2>&1 &
```



## 2、前端部署

### 运行

前端项目运行之前必须安装相关配置，主要是node，Vue-cli，Element

#### 安装Node

直接去官网搜索，然后下载安装

```shell
#查看版本，是否安装成功
node -v 
npm -v 
```

#### 安装Vue-cli

```shell
npm install -g @vue/cli
#安装后检查
vue --version
#本项目用了3.0版本
```

#### 安装Element

```shell
npm i element-ui -S
#本项目用了2.7版本
```

#### 正式运行

```shell
#打开命令行，输入
npm run serve
```

之后就可以在浏览器输入localhost:8080访问

### 部署

#### 修改配置

```shell
#1、全局把localhost改成服务器ip（后端部署完成的情况下）主要是axios的后端请求，以及文件上传（企业编辑、用户编辑）
#2、把Vue.conf.js注释的内容打开
#3、打开命令行，输入
npm run build
```

打包完成以后会生成dist目录

双击打开dist里面的index.html能正常访问即说明打包成功

## 3、其他

如果你对本软件很感兴趣，想针对以后功能继续改进，可以加入Github一起开发，期待你的加入！

后端：https://github.com/HappyYyh/Job.git

前端：https://github.com/HappyYyh/Job.git

如果你想把本项目改成自己的项目进行利用完善，那么请注意修改如下配置：

在后端的yml文件中修改数据库配置

```yml
spring:
  #数据库配置
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    #这里改成自己的数据库连接
    url: jdbc:mysql://rm-bp1908u6a7tofk507ko.mysql.rds.aliyuncs.com:3306/db_job?useUnicode=true&allowMultiQueries=true&useSSL=false&characterEncoding=utf-8
    username: root
    password: aiYYH!1314
    tomcat:
      max-active: 10
      max-idle: 5
      min-idle: 5
```

redis配置：

```yml
redis:
#redis相关配置
    host: 120.79.252.252
    pool:
      max-active: 200
      max-wait: 5000
      max-idle: 150
      min-idle: 0

    timeout: 6000
```

RabbitMQ配置：

```yml
rabbitmq:
    host: 120.79.252.252
    port: 5672
    username: guest
    password: guest
    #消息发送到交换机确认机制,是否确认回调
    publisher-confirms: true
    #消息发送到队列确认机制，是否确认回调
    publisher-returns: true
    #手动确认消息
    listener:
      simple:
        acknowledge-mode: manual
  http:
    multipart:
      max-file-size: 10MB
      max-request-size: 100MB
#交换机
job:
  exchange:
    seeker: seeker
    recruiter: recruiter
```

七牛云配置：

```yml
#七牛云服务
qiniu:
  bucket: job_bucket
  secretKey: QuVitoseWoGsZedMV2KUIsLz_ruew8PvCvXqH4lU
  accessKey: YI609XuwI9gp-o6DZnVhEfGPSf-cGWHJIo8S-ASj
  urlPrefix: http://image.yangyhao.top/
```



