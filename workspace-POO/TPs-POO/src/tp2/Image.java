package tp2;

import tp4.Infos;

/**
 * Classe définissant une image par un ensemble 
 * de formes et un point origine
 * @author Mama
 */

@Infos(annee=2014)

public class Image extends Forme implements Compactable, Comparable<Image>{
	
	private Forme tabForms[];
	private int nbForms;
	private final int TAILLE = 20;
	
	public Image() {
		super();
		this.origine = new Point();
		this.tabForms = new Forme[TAILLE];
		this.nbForms = 0;
		
	}
	
	public Image(Point p) {
		super(p);
		this.origine = p;
		tabForms = new Forme[TAILLE];
		nbForms = 0;
	}
	
	public int getNbForms() {
		return nbForms;
	}
	
	public void ajouter(Forme f) {
		tabForms[nbForms] = f;
		nbForms++;
	}
	
	public void dessiner(PileTransformations p) {
		System.out.println("Image d'origine "+origine.toString() + " composée de "+ nbForms);
	}

	public void code_specifique(Point p) {
			
	}

	
	public void afficher() {
		System.out.println("Image d'origine"+ origine.toString() + " et de "+nbForms+ " formes");
	}
	
	public void afficherLight() {
		System.out.println("Mon point origine est = " + origine .toString());
	}

	public void compacter(int nb_compactable) {
		int val = (int)Math.random()*(TAILLE);
		
		for(int i = 0; i < nb_compactable; i++) {
			while(val+1 < nbForms) {
				tabForms[val] = tabForms[val+1];
				val++;
			}
			
			nbForms--;
			
			val = (int)Math.random()*(TAILLE);
		}
		afficher();
	}
	
	/**
	 * Méthode permettant de comparer le nombre
	 * de formes de deux images.
	 */
	public int compareTo(Image img) {
		if(this.getNbForms() > img.getNbForms())
			return 1;
		else
			return -1;
	}
}
