package tp7;

import java.util.ArrayDeque;

public class Com2 implements Command{
	
	ArrayDeque<String> pile = new ArrayDeque<>();
	public void execute(String s) {
		pile.push(s);
	}

}
