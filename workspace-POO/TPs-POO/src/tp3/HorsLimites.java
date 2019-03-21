package tp3;

/**
 * Classe définissant l'exception levée quand on est hors de
 * la limite du tableau
 * @author Mama
 *
 */
public class HorsLimites extends ExceptionForte{
	
	public HorsLimites(int index) {
		super();
		System.out.println(index + " est hors limites");
	}
	
}
