package tp5;

import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) {
		
		Chiffre _2 = new Chiffre(2);
		Chiffre _3 = new Chiffre(3);
		Chiffre _4 = new Chiffre(4);
		Chiffre _5 = new Chiffre(5);
		Chiffre _7 = new Chiffre(7);
		
		HashMap<Character, Double> hxyz = new HashMap<>();
		hxyz.put('x', 1.);
		hxyz.put('y', 2.);
		hxyz.put('z', 3.);
		
		Variable x = new Variable(hxyz, 'x');
		Variable y = new Variable(hxyz, 'y');
		Variable z = new Variable(hxyz, 'z');
		
		//2*x
		OpMul opmul = new OpFois(_2, x);
		
		//3 + 2*x
		OpAdd opadd = new OpPlus(_3, opmul);
		
		//(3 + 2*x)
		ExprPar exp = new ExprPar(opadd);
		
		//7/y
		OpMul div = new OpDiv(_7, y);
		
		//7/y - 2
		OpAdd moins = new OpMoins(div, _2);
		
		//(7/y - 2)
		ExprPar expr = new ExprPar(moins);
		
		//3*z
		OpMul fois = new OpFois(_3, z);
		
		//3*z + 4
		OpAdd plus = new OpPlus(fois, _4);
		
		//(3*z + 4)
		ExprPar exprPar = new ExprPar(plus);
		
		//5/(3*z + 4)
		OpMul division = new OpDiv(_5, exprPar);
		
		//(3 + 2*y) * (7/y - 2)
		OpMul fois_gauche = new OpFois(exp, expr);
		
		OpAdd res_final = new OpMoins(fois_gauche, division);
		
		System.out.println("Résultat final = " + res_final.evaluer());
		
		
		
		
	}

}
