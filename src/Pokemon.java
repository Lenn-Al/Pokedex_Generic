package pokedex_generic_nb;

/**
*
* Ein Pokemon
*
* @author Lennart Almstedt 4633202 Group 11d
* @author Maximilian von Unwerth 4568393 Group 11d
* @author Joshua Heinemann 4701655 Group 11d
*/
public class Pokemon implements Comparable {
    /**
    * Das vorherige Element der Liste
    */
    private Pokemon prev;
    /**
    * Das naechste Element der Liste
    */
    private Pokemon next;
    
    /**
    * Die Nummer des Pokemons
    */
    private int nr;
    /**
    * Der Name des Pokemons
    */
    private String name;
    /**
    * Typ1 des Pokemons
    */
    private String type1;
    /**
    * Typ2 des Pokemons
    */
    private String type2;
    /**
    * Die Summe aller Werte des Pokemons
    */
    private int total;
    /**
    * Die Kraftpunkte des Pokemons
    */
    private int hp;
    /**
    * Der Angriffswert des Pokemons
    */
    private int atk;
    /**
    * Der Verteidigungswert des Pokemons
    */
    private int def;
    /**
    * Der Spezialangriffswert des Pokemon
    */
    private int spatk;
    /**
    * Der Spezilverteidigungswert des Pokemon
    */
    private int spdef;
    /**
    * Der Geschwindigkeitswert des Pokemon
    */
    private int speed;
    /**
    * Die Anzahl der maximalen Zeichen eines Namen, bzw. eines Typs
    * fuer das korrekt gezeichnete Layout
    */
    private final int longestString = 15;
    /**
    * NULL-Pokemon-Konstruktor (Standartkonstruktor)
    */
    public Pokemon() {
        this.nr = -1;
        this.name = "";
        this.type1 = "";
        this.type2 = "";
        this.total = 0;
        this.atk = 0;
        this.def = 0;
        this.spatk = 0;
        this.spdef = 0;
        this.speed = 0;
    }
    /**
    * Pokemon-Konstruktor, welcher das Objekt mit folgenden Werten
	* initialisiert.
    * @param nr Nummer des Pokemon
    * @param name Name des Pokemon
    * @param type1 Typ1 des Pokemon
    * @param type2 Typ2 des Pokemo
    * @param total Gesamtwert des Pokemon
    * @param hp Kraftpunkte des Pokemon
    * @param atk Angriff des Pokemon
    * @param def Verteidigung des Pokemon
    * @param spatk Spatk des Pokemon
    * @param spdef Spdef des Pokemon
    * @param speed Geschwindigkeit des Pokemon
    */
    public Pokemon(int nr, String name, String type1, String type2,
        int total, int hp, int atk, int def, int spatk,
        int spdef, int speed) {
        this.nr = nr;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.total = total;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spatk = spatk;
        this.spdef = spdef;
        this.speed = speed;
    }
    /**
    * Getter fuer die Nummer des Pokemon
    * @return Nummer des Pokemon
    */
    public int getNr() {
        return nr;
    }
    /**
    * Die Werte des Pokemon auf 3 Zeichen Laenge bringen
    * Fuer das Tabellenlayout
    * @param num Zu konvertierende Zahl
    * @return Konvertierte Werte des Pokemon
    */
    private String convertNumber(int num) {
        String sNr;
        if (num < 10) {
            //Bei einstelliger Ziffer 2 Leerzeichen hinzufuegen
            sNr = "  " + num;
        } else if (num < 100) {
            //Bei zweistelligem Wert + 2 Leerzeichen
            sNr = " " + num;
        } else {
            sNr = Integer.toString(num);
        }
        return sNr;
    }
    /**
    * String auf die maximale Laege eines Strings bringen
    * Fuer das Tabellenlayout mit Leerzeichen fuellen
    * @param str Name, Typ... der formatiert werden soll
    * @return Formatierter String auf maximale Laenge
    */
    private String convertString(String str) {
        String sName = "";
        for (int i = 0; i < Math.abs(longestString - str.length()); i++) {
            sName += " "; //Solange Leerzeichen hinzufuegen, bis max. Laenge erreicht wurde
        }
        sName += str;
        return sName;
    }
    /**
    * An vorderes Element ankoppeln
    * @param pkm vorderes Pokemon
    */
    public void setPrev(Pokemon pkm) {
        this.prev = pkm;
    }
    /**
    * Vorheriges Element zurueckgeben
    * @return Vorheriges Pokemon
    */
    public Pokemon prev() {
        return prev;
    }
    /**
    * Nachfolgendes Element setzen
    * @param pkm Naechstes Pokemon
    */
    public void setNext(Pokemon pkm) {
        this.next = pkm;
    }
    /**
    * Gibt naechste Pokemon zurueck
    * @return Nachfolgendes Pokemon
    */
    public Pokemon next() {
        return next;
    }
    /**
    * Werte in Strings umwandeln und
    * kompletten Eintrag als Reihe speichern
    * @return Formatierte Reihe
    */
    public String toString() {
        String sNr = convertNumber(nr);
        String sName = convertString(name);
        String sType1 = convertString(type1);
        String sType2 = convertString(type2);
        String sTotal = convertNumber(total);
        String sHp = convertNumber(hp);
        String sAtk = convertNumber(atk);
        String sDef = convertNumber(def);
        String sSpAtk = convertNumber(spatk);
        String sSpDef = convertNumber(spdef);
        String sSpeed = convertNumber(speed);
        String formatedLine = sNr + " | " + sName 
        		  + " | " + sType1 + " | " + sType2 + " | " 
        		  + sTotal + " | " + sHp + " | " 
        		  + sAtk + " | " + sDef + " | " 
        		  + sSpAtk + " | " + sSpDef + " | " + sSpeed;
        return formatedLine;
    }
    
    public int compareTo(Object p) {
        if(p instanceof Pokemon) {
            if(nr < ((Pokemon) p).getNr()) {
                return -1;
            }
            if(nr == ((Pokemon)p).getNr()) {
                return 0;
            }
            if(nr > ((Pokemon) p).getNr()) {
                return 1;
            }
        }
        return 0;
    }
}
