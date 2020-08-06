FROM openjdk:8-jdk-alpine
ADD target/*.jar RecommendationService-0.0.1-SNAPSHOT.jar
EXPOSE 8096
ENTRYPOINT ["java", "-jar", "RecommendationService-0.0.1-SNAPSHOT.jar"]