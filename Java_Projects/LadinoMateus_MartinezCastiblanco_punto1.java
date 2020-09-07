import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LadinoMateus_MartinezCastiblanco_punto1 {

//-----------------------punto1 a--------------------------------------
		public static ArrayList<String> Punto_1A () throws IOException{
			Scanner file = new Scanner(new File("ArchivoPunto1.txt"));
			ArrayList<String> palabras= new ArrayList<String>();		
			while( file.hasNext()) {
			palabras.add(file.next());
			}
			file.close();
			return palabras;
		}
		public static ArrayList<String> Punto_1B (ArrayList<String> texto){
			ArrayList<String> plural= new ArrayList<String>();
			for(int x=0;x<texto.size()-1;x++) {
				if(isPlural(texto.get(x))== true) {
					plural.add(texto.get(x));
				}
			}
			return plural;
		}
		public static boolean isPlural(String palabra) {
			if(palabra.charAt(palabra.length()-1) == ',' || palabra.charAt(palabra.length()-1) == '.' || palabra.charAt(palabra.length()-1) == ')') {
				if(palabra.charAt(palabra.length()-2) == 's' || palabra.charAt(palabra.length()-2) == 'S')
				return true;
			}
			else if (palabra.charAt(palabra.length()-1) == 's' || palabra.charAt(palabra.length()-1) == 'S') {
				return true;
			}
				return false;
		}
		public static ArrayList<String> Punto_1C (ArrayList<String> texto){
			ArrayList<String>reverse = new ArrayList<String>();
			for(int x=texto.size()-1;x>=0;x--) {
				reverse.add(texto.get(x));
			}
			return reverse;
		}
		public static ArrayList<String> Punto_1D (ArrayList<String> texto){
			ArrayList<String> notPlural= new ArrayList<String>();
			for(int x=0;x<texto.size()-1;x++) {
				if(isPlural(texto.get(x))== false) {
					notPlural.add(texto.get(x));
				}
			}
			return notPlural;
		}
		public static ArrayList <String> Punto_1E (ArrayList <String> texto) {
			ArrayList<String> cap= new ArrayList<String>();
			for(int x=0;x<texto.size()-1;x++) {
				cap.add(texto.get(x));
				if(isPlural(texto.get(x))== true) {
					cap.set(x, texto.get(x).toUpperCase());
				}
			}
			return cap;
		}
		public static int letrasenpalabra (char vocal,String palabra) {
			int contador=0;
			for(int x=0;x<palabra.length()-1;x++) {
				if (palabra.charAt(x)== vocal)
					contador++;
			}
			return contador;
		}
		public static String Punto_1G (char vocal, ArrayList<String> texto) {
			int contador=0;
			for(int x=0;x<texto.size()-1;x++) {
				contador+=letrasenpalabra(vocal,texto.get(x));
			}
			return contador+" \""+vocal+"\"";
		}
		public static void main(String[] args) throws IOException {
			ArrayList<String> texto=Punto_1A();
			ArrayList<String> plural=Punto_1B(texto);
			ArrayList<String> reverse=Punto_1C(texto);
			ArrayList<String> textosinplural=Punto_1D(texto);
			ArrayList<String> PluralUppercase=Punto_1E(texto);
			System.out.println(texto);
			System.out.println(plural);
			System.out.println(reverse);
			System.out.println(textosinplural);
			System.out.println(PluralUppercase);
			System.out.println("hay "+Punto_1G('a',texto)+", "+Punto_1G('e',texto)+", "+Punto_1G('i',texto)+", "+Punto_1G('o',texto)+", "+Punto_1G('u',texto)+" en el texto");
			System.out.println("hay "+Punto_1G('A',texto)+", "+Punto_1G('E',texto)+", "+Punto_1G('I',texto)+", "+Punto_1G('O',texto)+", "+Punto_1G('U',texto)+" en el texto");
		}
}