@echo off
call mvn clean package
call docker build -t org.example/tetse-prover .
call docker rm -f tetse-prover
call docker run -d -p 9080:9080 -p 9443:9443 --name tetse-prover org.example/tetse-prover