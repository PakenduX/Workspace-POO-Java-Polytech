package tp7;

public abstract class DecorateurInterieur implements Voiture {

    protected double prix_ajoute ;
    protected Voiture composant ;
    protected String nom ;

    public DecorateurInterieur(Voiture comp, String name, double prix) {
        composant = comp;
        nom = name;
        prix_ajoute = prix;
    }

    public double getPrix() {
        return prix_ajoute + composant.getPrix();
    }

    public String toString() {
        return composant.toString() + " " + nom ;
    }
}