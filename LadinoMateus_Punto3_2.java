import acm.program.*;

public class LadinoMateus_Punto3_2 extends ConsoleProgram {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void isPrime (int K) {
		if (K == 2) {
			println (K + " es primo");
			return;
		}
		else if (K <= 1) {
			println (K + " no es primo");
			return;
		}
	for (int B = 2 ; K%B != 0 && B != K; B++) {
		println (K + " es primo");
		B = K;
		return;
	}
	for (int B = 2 ; K%B == 0 && B != K; B++) {
		println (K + " no es primo");
		B = K;
		}
	}
	public void run () {
		String nombre = readLine ("¿Cual es su nombre?: \n");
		println ("Bienvenid@ "+nombre+", el programa recibira un numero que usted ingresara ");
		println ("lo analizara y le dira si es primo, o de lo contrario no lo es \n");
		int K = readInt ("Ingrese el numero que quiere analizar: ");
		isPrime (K);
	}
}

