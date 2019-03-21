package tp7;


/**
 * Classe définissant un cercle.
 * @author Mama
 */

public class Cercle{

    private int rayon;
    private Point origine;

    public Cercle(Point origine, int rayon) {
        this.origine = origine;
        this.rayon = rayon;
    }

    public void dessiner() {
        System.out.println("Dessin d'un cercle de centre c = " + this.origine.toString() + " et de rayon r = " + this.rayon);
    }

}