class MITARBEITER{
  String Vorname;
  String Nachname;
  int ID;
  String Adresse;
  String Abteilung; 
  MITARBEITER(String vn, String nn, int id, String adr, String abt) {
      Vorname = vn;
      Nachname = nn;
      ID = id;
      Adresse = adr;
      Abteilung = abt; 
    } 
    public void VornameSetzen(String vn) {
      Vorname = vn;
    }
   String VornameHolen() {
      return Vorname;
    }
  public void NachnameSetzen(String nn) {
      Nachname = nn;
    }
   String NachnameHolen() {
      return Nachname;
    }
  public void IDSetzen(int id) {
      ID = id;
    }
 
    private int IDHolen() {
        return ID;
    }
    public void AdresseSetzen(String adr) {
        Adresse = adr;
    }
     String AdresseHolen() {
        return Adresse;
    }
    public void Abteilung(String abt) {
        Abteilung = abt;
    }
}