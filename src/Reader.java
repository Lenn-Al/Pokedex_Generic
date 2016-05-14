import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Hilfsklasse, um .csv Dateien einzulesen 
 * 
 * @author Lennart Almstedt 4633202 Group 11d
 * @author Maximilian von Unwerth 4568393 Group 11d
 */
public class Reader {

    /**
     * Liest eine .csv Datei von Pokemon ein
     *
     * @return Doppelt verkettete Liste von Pokemon
     */
    public DoubleLinkedList<Pokemon> pokemonCsvRead() {
        DoubleLinkedList<Pokemon> currList = new DoubleLinkedList<>();
        try {
            BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("./Sources/Pokedex.csv"));
            int i;
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.charAt(0) == 'N') { //Erste Zeile der csv auslassen
                    line = bufferedReader.readLine(); //Nächste Zeile einlesen
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
                //Neues Pokemon erstellen und einfuegen
                currList.insert(new Pokemon(Integer.parseInt(values[0]), values[1], values[2], values[3],
                        Integer.parseInt(values[4]), Integer.parseInt(values[5]), Integer.parseInt(values[6]),
                        Integer.parseInt(values[7]), Integer.parseInt(values[8]), Integer.parseInt(values[9]),
                        Integer.parseInt(values[10]))); //Einfuegen des Pokemon mit den Werten aus der Line der CSV
                line = bufferedReader.readLine(); //Naechste Zeile
            }
        } catch (IOException e) { //File-Not-Found-Exception
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return currList;
    }

    /**
     * Liest eine .csv Datei von Episoden ein
     *
     * @return Doppelt Verkettete Liste
     */
    public DoubleLinkedList<Episode> episodeCsvRead() {
        DoubleLinkedList<Episode> currList = new DoubleLinkedList<>();
        try {
            BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("./Sources/Episoden.csv"));
            int i;
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.charAt(0) == 'C') { //Erste Zeile ignorieren
                    continue;
                }
                String[] values = new String[5];
                for (int x = 0;x<values.length;x++) { //Array leeren
                    values[x] = "";
                }
                i=0;
                for (int j=0;j<4;j++) {
                    while (line.charAt(i) != ',') {
                        values[j] += line.charAt(i);
                        i++;
                    }
                    i++;
                }
                for (int y=i;y<line.length();y++) {
                    values[4] += line.charAt(y);
                }
                currList.insert(new Episode(values[0],values[1],values[2],values[3],Integer.parseInt(values[4])));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return currList;
    }
}
