package tp3;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

import tp1.Entiers;
import tp1.Pile;
import tp2.Point;

public class TestTP3 {

	public static void main(String[] args) {
		try {
			Pile<Integer> p = new Pile<>(20, Integer.class);
			p.empiler(1);
			
			p.depiler();
			p.depiler();
			
			Entiers e = new Entiers(20);
			e.inserer(1);
			e.inserer(2);
			e.inserer(5);
			e.inserer(6);
			e.supprimer(7);
		
		} catch (PileVide pv) {} 
		catch (NotElementEntiers e1) {}
		
		ArrayDeque<String> ard = new ArrayDeque<>();
		ard.push("Java");
		ard.push("C++");
		ard.push("JavaScript");
		ard.push("Linux");
		
		ard.pop();
		ard.pop();
		ard.push("Python");
		
		Iterator<String> it = ard.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		
		
		//Création de la table associative
		TreeMap<String, Integer> mot_occ = new TreeMap<>();
		File f = new File("/home/papa/workspace-POO/TPs-POO/src/tp3/mot.txt");
		try {
			Scanner sc = new Scanner(f);
			String mot;
			while(sc.hasNext()) {
				mot = sc.next();
				if(mot_occ.containsKey(mot)) 
					mot_occ.replace(mot, mot_occ.get(mot) + 1);
				else
					mot_occ.put(mot, 1);
			}
		}catch(IOException ioE) {
			System.out.println("Erreur");
		}
		
		// la sous table dont le nombre d'occurence est compris entre 3 et 5
		System.out.println("la sous table dont le nombre  d'occurences est compris entre 3 et 5 :");
		//On crée un set pour pouvoir avoir un itérateur sur le TreeMap
		Set<Map.Entry<String, Integer>> set = mot_occ.entrySet();
		Iterator<Map.Entry<String, Integer>> iter = set.iterator();
		TreeMap<String, Integer> mot_occ_3_5 = new TreeMap<>();
		Entry<String, Integer> mot;
		while(iter.hasNext()) {
			mot = iter.next();
			if(mot.getValue() >= 3 && mot.getValue() <= 5)
				 mot_occ_3_5.put(mot.getKey(), mot.getValue());
		}
		
		System.out.println(mot_occ_3_5);
		System.out.println("La sous table des doublets dont le mot < milieu :");
		//La fonction headMap(x) renvoie une sous treeMap dont les éléments
		//inférieurs à x.
	    SortedMap<String, Integer> mot_occ_inf_milieu = mot_occ.headMap("milieu");
	    System.out.println(mot_occ_inf_milieu);
	    
	    //HashSet avec Point
	    HashSet<Point> hPoint = new HashSet<>();
	    hPoint.add(new Point(1, 3));
	    hPoint.add(new Point(2, 5));
	    hPoint.add(new Point(7, 3));
	    hPoint.add(new Point(7, 3));
	    //L'affichage se fait dans l'ordre des hashcodes croissants
		System.out.println(hPoint);
		
		//Test de monHashSet
		MonHashSet<Point> mhS = new MonHashSet<>();
		mhS.add(new Point(2,8));
		mhS.add(new Point(9,8));
		mhS.add(new Point(2,5));
		mhS.add(new Point(2,3));
		 
		System.out.println("Extraction d'un sous-ensemble de deux éléments:");
		System.out.println(mhS.EnsembleAleatoire(2));
		
		//Itérateurs
		ArrayList<Integer> list_p = new ArrayList<>();
		for(int i = 0;i < 100000; i++)
			list_p.add(i);
		
		LinkedList<Integer> linked_p = new LinkedList<>();
		int i=0;
		while(i < 100000){
			linked_p.add(i);
			i++;
		}
		 
		ListIterator<Integer> lit = linked_p.listIterator();
		while(lit.hasNext())
			System.out.println(lit.next());
		
		
	}

}
