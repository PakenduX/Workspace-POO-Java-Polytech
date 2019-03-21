package tp5;

import java.util.HashMap;

public class Variable extends Facteur{
	
	private HashMap<Character, Double> kv;
	private char name;
	
	public Variable(HashMap<Character, Double> kv, char name) {
		this.kv = kv;
		this.name = name;
	}
	
	// On récupère la valeur de la variable par son nom.
	public double evaluer() {
		return kv.get(name);
		
	}
	
}
