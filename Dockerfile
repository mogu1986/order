FROM harbor.top.mw/library/java-centos-openjdk8-jdk:1.8.0
MAINTAINER gaowei@fengjing.com

USER root

ARG JAR_PATH
ARG JAR_NAME=app
ENV JAR_NAME=$JAR_NAME
ADD $JAR_PATH /$JAR_NAME.jar

# set environment
ENV TZ="Asia/Shanghai" \
    TIME_ZONE="Asia/Shanghai" \
    ACTIVE_PROCESSOR_COUNT="1" \
    INITIAL_RAM_PERCENTAGE="40.0" \
    MIN_RAM_PERCENTAGE="40.0" \
    MAX_RAM_PERCENTAGE="90.0" \
    JVM_XMS="2g" \
    JVM_XMX="2g" \
    JVM_XMN="1g" \
    JVM_MS="128m" \
    JVM_MMS="320m" \
    DEBUG="n" \
    LD_PRELOAD="/usr/local/lib/faketime/libfaketime.so.1" \
    FAKETIME="-30d"

WORKDIR /

RUN mkdir -p logs

EXPOSE 80 9999
ENTRYPOINT ["/bin/sh", "-c", "java $JAVA_OPTS -jar /$JAR_NAME.jar  $0 $@"]