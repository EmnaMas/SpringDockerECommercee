package com.example.ecommercee.Controllers;

import com.example.ecommercee.Models.Client;
import com.example.ecommercee.Models.Commande;
import com.example.ecommercee.Services.ClientService;
import com.example.ecommercee.Services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    private final CommandeService commandeService;
    private final ClientService clientService;

    @Autowired
    public CommandeController(CommandeService commandeService, ClientService clientService) {
        this.commandeService = commandeService;
        this.clientService = clientService;
    }

    @PostMapping("/passer-commande")
    public Commande passerCommande(
            @RequestParam Long clientId,
            @RequestParam List<Long> produitIds,
            @RequestParam List<Integer> quantiteCommandeeParProduit
    ) {
        // Utilisez le service client pour rechercher le client par ID
        Client client = clientService.getClientById(clientId);

        return commandeService.passerCommande(client, produitIds, quantiteCommandeeParProduit);
    }



}
