import java.util.concurrent.ThreadLocalRandom;
public class Konto
{
    private int IBAN;
    private double Kontostand;
    Konto() {
       IBAN = ThreadLocalRandom.current().nextInt(100000, 100000000);
       Kontostand = 0;
    }
    public void KotoStandSetzen(double kss) {
        Kontostand = kss;
    }
    public double KontoStand() {
        return Kontostand;
    }
    public void BuchungHinzufügen(double buchung) {
        Kontostand += buchung;
 
    }
    public int IBAN() {
        return IBAN;
    }
}