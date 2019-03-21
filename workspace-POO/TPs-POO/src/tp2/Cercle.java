package tp2;

import tp4.Infos;

/**
 * Classe définissant un cercle.
 * @author Mama
 */
@Infos(annee=2011)

public class Cercle extends Forme{
	
	private int rayon;
	
	public Cercle(Point origine, int rayon) {
		super(origine);
		this.origine = origine;
		this.rayon = rayon;
	}
	
	public void dessiner(PileTransformations p) {
		System.out.println("Dessin d'un cercle de centre c = " + this.origine.additionner(p.getTransCou()) + " et de rayon r = " + this.rayon);
	}

	public void code_specifique(Point p) {

	}

	public void afficher() {
		System.out.println("C( "+ origine.toString()+", "+rayon+" )");
		
	}

	
}
