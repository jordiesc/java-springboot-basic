# java-springboot-basic
simple sping boot to show headers for testing 

# compile

mvnw package

# run it

with mavne 

./mvnw spring-boot:run

or with hava 

java -jar target/rest-service-0.0.1-SNAPSHOT.jar

# test it

```
curl -X POST http://localhost:8080/request/hola\?query\=value -H "ll:delavaca"  -d "asfasf"
{"headers":{"ll":"delavaca","content-length":"6","host":"localhost:8080","content-type":"application/x-www-form-urlencoded","user-agent":"curl/7.68.0","accept":"*/*"},"parameters":{"query":"value","asfasf":""},"url":"/request/hola","method":"POST","body":""}% 

 curl -H "name1: value1" -H "name2: value2" http://localhost:8080/headers
{"host":"localhost:8080","name2":"value2","name1":"value1","user-agent":"curl/7.68.0","accept":"*/*"}% 

```