package tp4;

/**
 * Introspection de classes
 * @author Mama DEMBELE
 */
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import tp1.Entiers;
import tp2.Point;

public class Introspection {

	public static void main(String[] args) {
		
		//4.1A
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisissez le nom de la classe:");
		String name = sc.nextLine();
		try {
			Class<?> c = Class.forName(name);
			Field[] f = c.getDeclaredFields();
			Method[] m = c.getDeclaredMethods();
			for(Field fi : f) {
				System.out.println(fi.getName() +" : "+ fi.getType());
			}
			
			for(Method me : m) {
				System.out.println(me.getName());
				for(Class<?> param : me.getParameterTypes() )
					System.out.println("\t" + param.getName());
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//4.1B Insérer et supprimer 
		Entiers e = new Entiers(100);
		sc = new Scanner(System.in);
		int val = 0;
		String nom_method = "";
		// L'utilisateur insère (ou supprime) des éléments tant que 
		// l'ensemble n'est pas rempli (ou vide) ou tant qu'il n'a pas
		// donné le caractère x.
		while(!nom_method.equals("x") && !e.rempli()) {
			System.out.println("Que voulez-vous faire:");
			nom_method = sc.next();
			if(!nom_method.equals("x")) {
				System.out.println("Saisissez l'entier à insérer ou à supprimer:");
				val = sc.nextInt();
				try {
					Method m = Entiers.class.getMethod(nom_method, int.class);
					m.invoke(e, val);
				} catch (NoSuchMethodException e1) {
					e1.printStackTrace();
				} catch (SecurityException e1) {
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					e1.printStackTrace();
				}
			}
				
		}
		e.afficher();
		
		//4.1C
		Point p = new Point(2, 3);
		System.out.println("Le point avant changement : " + p.toString());
		System.out.println("Donner le nom de l'attribut à remettre à 0 :");
		String nom_attr = sc.next();
		try {
			Field f = Point.class.getDeclaredField(nom_attr);
			f.setAccessible(true);
			f.setInt(p, 0);
		} catch (NoSuchFieldException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		System.out.println("Le point après changement : " + p.toString());
		
		//4.1.D
		System.out.println("Création d'un objet Entiers à l'exécution: ");
		try {
			Constructor<Entiers> ce = Entiers.class.getConstructor(int.class);
			Entiers ent = ce.newInstance(e.getTaille());
			for(int i = 0; i < e.getNbElements(); i++)
				ent.inserer(e.getElements()[i]);
			System.out.println("Entiers créés : ");
			ent.afficher();
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		}
		
		//4.2
		Object[] tab = new Object[1000];
		for(int i = 0; i < tab.length; i++) {
			Integer valeur = i+1;
			Class<?>[] interfaces = valeur.getClass().getInterfaces();
			GI handler = new GI(valeur);
			Object proxy = 	Proxy.newProxyInstance(null, interfaces, handler);
			tab[i] = proxy;
		}
		Integer cle = new Random().nextInt(tab.length + 1);
		int res = Arrays.binarySearch(tab, cle);
		System.out.println("Résultat = " + res); //Renvoi l'index de la valeur
		
		//4.3 Annotations
		System.out.println("Annotations des classes par année: ");
		File f = new File("/home/papa/workspace-POO/TPs-POO/src/tp2/");
		String[] ts = f.list();
		for(String t : ts) {
			//On utilise substring pour enlever le .java à la fin.
			try {
				Class<?> c = Class.forName("tp2."+t.substring(0, t.length()-5));
				Infos inf = c.getAnnotation(Infos.class);
				if(inf.annee() > 2009)
					System.out.println(inf.annee());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		
		//4.4 Types <<Jokers>>
		
		/*
		 * -Generique<Article> g1 = new Generique<Article> (a1, a2) ;
		 * g.fusionner(g2) avec g2 un Generique<Electromenager>
		 * 		cette instruction ne marchera pas car le fait que ElectroMenager
		 * 		hérite de Article ne veut pas dire que Generique<Electromenager>
		 * 		hérite de Generique<Article>.
		 * 		Pour corriger il faut utiliser un joker comme ceci:
		 * 			Generique <? extends Article> ga = new Generique<ElectroMenager>(e1, e2) ;
		 * 
		 * -Generique <Article> ga = new Generique<ElectroMenager>(e1, e2) ;
		 *  	non valide pour la même raison que précedemment.
		 *  	correction: 
		 *  		Generique <? extends Article> ga = new Generique<ElectroMenager>(e1, e2) ;
		 *  
		 *  -ga.setInfo1(e1); Impossible de corriger, car si l'on utilise des "? extends", 
		 *  le compilateur ne sait pas quel type d'objet on manipule donc Impossible de modifier.
		 *  
		 *  - En faisant Article ar = ga.getInfo1(); marchera car le compilateur sait 
		 *    qu'il n'y a que des sous-classes d'Articles.
		 *    
		 *  -Generique<? super ElectroMenager> ge = new Generique<ElectroMenager>(e1, e2) ;
		 *  -setInfo avec un objet ElectroMenager marche bien mais avec Article en paramètre non
		 *  car le compilateur ne connait pas le type exact du paramètre(? super ElectroMenager).
		 *  -on peut pas affecter un Article ou ElectroMenager à la
		 *  valeur de retour de getInfo1 car ce dernier ne renvoie que un Object.



		 */
		
	}

}