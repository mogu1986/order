#!/usr/bin/env bash

export env=dev
export name=order
export version=3
export jar_path=order-service/target/order-service.jar
export host=order.top.com

mvn clean package -Dmaven.test.skip=true -U

docker build -t harbor.top.mw/library/$name:$version --no-cache --build-arg JAR_PATH=$jar_path --build-arg JAR_NAME=$name .

docker push harbor.top.mw/library/$name:$version

helm un $name -n $env

helm install $name -n $env --version 0.1 meiwu/meiwu \
--set nameOverride=$name \
--set image.repository=harbor.top.mw/library/$name \
--set image.tag=$version \
--set ingress.enabled=true \
--set ingress.hosts[0]=$host \
--set spring.profiles.active=$env \
--set apollo.configservice=http://apollo.mwmit.cn