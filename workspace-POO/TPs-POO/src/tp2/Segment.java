package tp2;

import tp4.Infos;

/**
 * CLass permettant de définir un segment a, b
 * @author Mama
 */

@Infos(annee=2006)

public class Segment extends Forme implements Cloneable{
	
	private Point b;
	
	public Segment(Point origine, Point b) {
		super(origine);
		this.b = b;
	}
	
	public void dessiner(PileTransformations p) {
		System.out.println("Dessin d'un segment allant du point a = " + this.origine.additionner(p.getTransCou()) + " à b = " + this.b.additionner(p.getTransCou()));
	}

	/**
	 * Le code specifique est la méthode propre à chaque
	 * classe implementant Forme
	 */
	public void code_specifique(Point p) {
		b = this.b.additionner(p);
	}

	
	public void afficher() {
		
	}
	
	public Segment clone() throws CloneNotSupportedException{
		Segment s = (Segment)super.clone();
		s.origine = origine.clone();
		s.b = b.clone();
		return s;
		
	}

}
