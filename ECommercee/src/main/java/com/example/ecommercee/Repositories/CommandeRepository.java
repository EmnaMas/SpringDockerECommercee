package com.example.ecommercee.Repositories;

import com.example.ecommercee.Models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées si nécessaire
}
