class bank_filiale {
    String Name;
    int Gründungsjahr;
    String Adresse;
    MITARBEITER Vorstand;
    bank_filiale(String n, int gj, String a,  MITARBEITER vs) {
        Name = n;
        Gründungsjahr = gj;
        Adresse = a;
        Vorstand = vs;
    }
    void NameSetzen(String n) {
        Name = n;
    }
    String NameHolen() {
        return Name;
    }
    void VorstandSetzen(MITARBEITER vs) {
        Vorstand = vs;
    }
    MITARBEITER VorstandHolen() {
        return Vorstand;
    }
}