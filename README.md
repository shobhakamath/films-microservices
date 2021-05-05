**Steps to run the application:**

1. mvn clean install -P buildDocker

2. docker-compose up

go to localhost:8081 in browser
enter ur name and start putting comments.
open another browser and go to localhost:8080
enter another name and start putting comments.
Flip the browser and the comments are seen in both the screens


**Technologies used:**
Java 11
Springboot 2.4.2
Thymeleaf for UI
Spring Security
MongoDB for database
websocket api- stomp
docker-compose for containerization
GIT workflow included
mongoimport for mongo seeding
Swaggger UI for API contracts documentation



**MongoDB listing example**

**docker ps**

**docker exec -it aefaa17c4400 bash**
root@aefaa17c4400:/# mongo

**> show dbs**
admin   0.000GB
config  0.000GB
demo    0.000GB
local   0.000GB

> **use demo**
switched to db demo


> **show collections**
reservations
user

> **show tables**
reservations
user


> **show collections**
reservations
user

> **db.reservations.find()**
{ "_id" : ObjectId("608d0482356de63bbdc5b6e2"), "name" : "Bob", "date" : ISODate("2021-05-01T07:34:26.328Z"), "_class" : "com.films.model.Film" }
{ "_id" : ObjectId("608d0482356de63bbdc5b6e3"), "name" : "Peter", "date" : ISODate("2021-05-01T07:34:26.366Z"), "_class" : "com.films.model.Film" }
{ "_id" : ObjectId("608d0482356de63bbdc5b6e4"), "name" : "Gus", "date" : ISODate("2021-05-01T07:34:26.369Z"), "_class" : "com.films.model.Film" }
{ "_id" : ObjectId("608d0482356de63bbdc5b6e5"), "name" : "John", "date" : ISODate("2021-05-01T07:34:26.373Z"), "_class" : "com.films.model.Film" }
{ "_id" : ObjectId("608d0482356de63bbdc5b6e6"), "name" : "David", "date" : ISODate("2021-05-01T07:34:26.376Z"), "_class" : "com.films.model.Film" }

> **db.user.find()**
{ "_id" : "S442489", "password" : "$2a$10$CC7gPUzcjcol12Cp2IbeiOsbhy1MsBcOXOtYqNkDmVNhMt5RN/ye2", "name" : "superuser", "email" : "shobha.s.kamath@gmail.com", "_class" : "com.cinema.authentication.domain.model.User" }
{ "_id" : "shobha", "password" : "$2a$10$smOxifYsxjqDf5S9enyZ8OojlB.H4Lzd2v5bTqePN1/XSmASeFv7a", "name" : "shobha", "email" : "shobha.s.kamath@gmail.com", "_class" : "com.cinema.authentication.domain.model.User" }
{ "_id" : "shobha1", "password" : "$2a$10$wOaEpnjoSbR5U0NBLQNAVOeucL1vczo1hTMKgG29l6SgaOGW1jL0i", "name" : "shobha", "email" : "shobha.s.kamath@gmail.com", "_class" : "com.cinema.authentication.domain.model.User" }
{ "_id" : "S4424891", "password" : "$2a$10$LKT61LTQDFFQ9JO7QxqvSOSDhbM4HvUP2Wrh49ndZKju77sxOz54e", "name" : "superuser", "email" : "shobha.s.kamath@gmail.com", "roles" : [ ], "_class" : "com.cinema.authentication.domain.model.User" }
>


Docker snapshot:

![image](https://user-images.githubusercontent.com/7194495/117145394-2b80f900-adc4-11eb-9423-fd8787746ef0.png)


**Enhancements for future expected:**

Using Kafka topics setup

Using Redis foc caching the comments

