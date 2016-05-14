import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Predicate;

/**
* Hauptklasse
* Liest die csv-Datei ein
* Beinhaltet die Main-Methode 
* 
* @author Lennart Almstedt 4633202 Group 11d
* @author Maximilian von Unwerth 4568393 Group 11d
*/
public class Pokedex {
	/**
	 * Die doppelt-verkettete Listen
	 */
    private static DoubleLinkedList<Episode> dlEpisode = new DoubleLinkedList<Episode>();
    private static DoubleLinkedList<Pokemon> dlPokemon = new DoubleLinkedList<Pokemon>();

	/**
	 * Main-Methode
	 * Haupteinstiegspunkt des Programms,
	 * die csv-Datei wird eingelesen und
	 * die DoubleLinkedList wird gefuellt,
	 * sowie anschliessend ausgegeben.
	 * @param args Mainmethoden-Paramter
	 */
	public static void main(String[] args) {
		Reader reader = new Reader();
		dlEpisode = reader.episodeCsvRead();
		dlPokemon = reader.pokemonCsvRead();
		List<Pokemon> p1 = dlPokemon.filter(new pNamePredicate());
		p1.addAll(dlPokemon.filter(new pNumberPredicate()));

		//dlPokemon.addAll(dlPokemon);

		System.out.println(p1.toString());
		//System.out.println(dlPokemon.isInList(new Pokemon(0, "", "", "", 0,0,0,0,0,0,0 )));
		//System.out.println(dlPokemon.get(10));
		//List<Episode> list = dlEpisode.filter(new eCodePredicate());
		//System.out.println(dlEpisode.toString());
		//System.out.println(dlPokemon.toString());
		//System.out.println(dlPokemon.toString());
	}

    /**
     * Filtert die Pokemon heraus,deren Name mit P beginnt
     */
	static class pNamePredicate implements Predicate<Pokemon> {

		@Override
		public boolean test(Pokemon pokemon) {
			return pokemon.getName().charAt(0) == 'P';
		}
	}

    /**
     * Filtert die Pokemon heraus, die eine Nummer kleiner oder gleich 493 haben
     */
	static class pNumberPredicate implements Predicate<Pokemon> {

		@Override
		public boolean test(Pokemon pokemon) {
			return pokemon.getNr() <= 493;
		}
	}

    /**
     * Filtert die Episoden heraus, in deren Titel "Pikachu" vorkommt
     */
	static class pikachuPredicate implements Predicate<Episode> {

		@Override
		public boolean test(Episode episode) {
			return  episode.getName().contains("Pikachu");
		}
	}

    /**
     * Filtert die Episoden der ersten Staffel heraus
     */
	static class eCodePredicate implements Predicate<Episode> {

		@Override
		public boolean test(Episode episode) {
			return episode.getCode() >=1000 && episode.getCode() < 2000;
		}
	}
}
