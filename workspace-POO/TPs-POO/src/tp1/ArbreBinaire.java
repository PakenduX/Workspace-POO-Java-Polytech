package tp1;

/**
 * Cette classe permet de représenter et de manipuler des ensembles ordonnés
 * d'entiers
 * La structure est composé d'un noeud racine et de deux sous-arbres fils gauche et droit
 * Les éléments sont ordonnés de telle sorte que ceux à gauche de la racine sont inférieurs 
 * à cette dernière et ceux à droite supérieurs.
 * 
 * @author Mama
 *
 */
public class ArbreBinaire {
	
	private Noeud racine;
	
	public ArbreBinaire() {
		this.racine = null;
	}
	
	public ArbreBinaire(Noeud racine) {
		this.racine = racine;
	}
	
	public void inserer(int element) {
		if(this.racine == null)
			this.racine = new Noeud(element, null, null);
		else if(this.racine.getValeur() < element) {
			
		}
			
	}
	
	public ArbreBinaire fg() {
		return new ArbreBinaire(racine.getFg());
	}
	
	public ArbreBinaire fd() {
		return new ArbreBinaire(racine.getFd());
	}
	
	public void afficher() {
		if(this.fg() != null)
			this.fg().afficher();
		System.out.print(this.racine.getValeur() + " ");
		if(this.fd() != null)
			this.fd().afficher();
	}
	
	public static void main(String[] args) {
		ArbreBinaire ab = new ArbreBinaire();
		ab.inserer(1);
		ab.inserer(2);
		ab.inserer(3);
		ab.inserer(5);
		
		//ab.afficher();
		System.out.println(ab.racine.getFg());
	}
}

class Noeud{
	private int valeur;
	private Noeud fd;
	private Noeud fg;
	
	public Noeud(int valeur, Noeud fd, Noeud fg) {
		this.valeur = valeur;
		this.fd = fd;
		this.fg = fg;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public Noeud getFd() {
		return fd;
	}

	public void setFd(Noeud fd) {
		this.fd = fd;
	}

	public Noeud getFg() {
		return fg;
	}

	public void setFg(Noeud fg) {
		this.fg = fg;
	}
	
}
