package tp1;

import java.lang.reflect.Array;

import tp3.PileVide;

/**
 * Une classe permettant de gérer une pile de nombres entiers.
 * @author Mama
 * 
 */
public class Pile<E> {
	
	public E elements[];
	private int taille;
	private int nbElements;
	
	/** 
	 * Le constructeur d'une pile d'entiers vide de taille taille
	 * @param taille la taille de la pile.  
	 * 
	 */
	public Pile(int taille, Class<?> c) {
		this.taille = taille;
		elements = (E[])Array.newInstance(c,taille);
		nbElements = 0;
	}
	
	/**
	 * La méthode permettant d'ajouter un élément au sommet de la pile
	 * @param element l'élément à ajouter au sommet de la pile.
	 */
	public void empiler(E element) {
		if(this.pleine())
			System.out.println("La pile est déjà pleine");
		else {
			elements[nbElements] = element;
			nbElements++;
		}
		
	}
	
	/**
	 * La méthode permettant de retirer le sommet de la pile
	 * @throws PileVide 
	 */
	public void depiler() throws PileVide {
		if(this.vide())
			throw new PileVide();
		else 
			nbElements--;
	}
	
	/**
	 * La méthode qui permet de savoir si la pile est pleine ou non.
	 * @return true ou false.
	 */
	public boolean pleine() {
		
		return nbElements == taille;
		
	}
	
	/**
	 * La méthode qui permet de savoir si la pile est vide ou non.
	 * @return true ou false si la pile est vide ou non.
	 */
	public boolean vide() {
		
		return nbElements == 0;
	}
	
	/**
	 * La méthode permettant d'afficher une pile d'élements
	 */
	public void afficher() {
		for(int i = nbElements-1; i >= 0 ; i--)
			System.out.print(elements[i]+" ");
		System.out.println();
	}
	
	
	public static void main(String[] args) throws PileVide {
		Pile<Integer> p = new Pile<>(20, Integer.class);
		p.empiler(1);
		p.empiler(2);
		p.empiler(3);
		p.empiler(4);
		p.empiler(5);
		p.empiler(6);
		p.empiler(7);
		p.empiler(8);
		p.empiler(9);
		p.empiler(10);
		
		p.afficher();
		System.out.println("La pile est-elle pleine ? :"+ p.pleine());
		System.out.println("La pile est-elle vide ? :"+ p.vide());
		System.out.println("Empilement de 78 : ");
		p.empiler(78);
		p.afficher();
		p.depiler();
		System.out.println("Affichage après avoir dépilé: ");
		p.afficher();
	}

}
