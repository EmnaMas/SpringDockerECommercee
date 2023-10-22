package com.example.ecommercee.Repositories;

import com.example.ecommercee.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    // Rechercher un client par son nom d'utilisateur
    Client findByUserName(String userName);

    // Rechercher un client par son adresse email
    Client findByEmail(String email);

    // Rechercher un client par son nom et prénom
    Client findByNomAndPrenom(String nom, String prenom);

    // Exemple de requête JPQL personnalisée
    @Query("SELECT c FROM Client c WHERE c.adresse LIKE %:adresse%")
    List<Client> findByAdresseContaining(String adresse);

    // Vous pouvez ajouter d'autres méthodes de requête personnalisées en fonction de vos besoins.
}
