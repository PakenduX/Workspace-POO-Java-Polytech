package tp2;

import java.lang.reflect.Field;

import tp4.Infos;

/**
 * Une classe abstraite mère de toutes les formes
 * (Cercle, segment, etc.)
 * @author Mama
 */
@Infos(annee=2000)

public abstract class Forme implements Affichable{
	
	protected Point origine;
	
	public Forme() {
		origine = new Point();
	}
	public Forme(Point origine) {
		this.origine = origine;
	}
	
	public Point getOrigine() {
		return this.origine;
	}
	
	public void dessiner(PileTransformations p) {
		
	}
	
	/**
	 * Chaque classe fille implémente la méthode deplacer
	 * d'où le code spécifique car les classes filles 
	 * n'ont pas les mêmes attributs
	 * @param p
	 */
	public void deplacer(Point p) {
		origine = this.origine.additionner(p);
		code_specifique(p);
	}
	
	public abstract void code_specifique(Point p);

}
