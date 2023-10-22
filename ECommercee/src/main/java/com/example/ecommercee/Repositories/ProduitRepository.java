

package com.example.ecommercee.Repositories;

import com.example.ecommercee.Models.Produit;
import org.springframework.data.repository.CrudRepository;

public interface ProduitRepository extends CrudRepository<Produit, Long> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées si nécessaire
}

