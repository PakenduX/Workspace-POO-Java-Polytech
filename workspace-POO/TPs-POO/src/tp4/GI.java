package tp4;

/**
 * Gestionnaire d'invocation
 * @author Mama
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GI implements InvocationHandler{
	private Object o;
	public GI(Object i) {
		o = i;
	}
	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
		System.out.println(o + "." + m.getName() + "(" + args[0] + ")");
		return m.invoke(o, args);
	}

}
