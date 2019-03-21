package tp3;

import java.util.HashSet;
import java.util.Random;

/**
 * CLass définissant une fille de HashSet qui
 * permet de renvoyer un ensemble aléatoire d'un HashSet
 * @author Mama
 *
 * @param <E>
 */
public class MonHashSet<E> extends HashSet<E> {

	public MonHashSet<E> EnsembleAleatoire(int n) {
		MonHashSet<E> mon_hashSet = new MonHashSet<E>();
		//Transformation de la collection en Tableau
		E[] t = (E[]) toArray();
		int i = 0;
	
		while (i < n) {
			Random r = new Random();
			int val = r.nextInt(size());
			if(!mon_hashSet.contains(t[val])) {
				mon_hashSet.add(t[val]);
				i++;
			}
		}
		return mon_hashSet;
	}


	public MonHashSet() {}
}

 
