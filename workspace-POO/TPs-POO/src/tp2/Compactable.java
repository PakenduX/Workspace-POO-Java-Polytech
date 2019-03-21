package tp2;

import tp4.Infos;

/**
 * L'interface définissant l'ensemble des 
 * éléments compactables.
 * @author Mama
 */
@Infos(annee=2010)

public interface Compactable {
	
	public void compacter(int nb_compactable);
	
	public default void dilater() {
		System.out.println("Je ne sais pas dilater");
	}
}
