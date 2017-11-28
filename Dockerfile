FROM tomcat:8.0-jre8-alpine

# 删除Tomcat默认根目录，可根据自己需求保留或删除
RUN rm -rf /usr/local/tomcat/webapps/ROOT/

# 替换Tomcat配置文件，可根据自己需求修改或删除
COPY ./config/server.xml /usr/local/tomcat/conf/server.xml

# 挂载应用目录，根据自己需求修改，需与Tomcat配置文件一致
VOLUME /usr/local/tomcat/webapps/forus/

# 暴露8080端口
EXPOSE 8080

# 运行Tomcat，并启用远程调试
CMD ["catalina.sh", "jpda", "run"]