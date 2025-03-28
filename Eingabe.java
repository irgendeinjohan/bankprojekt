import java.util.Scanner;

/**
 * Utility-Klasse für Konsoleneingaben
 * Erlaubt statischen Zugriff auf Eingabemethoden
 */
public class Eingabe {
    // Statischer Scanner für alle Eingabemethoden
    private static final Scanner scanner = new Scanner(System.in);
    
    /**
     * Liest eine Zeichenkette von der Konsole ein
     * @return Die eingegebene Zeichenkette
     */
    public static String readString() {
        return scanner.nextLine();
    }
    
    /**
     * Liest eine Zeichenkette mit Eingabeaufforderung ein
     * @param prompt Text, der vor der Eingabe angezeigt wird
     * @return Die eingegebene Zeichenkette
     */
    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    
    /**
     * Liest eine Ganzzahl ein
     * @return Die eingegebene Ganzzahl
     */
    public static int readInt() {
        try {
            int zahl = scanner.nextInt();
            scanner.nextLine(); // Zeilenumbruch konsumieren
            return zahl;
        } catch (Exception e) {
            scanner.nextLine(); // Fehlerhafte Eingabe konsumieren
            System.out.println("Fehler: Bitte gib eine gültige Zahl ein.");
            return readInt(); // Rekursiver Aufruf für erneute Eingabe
        }
    }
    
    /**
     * Liest eine Ganzzahl mit Eingabeaufforderung ein
     * @param prompt Text, der vor der Eingabe angezeigt wird
     * @return Die eingegebene Ganzzahl
     */
    public static int readInt(String prompt) {
        System.out.print(prompt);
        return readInt();
    }
    
    /**
     * Liest eine Fließkommazahl ein
     * @return Die eingegebene Fließkommazahl
     */
    public static double readDouble() {
        try {
            double zahl = scanner.nextDouble();
            scanner.nextLine(); // Zeilenumbruch konsumieren
            return zahl;
        } catch (Exception e) {
            scanner.nextLine(); // Fehlerhafte Eingabe konsumieren
            System.out.println("Fehler: Bitte gib eine gültige Zahl ein.");
            return readDouble(); // Rekursiver Aufruf für erneute Eingabe
        }
    }
    
    /**
     * Liest eine Fließkommazahl mit Eingabeaufforderung ein
     * @param prompt Text, der vor der Eingabe angezeigt wird
     * @return Die eingegebene Fließkommazahl
     */
    public static double readDouble(String prompt) {
        System.out.print(prompt);
        return readDouble();
    }
    
    /**
     * Liest einen booleschen Wert ein (j/n, ja/nein, true/false)
     * @return Der eingegebene boolesche Wert
     */
    public static boolean readBoolean() {
        String eingabe = scanner.nextLine().toLowerCase();
        if (eingabe.equals("j") || eingabe.equals("ja") || eingabe.equals("true") || eingabe.equals("1")) {
            return true;
        } else if (eingabe.equals("n") || eingabe.equals("nein") || eingabe.equals("false") || eingabe.equals("0")) {
            return false;
        } else {
            System.out.println("Fehler: Bitte gib j/n, ja/nein oder true/false ein.");
            return readBoolean(); // Rekursiver Aufruf für erneute Eingabe
        }
    }
    
    /**
     * Liest einen booleschen Wert mit Eingabeaufforderung ein
     * @param prompt Text, der vor der Eingabe angezeigt wird
     * @return Der eingegebene boolesche Wert
     */
    public static boolean readBoolean(String prompt) {
        System.out.print(prompt + " (j/n): ");
        return readBoolean();
    }
    
    /**
     * Liest ein einzelnes Zeichen ein
     * @return Das eingegebene Zeichen
     */
    public static char readChar() {
        String eingabe = scanner.nextLine();
        if (eingabe.length() > 0) {
            return eingabe.charAt(0);
        } else {
            return '\0'; // Null-Zeichen bei leerer Eingabe
        }
    }
    
    /**
     * Liest ein einzelnes Zeichen mit Eingabeaufforderung ein
     * @param prompt Text, der vor der Eingabe angezeigt wird
     * @return Das eingegebene Zeichen
     */
    public static char readChar(String prompt) {
        System.out.print(prompt);
        return readChar();
    }
    
    /**
     * Schließt den Scanner
     * Sollte aufgerufen werden, wenn keine Eingaben mehr erwartet werden
     */
    public static void close() {
        scanner.close();
    }
}
