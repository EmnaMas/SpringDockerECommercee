# Utilisez une image de base Java 8
FROM openjdk:8

EXPOSE 8082



# ajouter le jar de votre application dans le conteneur
ADD target/ECommercee-0.0.1-SNAPSHOT.jar   ecommerce-docker.jar
# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "ecommerce-docker.jar"]
