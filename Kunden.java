public class Kunden
{
    private int ID;
    private String Vorname;
    private String Nachname;
    private String Geburtsdatum;
    private String Adresse;
    
    Kunden(int id, String VN, String NN, String GD, String A) {
        ID = id;
        Vorname = VN;
        Nachname = NN;
        Geburtsdatum = GD;
        Adresse = A;
    }
    
    public int IDHolen() {
        return ID;
    }
    public String VornameHolen() {
        return Vorname;
    }
    public String NachnameHolen() {
        return Nachname;
    }
    public String GeburtsdatumHolen() {
        return Geburtsdatum;
    }
    public String AdresseHolen() {
        return Adresse;
    }
    
    public void VornameSetzen(String vn) {
        Vorname = vn;
    }
    public void NachnameSetzen(String nn) {
        Nachname = nn;
    }
    public void GeburtstagSetzen(String gd) {
        Geburtsdatum = gd;
    }
    public void AdresseSetzen(String a) {
        Adresse = a;
    }
}
