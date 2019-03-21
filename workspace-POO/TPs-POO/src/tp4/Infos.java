package tp4;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Interface annotation
 * @author Mama
 * @retention permet de définir sa durée de vie.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Infos {
	int annee();
}
