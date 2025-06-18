package JOUR03;

import java.time.LocalDate;
import java.util.Vector;
import java.util.Scanner;

public class GestionCommerciale {

}

class Personne {
    protected int identite;
    protected String nomSocial;
    protected String adresse;

    protected Personne(int identite, String nomSocial, String adresse) {
        this.identite = identite;
        this.nomSocial = nomSocial;
        this.adresse = adresse;
    }

    protected int getIdentite() {
        return this.identite;
    }

    protected String getNomSocial() {
        return this.nomSocial;
    }

    protected String getAdresse() {
        return this.adresse;
    }

    protected void setIdentite(int nouvelleIdentite) {
        this.identite = nouvelleIdentite;
    }

    protected void setNomSocial(String nouveauNomSocial) {
        this.nomSocial = nouveauNomSocial;
    }

    protected void setAdresse(String nouvelleAdresse) {
        this.adresse = nouvelleAdresse;
    }

    protected String affiche() {
        return "Identite : " + this.identite + "\nNom social : " + this.nomSocial + "\nAdresse : " + this.adresse;
    }
}

class Client extends Personne {
    private double chiffreAffaire;

    public Client(int identite, String nomSocial, String adresse, double chiffreAffaire) {
        super(identite, nomSocial, adresse);
        this.chiffreAffaire = chiffreAffaire;
    }

    public double getChiffreAffaire() {
        return this.chiffreAffaire;
    }

    public void setChiffreAffaire(double nouveauChiffreAffaire) {
        this.chiffreAffaire = nouveauChiffreAffaire;
    }

    public String affiche() {
        return super.affiche() + "\nChiffre d'affaire : " + this.chiffreAffaire;
    }
}

class Article {
    private int reference;
    private String designation;
    private double prixUnitaire;
    private int quantiteStock;

    public Article(int reference, String designation, double prixUnitaire, int quantiteStock) {
        this.reference = reference;
        this.designation = designation;
        this.prixUnitaire = prixUnitaire;
        this.quantiteStock = quantiteStock;
    }

    public Article(Article autreArticle) {
        this.reference = autreArticle.reference;
        this.designation = autreArticle.designation;
        this.prixUnitaire = autreArticle.prixUnitaire;
        this.quantiteStock = autreArticle.quantiteStock;
    }

    public int getReference() {
        return this.reference;
    }

    public String getDesignation() {
        return this.designation;
    }

    public double getPrixUnitaire() {
        return this.prixUnitaire;
    }

    public int getQuantiteStock() {
        return this.quantiteStock;
    }

    public void setReference(int nouvelleReference) {
        this.reference = nouvelleReference;
    }

    public void setDesignation(String nouvelleDesignation) {
        this.designation = nouvelleDesignation;
    }

    public void setPrixUnitaire(double nouveauPrixUnitaire) {
        this.prixUnitaire = nouveauPrixUnitaire;
    }

    public void setQuantiteStock(int nouvelleQuantiteStock) {
        this.quantiteStock = nouvelleQuantiteStock;
    }

    public String affiche() {
        return "Reference : " + this.reference + "\nDesignation : " + this.designation + "\nPrix unitaire : " + this.prixUnitaire + "\nQuantite en stock : " + this.quantiteStock;
    }
}

class Commande {
    private int numeroCommande;
    private LocalDate dateCommande;
    private Client client;

    public Commande(int numeroCommande, LocalDate dateCommande, Client client) {
        this.numeroCommande = numeroCommande;
        this.dateCommande = dateCommande;
        this.client = client;
    }

    public int getNumeroCommande() {
        return this.numeroCommande;
    }

    public LocalDate getDateCommande() {
        return this.dateCommande;
    }

    public Client getClient() {
        return this.client;
    }

    public void setNumeroCommande(int nouveauNumeroCommande) {
        this.numeroCommande = nouveauNumeroCommande;
    }

    public void setDateCommande(LocalDate nouvelleDateCommnade) {
        this.dateCommande = nouvelleDateCommnade;
    }

    public void setClient(Client nouveauClient) {
        this.client = nouveauClient;
    }

    public String affiche() {
        return "Numero commande : " + this.numeroCommande + "\nDate commande : " + this.dateCommande + "\nClient : " + this.client.affiche();
    }
}

class LigneCommande {
    private Commande commande;
    private Article article;
    private int quantiteCommandee;

    public LigneCommande(Commande commande, Article article, int quantiteCommandee) {
        this.commande = commande;
        this.article = article;
        this.quantiteCommandee = quantiteCommandee;
    }

    public Commande getCommande() {
        return this.commande;
    }

    public Article getArticle() {
        return this.article;
    }

    public int getQuantiteCommandee() {
        return this.quantiteCommandee;
    }

    public void setCommande(Commande nouvelleCommande) {
        this.commande = nouvelleCommande;
    }

    public void setArticle(Article nouvelArticle) {
        this.article = nouvelArticle;
    }

    public void setQuantiteCommandee(int nouvelleQuantitecommandee) {
        this.quantiteCommandee = nouvelleQuantitecommandee;
    }

    public String affiche() {
        return "Commande : " + this.commande.affiche() + "\nArticle : " + this.article.affiche() + "\nQuantite commandee : " + this.quantiteCommandee;
    }
}

class Commerciale {
    private Vector<Article> articles;
    private Vector<Client> clients;
    private Vector<Commande> commandes;
    private Vector<LigneCommande> ligneCommandes;

    public Commerciale() {}

    public void ajouteLigneCommande(LigneCommande lc) {
        ligneCommandes.add(lc);
    }

    public void supprimeLigneCommande(LigneCommande lc) {
        ligneCommandes.remove(lc);
    }

    public void ajouterClient() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez l'identite du client : ");
        int identite = sc.nextInt();

        System.out.println("Entrez le nom social du client : ");
        String nomSocial = sc.next();

        System.out.println("Entrez l'adresse du client : ");
        String adresse = sc.next();

        System.out.println("Entrez le chiffre d'affaire du client : ");
        double chiffreAffaire = sc.nextDouble();

        Client c = new Client(identite, nomSocial, adresse, chiffreAffaire);

        clients.add(c);
    }

    public void supprimerClient() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez  l'identité du client à supprimer : ");
        int identite = sc.nextInt();

        for (Client c : clients) {
            if (c.getIdentite() == identite) {
                clients.remove(c);
                System.out.println("Le client à été supprimer avec succés !");
                return;
            }
        }
        System.out.println("Le client identité " + identite + " n'existe pas !");
    }

    public void passerCommande() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez l'identite du client : ");
        int identite = sc.nextInt();
        for (Client c : clients) {
            if (c.getIdentite() == identite){
                // ECRIRE LE RESTE
            }
        }

    }

    public void annulerCommande(Commande c) {
        for (LigneCommande lc : ligneCommandes) {
            if (lc.getCommande() == c) {
                ligneCommandes.remove(lc);
                break;
            }
        }
        commandes.remove(c);
    }

    public void ajouterArticle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez la reference de l'article : ");
        int reference = sc.nextInt();

        System.out.println("Entrez le designation de l'article : ");
        String designation = sc.next();

        System.out.println("Entrez le prix unitaire de l'article : ");
        double prixUnitaire = sc.nextDouble();

        System.out.println("Entrez la quantite en stock de l'article : ");
        int quantiteStock = sc.nextInt();
        Article a = new Article(reference, designation, prixUnitaire, quantiteStock);
        articles.add(a);
    }

    public void supprimerArticle() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez  la référence de l'article à supprimer : ");
        int reference = sc.nextInt();

        for (Article a : articles) {
            if (a.getReference() == reference) {
                articles.remove(a);
                System.out.println("L'article à été supprimer avec succés !");
                return;
            }
        }
        System.out.println("L'article référence " + reference + " n'existe pas !");
    }

    public static void main(String[] args) {
        Commerciale commerciale = new Commerciale();
        Scanner sc = new Scanner(System.in);

        System.out.println("--------Gestion Commerciale----------");
        System.out.println("1. Ajouter un article");
        System.out.println("2. Supprimer un article");
        System.out.println("3. Ajouter un client");
        System.out.println("4. Supprimer un client");
        System.out.println("5. Passer une commande");
        System.out.println("6. Passer une commande");
        System.out.println("0. Quitter");
        System.out.println();
        System.out.println("Entrez un choix : ");

        String choix = sc.nextLine();

        switch (choix) {
            case "1" -> commerciale.ajouterArticle();
            case "2" -> commerciale.supprimerArticle();
            case "3" -> commerciale.ajouterClient();
            case "4" -> commerciale.supprimerClient();
            case "5" -> commerciale.passerCommande();
        }
    }
}
