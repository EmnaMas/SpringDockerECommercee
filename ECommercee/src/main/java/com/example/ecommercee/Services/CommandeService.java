package com.example.ecommercee.Services;

import com.example.ecommercee.Models.Client;
import com.example.ecommercee.Models.Commande;

import java.util.List;

public interface CommandeService {
    Commande passerCommande(Client client, List<Long> produitIds, List<Integer> quantiteCommandeeParProduit);
    // Ajoutez d'autres méthodes de service si nécessaire
}

