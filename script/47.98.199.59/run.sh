#!/bin/bash
set -e

port=80
name=point
jar=point_service
Directory=point_service
ENV=service

source ./config.sh
#上传最新jar包
scp ../../ruoyi-admin/target/ruoyi-admin.jar root@"$HOST":/root/service/$Directory/$jar.jar
#停止项目
ssh root@$HOST docker stop $name || true
#删除项目
ssh root@$HOST docker rm $name || true
#docker把jar包构建为镜像
ssh root@$HOST docker build -t $name /root/service/$Directory/. || true
#运行容器
ssh root@$HOST docker run -d --restart=always --name $name -p $port:$port $name --spring.profiles.active=$ENV  || true

#打日志
ssh root@$HOST docker logs -f $name || true






