package tp1;

import tp2.Structure;
import tp3.NotElementListe;

/**
 * Une classe permettant de gérer une liste d'entiers
 * La liste est représentée par une cellule contenant
 * une valeur entière et une référence vers la cellule suivante.
 * @author Mama
 *
 */
public class Liste extends Structure implements Cloneable{

	private Cellule tete;
	
	/**
	 * Le constructeur par defaut qui construit une liste vide.
	 */
	public Liste() {
		this.tete = null;
	}
	
	/**
	 * Le constructeur à un élément qui permet de construire une
	 * liste avec une tete.
	 * @param tete
	 */
	public Liste(Cellule tete) {
		this.tete = tete;
	}
	
	/**
	 * La méthode insérant un élément à la tête de la liste
	 * @param element l'élément à insérer
	 */
	public void inserer(int element) {
		if(this.appartient(element))
			System.out.println("Cet élément appartient déjà à la liste.");
		else
			this.tete = new Cellule(element, this.tete);
	}
	
	/**
	 * La méthode supprimant un élément de la liste
	 * @param element l'élémenet à supprimer
	 */
	public void supprimer(int element) throws NotElementListe{
		if(!this.appartient(element))
			throw new NotElementListe();
		else {
			if(tete.getValeur() == element)
				tete = tete.getSuivante();
			else {
				Cellule teteTmp = tete;
				while(teteTmp.getSuivante().getValeur() != element) {
					teteTmp = teteTmp.getSuivante();
				}
				
				teteTmp.setSuivante(teteTmp.getSuivante().getSuivante());
			
			}
		}
	}
	
	/**
	 * La méhode permettant d'afficher une liste.
	 */
	public void afficher() {
		Cellule c = this.tete;
		while(c != null) {
			System.out.print(c.getValeur() + " ");
			c = c.getSuivante();
		}
		System.out.println();
	}
	
	/**
	 * La fonction qui vérifie si un élément appartient à une liste.
	 * @param element l'élément à tester.
	 * @return true ou false.
	 */
	public boolean appartient(int element) {
		Cellule c = this.tete;
	
		while(c != null && c.getValeur() != element)
			c = c.getSuivante();
		
		return c != null;
		
	}
	
	public static void main(String[] args) throws NotElementListe {
		Liste l = new Liste();
		l.inserer(1);
		l.inserer(2);
		l.inserer(3);
		l.inserer(5);
		l.inserer(7);
		l.inserer(10);
		
		System.out.println("Affichage de la liste");
		
		l.afficher();
		
		System.out.println("Suppression de 5 et 7");
		
		
		l.supprimer(5);
		l.supprimer(7);
		
		l.afficher();
	}

	public void compacter(int nb_compactable) {
		Cellule t = tete;
		for(int i = 0; i < nb_compactable; i++) {
			try {
				supprimer(t.getValeur());
			} catch (NotElementListe e) {
				e.getMessage();
			}
			t = t.getSuivante();
		}
		afficher();
		
	}
	
	/*
	 * La méthode qui permet de cloner une liste 
	 * ici on clone aussi la cellule tête car c'est un objet
	 * à part
	 */
	public Liste clone() throws CloneNotSupportedException{
		Liste l = (Liste)super.clone();
		l.tete = tete.clone();
		return l;
		
	}
}

/**
 * La classe qui représente une case de la liste qui contient 
 * la valeur et la référence vers la suivante.
 * @author Mama
 *
 */
class Cellule implements Cloneable{
	
	private int valeur;
	private Cellule suivante;
	
	public Cellule(int valeur, Cellule suivante) {
		this.valeur = valeur;
		this.suivante = suivante;
	}
	
	public int getValeur() {
		return valeur;
	}
	
	public Cellule getSuivante() {
		return suivante;
	}
	public void setSuivante(Cellule suiv) {
		this.suivante = suiv;
	}
	
	public Cellule clone() throws CloneNotSupportedException{
		return (Cellule)super.clone(); 
		
	}
}
