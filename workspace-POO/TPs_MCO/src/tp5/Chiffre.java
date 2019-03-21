package tp5;

/**
 * Classe définissant un chiffre
 * @author Mama
 *
 */
public class Chiffre extends Facteur{
	
	private double valeur;
	
	public Chiffre(double valeur) {
		this.valeur = valeur;
	}
	
	public double evaluer() {
		return valeur;
		
	}

}
