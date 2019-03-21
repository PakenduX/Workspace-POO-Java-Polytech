package tp2;

import tp4.Infos;

/**
 * Interface qui permet de définir l'ensemble
 * des classes affichables.
 * @author Mama
 *
 */
@Infos(annee=2010)
public interface Affichable {
	
	public void afficher();
	
	public default void afficherLight() {
		System.out.println("Je ne sais pas afficherLight");
	}

}
