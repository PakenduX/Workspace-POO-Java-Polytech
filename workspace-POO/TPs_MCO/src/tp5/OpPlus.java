package tp5;

public class OpPlus extends OpAdd{

	public OpPlus(Terme gauche, Expression droite) {
		super(gauche, droite);
	}
	
	public double evaluer() {

		return gauche.evaluer() + droite.evaluer();
		
	}

}
