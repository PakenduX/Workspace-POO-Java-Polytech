package tp7;

import java.util.ArrayList;

/**
 * La classe Pile permettant d'adapter ArrayList en une pile
 * selon le design patter Adapteur
 * @author DEMBELE Mama
 */
public class Pile<E> extends ArrayList<E> implements Adaptateur{

	public void push(Object e) {
		this.add((E) e);
	}

	public Object peek() {
		return this.get(this.size()-1);
	}

	public Object pop() {
		Object res = this.get(this.size()-1);
		this.remove(this.size()-1);
		return res;
	}

}
