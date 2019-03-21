package tp7;

/**
 * Implémentation du pattern Singleton
 * @author DEMBELE Mama
 */

public class Singleton {

    private static Singleton instance = null;
    private int number;

    /**
     * On définit le constructeur private pour
     * éviter toute création d'objets depuis
     * l'exterieur
     */
    private Singleton(int x){
        number = x;
    }

    /**
     * C'est cette seule fonction statique qui permet
     * de renvoyer la seule instance de l'objet de la classe.
     */
    public static Singleton getInstance(int x){
        if(instance == null)
            instance = new Singleton(x);

        return instance;
    }

    public int getNumber(){
        return number;
    }
}
