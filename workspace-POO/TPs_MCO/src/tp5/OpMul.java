package tp5;

public abstract class OpMul extends Terme{
	
	protected Terme droite;
	protected Facteur gauche;
	
	public OpMul(Terme droite, Facteur gauche) {
		this.droite = droite;
		this.gauche = gauche;
	}
	
	
	public Terme getDroite() {
		return droite;
	}
	public Facteur getGauche() {
		return gauche;
	}
	
	public abstract double evaluer();
}
