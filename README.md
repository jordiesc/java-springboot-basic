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
 curl -H "name1: value1" -H "name2: value2" http://localhost:8080/headers
{"host":"localhost:8080","name2":"value2","name1":"value1","user-agent":"curl/7.68.0","accept":"*/*"}% 

```