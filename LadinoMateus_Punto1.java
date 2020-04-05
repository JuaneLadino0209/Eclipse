import acm.program.*;

public class LadinoMateus_Punto1 extends ConsoleProgram {
	private static final long serialVersionUID = 1L;
	
	public void run () {
		String nombre = readLine ("¿ Cual es tu nombre ?: ");
		println ("Bienvenid@ " + nombre + ", el programa recibira 10 numeros que ingrese en cualquier orden, retornara el numero mayor, el menor, y el promedio de los dos \n");
		double max = 0;
		double min = 0;
		int Z = 5;
		int F = 1;
		while (Z != 0) {
		double A = readDouble ("Ingrese un numero: ");
		double B = readDouble ("Ingrese un numero: ");
			while (F != 0) {
				if (A > B) {
					max = A;
					min = B;
				}
				else if (B > A) {
					max = B;
					min = A;
				}
				else if (A == B) {
					max = A;
					min = B;
				}
				F = F - F;
			}
		if (A > B && A > max && B < min) {
			max = A;
			min = B;
		}
		else if (A > B && A > max && B >= min) {
			max = A;
		}
		else if (A > B && A <= max && B < min) {
			min = B;
		}
		else if (A > B && A <= max && B >= min) {
		}
		else if (B > A && B > max && A < min) {
			max = B;
			min = A;
		}
		else if (B > A && B > max && A >= min) {
			max = B;
		}
		else if (B > A && B <= max && A < min) {
			min = A;
		}
		else if (B > A && B <= max && A >= min) {
		}
		Z --;
		}
		double promedio = (max + min)/2;
		println ("\nEl numero de mayor valor (max) ingresado es " + max);
		println ("El numero de menor valor (min) ingresado es " + min);
		println ("El promedio (max + min)/2 es " + promedio);
	}
}





