import java.util.function.Predicate;

/**
 * Beinhaltet die Funktionalitaeten fuer die Episoden
 *
 * @author Lennart Almstedt 4633202
 * @author Maximilian von Unwerth 4568393
 */
public class Episode implements Comparable<Episode> {
    /**
     * Code der Episode
     */
    private int code;
    /**
     * Code der Episode als String
     */
    private String codeString;
    /**
     * Der Titel der Episode
     */
    private String englishTitle;
    /**
     * Erstausstrahlung in den USA
     */
    private String usBroadcast;
    /**
     * Erstausstrahlung in Japan
     */
    private String japanBroadcast;
    /**
     * Time between Attribut
     */
    private int timeBetween;

    /**
     * Konstruktor
     *
     * @param codeString Entsprechendes Attribut
     * @param englishTitle Entsprechendes Attribut      
     * @param usBroadCast Entsprechendes Attribut
     * @param japanBroadCast Entsprechendes Attribut
     * @param timeBetween Entsprechendes Attribut
     */
    public Episode(String codeString, String englishTitle, String usBroadcast,
                   String japanBroadcast, int timeBetween ) {
        this.englishTitle = englishTitle;
        this.usBroadcast = usBroadcast;
        this.japanBroadcast = japanBroadcast;
        this.timeBetween = timeBetween;
        this.codeString = codeString;
        String season = codeString.substring(0,2);
        String number = codeString.substring(2);
        this.code = 0;
        //Decodiere die Episodennummer
        switch (season) {
            case("EP"): this.code +=1000;
                break;
            case("AG"): this.code +=2000;
                break;
            case("DP"): this.code +=3000;
                break;
            case("BW"): this.code +=4000;
                break;
            case("XY"): this.code +=5000;
                break;
            default: this.code +=9000;
        }
        this.code += Integer.parseInt(number);
    }
    /** 
     * Wandele die Episode in einen String um
     *
     * @return String des Objekts
     */
    public String toString() {
        String formatedLine = codeString + "|" + englishTitle + "|" + usBroadcast
                + "|" + japanBroadcast  + "|" + timeBetween;
        return formatedLine;
    }

    /**
     * Gibt den Episodencode zurueck
     *
     * @return Der Code
     */
    public int getCode() {
        return code;
    }
    
    /**
     * Vergleicht das Objekt
     *
     * @param o Objekt, mit dem Verglichen werden soll
     * @return Ist das Objekt groesser oder kleiner als das andere
     */
    @Override
    public int compareTo(Episode o) {
            Episode localEpisode = o;
            return code - localEpisode.getCode();
    }

    /**
     * Gibt den Titel zurueck
     * 
     * @return Titel der Episode
     */
    public String getName() {
        return englishTitle;
    }


}
