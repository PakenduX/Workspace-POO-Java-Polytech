package tp7;

public class Main {

	public static void main(String[] args) {
		
		Com1 c1 = new Com1();
		Com2 c2 = new Com2();
		Liste l = new Liste();
		l.setCommand(c1, c2);
		l.inserer(1);
		l.inserer(2);
		l.inserer(3);
		l.inserer(5);
		l.inserer(7);
		l.inserer(10);
		
	
		l.afficher();
		
		System.out.println(c2.pile);
		
		System.out.println("----------------------Pattern Adaptateur---------------------");
		
		Pile<Integer> p = new Pile<>();
		
		p.push(1);
		p.push(2);
		p.push(3);
		p.push(4);
		
		System.out.println(p);
		
		System.out.println("La tête de pile = " + p.peek());
		
		System.out.println("Dépilement de la tête de liste : " + p.pop());
		
		System.out.println(p);

		System.out.println("------------------------Pattern Singleton--------------------");

		Singleton s ;
		s = Singleton.getInstance(1);
		System.out.println(s.getNumber());

		Singleton sp ;
		sp = Singleton.getInstance(2);
		// On se rend compte qu'il renvoie le même chiffre 1 car
		// on a qu'une seule instance de l'objet associé à la classe.
		System.out.println(sp.getNumber());

		System.out.println("------------------------Pattern Observer--------------------");


		Point point = new Point (0, 0);
		Point point_c = null;
		try {
			point_c = point.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		PointObserver obs = new PointObserver(point_c);

		point.addObserver(obs);

		Cercle c = new Cercle(point_c, 3);
		c.dessiner();

		point_c.modifier(2, 3);
		// On se rend compte que le point original est modifié car
		// abonné comme observable donc tout changement lui affectera aussi.
		System.out.println("Le point observé a été modifié : "+ point);
		c.dessiner();

		System.out.println("------------------------Pattern Décorateur--------------------");

		Voiture lamb = new Lamborghini() ;
		Voiture lamb_cuir = new InterieurCuir(lamb);
		System.out.println("La lambo vaut "+ lamb.getPrix());
		System.out.println(" La lambo avec interieur cuir vaut " + " " + lamb_cuir.getPrix());

		Voiture lamb_cuir_gps = new GPS(lamb_cuir);
		System.out.println(" La lambo avec interieur cuir et équipée d'un GPS" + "  " + lamb_cuir_gps.getPrix());


	}

}
