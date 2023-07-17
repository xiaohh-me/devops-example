# 使用openjdk11做基础镜像
FROM openjdk:11-jre

# 作者
MAINTAINER XiaoHH

# 将可执行的jar包放到容器当中去
ADD java/devops-example.jar app.jar

# 暴露8080端口
EXPOSE 8080

# JVM 调优参数
ENV JAVA_OPTION="-Dfile.encoding=UTF-8 -XX:+UseParallelGC -XX:+PrintGCDetails -Xloggc:/var/log/devops-example.gc.log -XX:+HeapDumpOnOutOfMemoryError -XX:+DisableExplicitGC"

# JVM 内存默认值
ENV XMX=128m
ENV MXS=128m
ENV XMN=64m

# 运行程序
ENTRYPOINT ["sh", "-c",  "java -Djava.security.egd=file:/dev/./urandom -jar -Xmx${XMX} -Xms${MXS} -Xmn${XMN} $JAVA_OPTION -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} /app.jar"]
