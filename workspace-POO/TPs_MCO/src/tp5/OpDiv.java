package tp5;

public class OpDiv extends OpMul{

	public OpDiv(Terme droite, Facteur gauche) {
		super(droite, gauche);
	}

	public double evaluer() {
		return this.gauche.evaluer() / this.droite.evaluer();
	}

}
