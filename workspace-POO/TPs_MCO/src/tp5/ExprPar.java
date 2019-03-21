package tp5;

public class ExprPar extends Facteur{
	
	private Expression expr;
	
	public ExprPar(Expression expr) {
		this.expr = expr;
	}
	
	public double evaluer() {
		return expr.evaluer();
	}
	
}
