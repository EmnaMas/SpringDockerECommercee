package com.example.ecommercee.Models;



import javax.persistence.*;
import java.util.List;


@Entity
public class LigneCommandee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int qteCommande;
    private double prixTotal;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;


    @ManyToOne
    @JoinColumn(name = "produit_id") // Colonne de jointure vers la table Produit
    private Produit produit;



    public void setProduit(Produit produit) {
        this.produit = produit;
    }


    // Constructeurs

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQteCommande() {
        return qteCommande;
    }

    public void setQteCommande(int qteCommande) {
        this.qteCommande = qteCommande;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}
