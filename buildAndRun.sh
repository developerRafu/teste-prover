#!/bin/sh
if [ $(docker ps -a -f name=tetse-prover | grep -w tetse-prover | wc -l) -eq 1 ]; then
  docker rm -f tetse-prover
fi
mvn clean package && docker build -t org.example/tetse-prover .
docker run -d -p 9080:9080 -p 9443:9443 --name tetse-prover org.example/tetse-prover
