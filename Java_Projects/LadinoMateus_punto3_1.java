import acm.program.*;

public class LadinoMateus_punto3_1 extends ConsoleProgram {
	private static final long serialVersionUID = 1L;
	
	public void isPrime (int K) {
		int X = (K - 1);
		if (K <= 1) {
			println (K + " no es primo");
			return ;
		}
		while (X != 1) {
				while (K%X != 0) {
					X = X - 1;
				}
				if (X == 1) {
					println (K+" es primo ");
					}
				else if (X != 1) {
					println (K+" No es primo ");
					break;
					}
		}
	}
	public void run () {
		String nombre = readLine ("¿Cual es su nombre?: \n");
		println ("Bienvenid@ "+nombre+", el programa recibira un numero que usted ingresara ");
		println ("lo analizara y le dira si es primo, o de lo contrario no lo es \n");
		int A = readInt ("Ingrese el numero que quiere analizar: ");
		isPrime (A);
	}
}		
