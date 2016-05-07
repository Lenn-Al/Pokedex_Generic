package pokedex_generic_nb;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
* Hauptklasse
* Liest die csv-Datei ein
* Beinhaltet die Main-Methode 
* 
* @author Lennart Almstedt 4633202 Group 11d
* @author Maximilian von Unwerth 4568393 Group 11d
* @author Joshua Heinemann 4701655 Group 11d
*/
public class Pokedex {
	/**
	 * Die doppelt-verkettete Liste
	 */
	private static DoubleLinkedList dl = new DoubleLinkedList();

	/**
	 * Main-Methode
	 * Haupteinstiegspunkt des Programms,
	 * die csv-Datei wird eingelesen und
	 * die DoubleLinkedList wird gefuellt,
	 * sowie anschliessend ausgegeben.
	 * @param args Mainmethoden-Paramter
	 */
	public static void main(String[] args) {
		csvRead();
		System.out.println(dl.toString());
	}

	/**
	 * Liest die csv-Datei
	 */
	public static void csvRead() {
		try {
			BufferedReader br = Files.newBufferedReader(Paths.get("./Sources/Pokedex.csv"));
			int i;
			String line = null;
			while ((line = br.readLine()) != null) {
				if (line.charAt(0) == 'N') { //Erste Zeile der csv auslassen
					line = br.readLine(); //Nächste Zeile einlesen
					continue;
				}
				String[] values = new String[11]; //Feld fuer alle Werte
				for (int x = 0; x < values.length; x++) {
					values[x] = ""; //Alle Werte im Feld leeren
				}
				i = 0;
				for (int j = 0; j < 10; j++) { //Immer, wenn ein Komma kommt:
					while (line.charAt(i) != ',') { 
						values[j] += line.charAt(i); //Werte in values speichern
						i++;
					}
					i++;
				}
				for (int y = i; y < line.length(); y++) { 
					values[10] += line.charAt(y); //Speed auch noch hinzufuegen
				} //Muss so geloest werden, da For-Schleife nur bis zum letzten Komma geht
				dl.insert(new Pokemon(Integer.parseInt(values[0]), values[1], values[2], values[3],
						  Integer.parseInt(values[4]), Integer.parseInt(values[5]), Integer.parseInt(values[6]),
						  Integer.parseInt(values[7]), Integer.parseInt(values[8]), Integer.parseInt(values[9]),
						  Integer.parseInt(values[10]))); //Einfuegen des Pokemon mit den Werten aus der Line der CSV
				line = br.readLine(); //Naechste Zeile
			}
		} catch (IOException e) { //File-Not-Found-Exception
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
