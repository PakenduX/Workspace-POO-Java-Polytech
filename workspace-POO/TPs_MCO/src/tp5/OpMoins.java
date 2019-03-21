package tp5;

public class OpMoins extends OpAdd{

	public OpMoins(Terme gauche, Expression droite) {
		super(gauche, droite);
		
	}
	
	public double evaluer() {
		
		return gauche.evaluer() - droite.evaluer();
		
	}

}
