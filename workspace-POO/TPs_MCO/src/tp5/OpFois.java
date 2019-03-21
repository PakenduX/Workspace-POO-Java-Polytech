package tp5;

public class OpFois extends OpMul{

	public OpFois(Terme droite, Facteur gauche) {
		super(droite, gauche);
	}

	public double evaluer() {
		return this.gauche.evaluer() * this.droite.evaluer();
	}

}
