FROM tomcat:8.0-jre8-alpine

RUN rm -rf /usr/local/tomcat/webapps/ROOT/*

COPY ./config/server.xml /usr/local/tomcat/conf/server.xml
COPY ./target/forus.war /usr/local/tomcat/webapps/forus.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
