package tp6;

/**
 * Une classe permettant de gérer une liste d'entiers
 * La liste est représentée par une cellule contenant
 * une valeur entière et une référence vers la cellule suivante.
 * @author Mama
 *
 */
public class Liste implements MonIterable, Cloneable{

	private Cellule tete;
	//Cette  tete sauvegardée est utilisée pour la fonction init().
	private Cellule tete_sauv;
	
	/**
	 * Le constructeur par defaut qui construit une liste vide.
	 */
	public Liste() {
		this.tete = null;
		tete_sauv = this.tete;
	}
	
	/**
	 * Le constructeur à un élément qui permet de construire une
	 * liste avec une tete.
	 * @param tete
	 */
	public Liste(Cellule tete) {
		this.tete = tete;
		this.tete_sauv = this.tete;
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
		this.tete_sauv = this.tete;
	}
	
	/**
	 * La méthode supprimant un élément de la liste
	 * @param element l'élémenet à supprimer
	 */
	public void supprimer(int element){
		if(!this.appartient(element))
			System.out.println(element + " n'appartient pas à l'ensemble");
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

	public void compacter(int nb_compactable) {
		Cellule t = tete;
		for(int i = 0; i < nb_compactable; i++) {
			supprimer(t.getValeur());
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
	
	class ListIterator implements InitIterator, InsIterator{

		Liste l;
		public ListIterator(Liste l) {
			this.l = l;
		}
		public int courant() {
			return l.tete.getValeur();
		}

		public int suivant() {
			l.tete = l.tete.getSuivante();
			return l.tete.getValeur();
		}

		public boolean fin() {
			return l.tete.getSuivante() == null;
		}

		public void insere(int i) {
			if(l.appartient(i))
				System.out.println("Cet élément appartient déjà à la liste.");
			else
				l.tete = new Cellule(i, l.tete);
			l.tete_sauv = l.tete;
		}

		public void init() {
			l.tete = l.tete_sauv;
		}
		
	}

	public MonIterator createIterator() {
		return (MonIterator)new ListIterator(this);
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
