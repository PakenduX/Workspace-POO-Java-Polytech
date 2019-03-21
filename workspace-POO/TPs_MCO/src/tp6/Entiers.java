package tp6;

/**
 * Une classe permettant de gérer un ensemble de nombres entiers.
 * @author Mama
 * 
 */
public class Entiers implements MonIterable{
	
	private int elements[];
	private int taille;
	private int nbElements;
	
	/** 
	 * Le constructeur d'un ensemble ordonné d'entiers de taille taille
	 * @param taille la taille de l'ensemble.  
	 * 
	 */
	public Entiers(int taille) {
		this.taille = taille;
		elements = new int[taille];
		nbElements = 0;
	}
	
	/**
	 * La méthode permettant d'insérer un élément à sa place dans l'ensemble.
	 * Après avoir obtenu la place de l'élément on décale tous les 
	 * éléments à droite d'où l'intérêt d'avoir deux variables save et save
	 * pour permettre l'échange (swap).
	 * @param element l'élément à insérer dans l'ensemble
	 */
	public void inserer(int element) {
		int save = element, save2;
		
		if(this.appartient(element))
			System.out.println("Cet élément existe déjà dans l'ensemble");
		else {
			int i = 0;
			while(i < nbElements && element >= elements[i])
				i++;
			
			if(i == nbElements) 
				elements[nbElements] = element;
			else {
				
				while(i < nbElements+1 ) {
					save2 = elements[i];
					elements[i] = save;
					save = save2;
					i++;
				}
			}
			nbElements++;
		}
		
	}
	
	/**
	 * La méthode permettant de supprimer un élément de l'ensemble.
	 * Ici après avoir obtenu l'élément on décale juste les éléments à gauche 
	 * et on décrémente le nombre d'éléments.
	 * @param element l'élément à supprimer de l'ensemble
	 * @throws NotElementEntiers 
	 */
	public void supprimer(int element){
		
		if(!this.appartient(element)) {
			System.out.println(element + " n'appartient pas à l'ensemble");
		}else {
			int i = 0;
			while(element != elements[i])
				i++;
			
			while(i+1 < nbElements) {
				elements[i] = elements[i+1];
				i++;
			}
			
			nbElements--;
			
		}
	}
	
	/**
	 * Une fonction qui dit si un élément appartient à l'ensemble.
	 * @param element l'élément à tester.
	 * @return
	 */
	public boolean appartient(int element) {
		int i = 0;
		while(i < nbElements && elements[i] != element)
			i++;
		return i != nbElements;
		
	}
	
	/**
	 * La méthode permettant d'afficher un ensemble d'élements
	 */
	public void afficher() {
		for(int i = 0; i < nbElements ; i++)
			System.out.print(elements[i]+" ");
		System.out.println();
	}

	public void compacter(int nb_compactable){
		int val = (int)Math.random()*(taille);
		for(int i = 0; i < nb_compactable; i++) {
			supprimer(elements[val]);
			val = (int)Math.random()*(taille);
		}
		afficher();
		
	}
	
	public void dilater(int n)
	{
		int dernier = elements[nbElements-1];
		for(int i=0; i < n; i++)
			inserer(dernier+1);
	}
	
	//Méthode ajoutée au TP4 pour tester si le tableau d'entiers est
	//rempli
	public boolean rempli() {
		return nbElements == taille;
	}
	
	public int[] getElements() {
		return elements;
	}
	public int getNbElements() {
		return nbElements;
	}
	public int getTaille() {
		return taille;
	}

	class EntIterator implements BidirIterator, SupIterator{
		Entiers e;
		public EntIterator(Entiers en) {
			e = en;
		}
		public int courant() {
			
			return e.nbElements == 0 ? e.elements[e.nbElements] : e.elements[e.nbElements-1];
		}

		public int suivant() {
			return e.nbElements++;
		}

		public boolean fin() {
			return e.getTaille() == e.getNbElements();
		}

		public void supprimer() {
			e.nbElements--;
		}

		public int precedent() {
			return e.nbElements--;
			
		}
		
	}

	public MonIterator createIterator() {
		nbElements = 0;
		return new EntIterator(this);
	}
}
