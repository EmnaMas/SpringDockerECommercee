package com.example.ecommercee.Services;

import com.example.ecommercee.Models.Client;
import com.example.ecommercee.Models.Commande;
import com.example.ecommercee.Models.LigneCommandee;
import com.example.ecommercee.Models.Produit;
import com.example.ecommercee.Repositories.CommandeRepository;
import com.example.ecommercee.Repositories.LigneCommandeRepository;
import com.example.ecommercee.Repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {

    private final CommandeRepository commandeRepository;
    private final ProduitRepository produitRepository;
    private final LigneCommandeRepository ligneCommandeRepository;

    @Autowired
    public CommandeServiceImpl(
            CommandeRepository commandeRepository,
            ProduitRepository produitRepository,
            LigneCommandeRepository ligneCommandeRepository
    ) {
        this.commandeRepository = commandeRepository;
        this.produitRepository = produitRepository;
        this.ligneCommandeRepository = ligneCommandeRepository;
    }

    @Override
    public Commande passerCommande(Client client, List<Long> produitIds, List<Integer> quantiteCommandeeParProduit) {
        try {
            // 2. Rechercher les produits par leurs IDs
            List<Produit> produits = new ArrayList<>();
            produitRepository.findAllById(produitIds).forEach(produits::add);

            // 3. Créer une nouvelle commande
            Commande nouvelleCommande = new Commande();
            nouvelleCommande.setClient(client);
            nouvelleCommande.setRef("Référence de commande générée");
            nouvelleCommande.setDate(new Date());
            nouvelleCommande.setEtat("En cours");

            // 4. Enregistrer la nouvelle commande dans la base de données
            Commande commandeEnregistree = commandeRepository.save(nouvelleCommande);

            // 5. Créer des lignes de commande et les enregistrer
            List<LigneCommandee> lignesCommandee = new ArrayList<>();
            for (int i = 0; i < produits.size(); i++) {
                LigneCommandee ligneCommandee = new LigneCommandee();
                ligneCommandee.setClient(client);
                ligneCommandee.setCommande(commandeEnregistree);
                ligneCommandee.setProduit(produits.get(i));
                int quantiteCommande = quantiteCommandeeParProduit.get(i);
                ligneCommandee.setQteCommande(quantiteCommande);
                double prixUnitaire = produits.get(i).getPrix();
                double prixTotal = quantiteCommande * prixUnitaire;
                ligneCommandee.setPrixTotal(prixTotal);
                lignesCommandee.add(ligneCommandee);
            }

            // 6. Enregistrez les lignes de commande dans la base de données
            ligneCommandeRepository.saveAll(lignesCommandee);

            // 7. Vous pouvez ajouter d'autres logiques ici, telles que la mise à jour du stock de produits, etc.

            return commandeEnregistree;
        } catch (Exception e) {
            // Gérer d'autres exceptions non anticipées
            // Vous pouvez renvoyer une réponse d'erreur appropriée ici
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Une erreur s'est produite lors de la création de la commande", e);
        }
    }


}
