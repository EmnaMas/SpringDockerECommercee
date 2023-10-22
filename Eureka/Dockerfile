# Utilisez une image de base Java 8
FROM openjdk:8

EXPOSE 8761

# ajouter le jar de votre application dans le conteneur
ADD target/Eureka-0.0.1-SNAPSHOT.jar    Eureka-docker.jar

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "Eureka-docker.jar"]

