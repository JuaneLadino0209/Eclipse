import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LadinoMateus_MartinezCastiblanco_punto2 {
	public static ArrayList<Integer> Punto_2A (){
		ArrayList<Integer> listNumbers = new ArrayList<Integer> ();
		try {
			FileReader test = new FileReader("ArchivoPunto2.txt");
			
			for (double x = 0; x <= FileLength(); x++) {
					char number = (char) test.read();
					if (number == '0'||number == '1'||number == '2'||number == '3'||number == '4'||number == '5'||number == '6'||number == '7'||number == '8'||number == '9') {
						String y = Character.toString(number);
						int z = Integer.parseInt(y);
						listNumbers.add(z);
					}
					
			}
			test.close();
	
		}
		catch(IOException ex) {
			System.out.println("ERRROORR");
		}
		return listNumbers;
	}
	public static double Punto_2B (ArrayList<Integer> listNumbers) {
		double y = listNumbers.get(0);
		for (int x = 1; x <= listNumbers.size() - 1; x ++) {
			y = y + listNumbers.get(x);
		}
		double promedio = y / listNumbers.size();
		return promedio;
	}
	public static String Punto_2C (ArrayList<Integer> listNumbers) {
		int y = listNumbers.get(0);
		int q = listNumbers.get(0);

		for (int x = 1; x <= listNumbers.size()-1; x++) {
			if (listNumbers.get(x) > y) {
				y = listNumbers.get(x);
			}
		}
		for(int w = 1; w <= listNumbers.size() -1; w++) {
			if (listNumbers.get(w) < q) {
				q = listNumbers.get(w);
			}
		}
		return ("el valor maximo es: " + y + " , el valor minimo es: " + q);
	}
	public static ArrayList<Integer> Punto_2D (ArrayList<Integer> listNumbers) {
		ArrayList<Integer> impares = new ArrayList<Integer> ();
		for (int x = 0; x <= listNumbers.size()-1; x++) {
			if (listNumbers.get(x) %2 != 0) {
				impares.add(listNumbers.get(x));
			}
		}
		return impares;
	}
	public static void Punto_2E (ArrayList<Integer> listNumbers) {
		ArrayList<Integer> listNumbers1 = new ArrayList<Integer> ();
		ArrayList<Integer> listNumbers2 = new ArrayList<Integer> ();
		int a = listNumbers.size()/2;
		for (int x = 0; x <= a -1; x++) {
			listNumbers1.add(listNumbers.get(x));
		}
		for (int y = a; y <= listNumbers.size()-1; y++) {
			listNumbers2.add(listNumbers.get(y));
		}
		System.out.println(listNumbers1 + " " + listNumbers2);	
	}
	public static ArrayList<Integer> Interception (ArrayList<Integer> A, ArrayList<Integer> B) {
		A.retainAll(B);
		return A;
	}
	public static ArrayList<Integer> Union (ArrayList<Integer> A, ArrayList<Integer> B) {
		A.addAll(B);
		return A;
	}
	public static ArrayList<Integer> differ (ArrayList<Integer> A, ArrayList<Integer> B) {
		A.removeAll(B);
		return A;
	}
//---------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		
		ArrayList<Integer> listNumbers = Punto_2A ();
		System.out.println(listNumbers); //Punto_2A
		System.out.println(Punto_2B(listNumbers)); // Punto_2B
		System.out.println(Punto_2C(listNumbers)); // Punto_2C
		System.out.println(Punto_2D(listNumbers)); // Punto_2D
		Punto_2E(listNumbers); // Punto_2E
		//---------------------------------------------------------------------------
		ArrayList<Integer> test1 = new ArrayList<Integer> (Arrays.asList(2,3,4));
		ArrayList<Integer> test2 = new ArrayList<Integer> (Arrays.asList(4,5,6));
		ArrayList<Integer> test3 = new ArrayList<Integer> (Arrays.asList(2,3,4));
		ArrayList<Integer> test4 = new ArrayList<Integer> (Arrays.asList(4,5,6));
		ArrayList<Integer> test5 = new ArrayList<Integer> (Arrays.asList(2,3,4));
		ArrayList<Integer> test6 = new ArrayList<Integer> (Arrays.asList(4,5,6));
		//----------------------------------------------------------------------------
		//----------Punto_2F--------------------------//
		System.out.println(Interception(test1, test2)); // Punto_2F
		System.out.println(Union(test3, test4)); // Punto_2F
		System.out.println(differ(test5, test6)); // Punto_2F
	}
	private static long FileLength() {
		long fileLength = 100000;
		return fileLength;
	}
}