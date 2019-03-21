package tp2;

import tp3.NotElementEntiers;
import tp3.NotElementListe;
import tp4.Infos;

/**
 * Classe permettant de définir la classe mère des structures
 * (Entiers, Pile, Liste)
 * @author Mama
 *
 */
@Infos(annee=2018)

public abstract class Structure implements Affichable, Compactable{

	public abstract void inserer(int element);
	
	public abstract void supprimer(int element) throws NotElementEntiers, NotElementListe;
}
