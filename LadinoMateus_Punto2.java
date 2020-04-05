import acm.program.*;

public class LadinoMateus_Punto2 extends ConsoleProgram {
	private static final long serialVersionUID = 1L;
	
	public void findDigit (String test,String x) {
		int A = test.indexOf(x);		
		if (A != -1) {
			int Z = 0;
			while (A != -1) {
				int B = test.indexOf(x,A);
				if (B != -1) {
				Z = Z + 1;
				B ++;
				A = B;
				}
				else {
					break;
				}
			}
			println ("\n" + x + " esta "+ Z + " veces en " + test);
		}
		else if (A == -1) {
			println ("\n" + x + " esta 0 veces en " + test);
		}
	}
	public void run () {
		String nombre = readLine ("¿ Cual es tu nombre ?: ");
		println ("Bienvenido " + nombre + ", el programa recibira un test igresado del teclado, luego recibira un digito ingresado, el programa analizara si el digito ingresado esta contenido en el test y retornara si el digito esta y cuantas veces se repite");
		String test = readLine ("\nIngrese el test: ");
		String digit = readLine ("\nIngrese el digito: ");
		findDigit (test , digit);

	}
}
