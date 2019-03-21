package tp2;

import tp4.Infos;

/**
 * La classe définissant les transformations à appliquer
 * aux formes.
 * @author Mama
 */
@Infos(annee=2012)

public class PileTransformations {
	
	private Point[] transform;
	private int transCou;
	
	public PileTransformations(int taille) {
		transform = new Point[taille];
		transCou = 0;
		transform[0] = new Point(0, 0);
	}
	
	public Point getTransCou() {
		return transform[this.transCou];
	}
	
	public void empiler(Point p) {
		if(transCou == 0)
			transform[transCou] = p.additionner(getTransCou());
		else{
			transform[transCou+1] = p.additionner(this.getTransCou());
			transCou++;
		}
	}
	
	public void depiler() {
		transCou--;
	}
}
