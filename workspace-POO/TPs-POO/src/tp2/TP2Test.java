package tp2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import tp1.Entiers;
import tp1.Liste;
import tp4.Infos;

@Infos(annee=2018)

public class TP2Test {

	public static void main(String[] args) throws CloneNotSupportedException {

		System.out.println("Création de deux points a et b");
		Point a = new Point(1, 2);
		Point b = new Point(3, 5);

		Point a2 = new Point(5, 10);
		Point b2 = new Point(-3, -5);

		Segment s = new Segment(a, b);

		Segment s2 = new Segment(a2, b2);

		PileTransformations p = new PileTransformations(3);
		Cercle c = new Cercle(a, 4);
		p.empiler(a);

		c.dessiner(p);
		s.dessiner(p);
		System.out.println("Déplacement du cercle et du segment de b(3, 5)");
		c.deplacer(b);
		s.deplacer(b);
		c.dessiner(p);
		s.dessiner(p);

		Image img = new Image();

		img.ajouter(c);
		img.ajouter(s);

		Image img2 = new Image();

		img2.ajouter(c);
		
		Image img3 = new Image();
		img3.ajouter(s2);
		img3.ajouter(c);
		img3.ajouter(s);

		img.dessiner(p);
		System.out.println("Déplacement de l'image de b(3, 5)");
		img.deplacer(b);
		img.dessiner(p);
		p.depiler();

		Affichable[] af = new Affichable[10];
		Structure e = new Entiers(20);
		e.inserer(1);
		e.inserer(2);
		e.inserer(5);
		e.inserer(6);
		e.inserer(8);
		e.inserer(4);
		e.inserer(3);
		e.inserer(3);

		Structure l = new Liste();
		l.inserer(1);
		l.inserer(2);
		l.inserer(3);
		l.inserer(5);
		l.inserer(7);
		l.inserer(10);

		af[0] = e;
		af[1] = l;
		af[2] = c;
		af[3] = s;
		af[4] = img;

		System.out.println("Affichage du tableau affichable :");
		for (int i = 0; i < 5; i++)
			af[i].afficher();

		Compactable[] cmpa = new Compactable[10];
		cmpa[0] = img;
		cmpa[1] = img2;
		cmpa[2] = e;
		cmpa[3] = l;
		System.out.println("Affichage du tableau Compactable :");
		cmpa[0].compacter(2);
		cmpa[1].compacter(1);
		cmpa[2].compacter(3);
		cmpa[3].compacter(3);
		
		LinkedList<Image> lk = new LinkedList<Image>();
		lk.add(img3);
		lk.add(img2);
		lk.add(img);
		
		Image[] tab_img = new Image[3];
		tab_img[0] = img;
		tab_img[1] = img2;
		tab_img[2] = img3;
		
		Arrays.sort(tab_img);
		System.out.println("Les nombres de formes triées :");
		System.out.println(tab_img[0].getNbForms());
		System.out.println(tab_img[1].getNbForms());
		System.out.println(tab_img[2].getNbForms());
		
		
		Image ord_max = Collections.max(lk, new Comparator<Image>() {
			public int compare(Image img1, Image img2) {
				if(img1.getOrigine().getY() > img2.getOrigine().getY())
					return 1;
				else
					return -1;
			}
		});
		
		System.out.println("L'ordonnée la plus élevé est : " + ord_max.getOrigine().getY());
		
		Liste l2 = ((Liste)l).clone();
		System.out.println("La liste clonée : ");
		l2.afficher();
		Segment sc = s.clone();
		

	}

}
