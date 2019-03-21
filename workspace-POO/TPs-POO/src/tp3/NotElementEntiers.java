package tp3;

/**
 * Classe définissant l'exception levée lorsque l'élément
 * n'appartient pas aux entiers.
 * @author Mama
 *
 */
public class NotElementEntiers extends ExceptionFaible{
	
	public NotElementEntiers(int element) {
		super();
		System.out.println(element + " n'a pas été trouvé");
	}
}
