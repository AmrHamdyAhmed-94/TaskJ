# define base docker image
FROM openjdk:11
LABEL maintaniner="javaguides.net"
ADD target/JpayExercise-0.0.1.jar JpayExercise.jar
ENTRYPOINT ["java","-jar","/JpayExercise.jar"]
