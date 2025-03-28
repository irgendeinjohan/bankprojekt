import java.util.ArrayList;

public class Methoden {
    // Listen erstellen
    public ArrayList<Kunden> kundenListe;
    public ArrayList<Konto> kontoListe;
    public ArrayList<Kunde_Zu_Konto> kundeZuKontoListe;
    private ArrayList<MITARBEITER> mitarbeiterListe;
    private ArrayList<bank_filiale> bankFilialeListe;
    private ArrayList<Filiale_Zu_Konto> filialeZuKontoListe;
    private int bzahl;
    private int kundenidzaehler = 4;
    
    Methoden() {
        // Listen initialisieren
        kundenListe = new ArrayList<Kunden>();
        kontoListe = new ArrayList<Konto>();
        kundeZuKontoListe = new ArrayList<Kunde_Zu_Konto>();
        mitarbeiterListe = new ArrayList<MITARBEITER>();
        bankFilialeListe = new ArrayList<bank_filiale>();
        filialeZuKontoListe = new ArrayList<Filiale_Zu_Konto>();
        
        // Kunden
        Kunden ku1 = new Kunden(1, "Markus", "Telegram", "01.01.200", "KotStraße5");
        kundenListe.add(ku1);
        Kunden ku2 = new Kunden(2, "Marvin", "Teischler", "01.01.200", "KotStraße5");
        kundenListe.add(ku2);
        Kunden ku3 = new Kunden(3, "Levis", "Jeans", "01.01.1999", "KotStraße5");
        kundenListe.add(ku3);
        Kunden ku4 = new Kunden(4, "Santos", "Kolokatis", "01.07.2000", "KotStraße5");
        kundenListe.add(ku4);
        
        // Konten
        Konto ko1 = new Konto();
        ko1.KotoStandSetzen(100);
        kontoListe.add(ko1);
        Konto ko2 = new Konto();
        ko2.KotoStandSetzen(34.2);
        kontoListe.add(ko2);
        Konto ko3 = new Konto();
        ko3.KotoStandSetzen(1000);
        kontoListe.add(ko3);
        Konto ko4 = new Konto();
        ko4.KotoStandSetzen(500);
        kontoListe.add(ko4);
        
        // Kunde-zu-Konto
        Kunde_Zu_Konto k2k_1 = new Kunde_Zu_Konto(ku1, ko1);
        kundeZuKontoListe.add(k2k_1);
        Kunde_Zu_Konto k2k_2 = new Kunde_Zu_Konto(ku2, ko1);
        kundeZuKontoListe.add(k2k_2);
        Kunde_Zu_Konto k2k_3 = new Kunde_Zu_Konto(ku2, ko2);
        kundeZuKontoListe.add(k2k_3);
        Kunde_Zu_Konto k2k_4 = new Kunde_Zu_Konto(ku3, ko3);
        kundeZuKontoListe.add(k2k_4);
        Kunde_Zu_Konto k2k_5 = new Kunde_Zu_Konto(ku4, ko4);
        kundeZuKontoListe.add(k2k_5);
        
        // Mitarbeiter
        MITARBEITER m1 = new MITARBEITER("Tomaten", "AufDenAugen", 1, "MarkusWeg44", "Verwaltung");
        mitarbeiterListe.add(m1);
        MITARBEITER m2 = new MITARBEITER("Lila", "AugenBrauenHaben", 1, "LukasWeg44", "Verwaltung");
        mitarbeiterListe.add(m2);
    
        // Bankfilialen
        bank_filiale bf1 = new bank_filiale("Filiale Steffan", 1875, "Weg0", m1);
        bankFilialeListe.add(bf1);
        bank_filiale bf2 = new bank_filiale("Filiale Marvin", 1875, "Weg0", m2);
        bankFilialeListe.add(bf2);
        
        // Filiale-zu-Konto
        Filiale_Zu_Konto f2k_1 = new Filiale_Zu_Konto(bf1, ko1);
        filialeZuKontoListe.add(f2k_1);
        Filiale_Zu_Konto f2k_2 = new Filiale_Zu_Konto(bf1, ko2);
        filialeZuKontoListe.add(f2k_2);
        Filiale_Zu_Konto f2k_3 = new Filiale_Zu_Konto(bf2, ko3);
        filialeZuKontoListe.add(f2k_3);
        Filiale_Zu_Konto f2k_4 = new Filiale_Zu_Konto(bf2, ko4);
        filialeZuKontoListe.add(f2k_4);
    }
    public double GesamtVermögen(Kunden k){
        double gsvermögen = 0;
        for (Kunde_Zu_Konto k2k : kundeZuKontoListe) { 
            if (k2k.KundenHolen() == k) {
                gsvermögen += k2k.KontoHolen().KontoStand();
            }              
        }
        return gsvermögen;
    }
    void FilialenAusgeben() {
        System.out.println("");
        for (bank_filiale bf : bankFilialeListe) {
            double gsvermögen = 0;
            bzahl = 0;
            System.out.println("Name: " + bf.NameHolen());
            System.out.println("Vorstand: ");
            System.out.println("     Vorname: " + bf.VorstandHolen().VornameHolen());
            System.out.println("     Nachname: " + bf.VorstandHolen().NachnameHolen());
            System.out.println("     Adresse: " + bf.VorstandHolen().AdresseHolen());
            System.out.println("Konten:");
            for(Filiale_Zu_Konto f2k : filialeZuKontoListe) {
                if(f2k.FilialeHolen() == bf) {
                    bzahl++;
                    gsvermögen += f2k.KontoHolen().KontoStand();
                    System.out.println("     " + bzahl + ". DE" + f2k.KontoHolen().IBAN() + " -> " + f2k.KontoHolen().KontoStand() + "€");
                }
            }
            System.out.println("Gesamtvermögen: " + gsvermögen + "€");
            System.out.println("------------------------------------------");
        }
    }
    void KontenAusgeben() {
        System.out.println("------------------------------------------");
        System.out.println("ALLE KONTEN WERDEN GELISTET: ");
        System.out.println("");
        for (Konto k : kontoListe) {
            bzahl = 0; // Besitzer zählen
            System.out.println("IBAN: DE" + k.IBAN());
            System.out.println("Kontostand: " + k.KontoStand() + "€");
            System.out.println("Besitzer: ");
            for (Kunde_Zu_Konto k2k : kundeZuKontoListe) {
                if (k2k.KontoHolen() == k) {
                    bzahl++; // Besitzer zählen
                   System.out.println("   " + bzahl + ". " + k2k.KundenHolen().VornameHolen() + ", "+ k2k.KundenHolen().NachnameHolen()); 
                }              
            }
            
            System.out.println("------------------------------------------");
        }
    }
    void KundenAusgeben() {
        double gsvermögen = 0;
        System.out.println("------------------------------------------");
        System.out.println("ALLE KUNDEN WERDEN GELISTET: ");
        System.out.println("");
        for (Kunden k : kundenListe) {
            System.out.println("ID: " + k.IDHolen());
            System.out.println("Vorname: " + k.VornameHolen());
            System.out.println("Nachname: " + k.NachnameHolen());
            System.out.println("Geburtstag: " + k.GeburtsdatumHolen());
            System.out.println("Adresse: " + k.AdresseHolen());
            System.out.println("Konten: ");
            bzahl=0;
            gsvermögen = 0;
            for (Kunde_Zu_Konto k2k : kundeZuKontoListe) {
                if (k2k.KundenHolen() == k) {
                   bzahl++;// Besitzer zählen
                   gsvermögen += k2k.KontoHolen().KontoStand();
                   System.out.println("   " + bzahl + ". DE" + k2k.KontoHolen().IBAN() + "-> " + k2k.KontoHolen().KontoStand() + "€"); 
                }              
            }
            System.out.println("Gesamtvermögen: " + gsvermögen);
            System.out.println("------------------------------------------");
        }
    }
    void KontoErstellen() {
        Konto koAdd = new Konto();
        kontoListe.add(koAdd);
        System.out.println("------------------------------------------");
        System.out.println("Konto erfolgreich angelegt");
        System.out.println("IBAN: DE" + koAdd.IBAN());
        System.out.println("------------------------------------------");
    }
    void KundenErstellen(String VN, String NN, String GD, String A) {
        kundenidzaehler++;
        Kunden kuAdd = new Kunden(kundenidzaehler, VN, NN, GD, A);
        kundenListe.add(kuAdd);
        System.out.println("------------------------------------------");
        System.out.println("Kunde erfolgreich angelegt");
        System.out.println("ID: " + kuAdd.IDHolen());
        System.out.println("------------------------------------------");
    }
    void KundeKontoVer(int KundenID, int KontoIBAN) {
        Kunden gefundenerKunde = null;
        Konto gefundenesKonto = null;
        for (Kunden k : kundenListe) {
            if (k.IDHolen() == KundenID) {
                gefundenerKunde = k;
                break;
            }
        }
        
        for (Konto k : kontoListe) {
            if (k.IBAN() == KontoIBAN) {
                gefundenesKonto = k;
                break;
            }
        }
        
        if (gefundenerKunde == null) {
            System.out.println("------------------------------------------");
            System.out.println("Fehler: Kunde mit ID " + KundenID + " wurde nicht gefunden");
            System.out.println("------------------------------------------");
            return;
        }
        
        if (gefundenesKonto == null) {
            System.out.println("------------------------------------------");
            System.out.println("Fehler: Konto mit IBAN DE" + KontoIBAN + " wurde nicht gefunden");
            System.out.println("------------------------------------------");
            return;
        }
        
        // Schauen, obs Verknüpfung schon gibt
        for (Kunde_Zu_Konto k2k : kundeZuKontoListe) {
            if (k2k.KundenHolen() == gefundenerKunde && k2k.KontoHolen() == gefundenesKonto) {
                System.out.println("------------------------------------------");
                System.out.println("Hinweis: Der Kunde ist bereits mit diesem Konto verknüpft");
                System.out.println("------------------------------------------");
                return;
            }
        }
        
        // Verknüpfung hinzufügen
        Kunde_Zu_Konto neueVerknuepfung = new Kunde_Zu_Konto(gefundenerKunde, gefundenesKonto);
        kundeZuKontoListe.add(neueVerknuepfung);
        
        System.out.println("------------------------------------------");
        System.out.println("Verknüpfung erfolgreich erstellt");
        System.out.println("Kunde: " + gefundenerKunde.VornameHolen() + " " + gefundenerKunde.NachnameHolen());
        System.out.println("Konto: DE" + gefundenesKonto.IBAN());
        System.out.println("------------------------------------------");
    }
    void FilialeKontoVer(String FilialenName, int KontoIBAN) {
        bank_filiale gefundeneFiliale = null;
        Konto gefundenesKonto = null;
        for (bank_filiale bf : bankFilialeListe) {
            if (bf.NameHolen() == FilialenName) {
                gefundeneFiliale = bf;
                break;
            }
        }
        
        for (Konto k : kontoListe) {
            if (k.IBAN() == KontoIBAN) {
                gefundenesKonto = k;
                break;
            }
        }
        
        if (gefundeneFiliale == null) {
            System.out.println("------------------------------------------");
            System.out.println("Fehler: Filiale mit Name " + FilialenName + " wurde nicht gefunden");
            System.out.println("------------------------------------------");
            return;
        }
        
        if (gefundenesKonto == null) {
            System.out.println("------------------------------------------");
            System.out.println("Fehler: Konto mit IBAN DE" + KontoIBAN + " wurde nicht gefunden");
            System.out.println("------------------------------------------");
            return;
        }
        
        // Schauen, obs Verknüpfung schon gibt
        for (Filiale_Zu_Konto f2k : filialeZuKontoListe) {
            if (f2k.FilialeHolen() == gefundeneFiliale && f2k.KontoHolen() == gefundenesKonto) {
                System.out.println("------------------------------------------");
                System.out.println("Hinweis: Die Filiale ist bereits mit diesem Konto verknüpft");
                System.out.println("------------------------------------------");
                return;
            }
        }
        
        // Verknüpfung hinzufügen
        Filiale_Zu_Konto neueVerknuepfung = new Filiale_Zu_Konto(gefundeneFiliale, gefundenesKonto);
        filialeZuKontoListe.add(neueVerknuepfung);
        
        System.out.println("------------------------------------------");
        System.out.println("Verknüpfung erfolgreich erstellt");
        System.out.println("Filiale: " + gefundeneFiliale.NameHolen());
        System.out.println("Konto: DE" + gefundenesKonto.IBAN());
        System.out.println("------------------------------------------");
    }
    void führeBuchungDurch(int IBAN, double Betrag) {
        for (Konto k : kontoListe) {
            if (k.IBAN() == IBAN) {
                k.BuchungHinzufügen(Betrag);
            }
        }
    }
    boolean prüfeBuchungMöglich(int IBAN, double Betrag) {
        if ((Betrag * 100) % 1 != 0) {
            System.out.println("Betrag hat mehr als 2 Nachkommastellen");
            return false;
        }
        
        for (Konto k : kontoListe) {
            if (k.IBAN() == IBAN) {
                if (k.KontoStand() + Betrag < 0) {
                    System.out.println("Konto DE" + IBAN + " würde ins Minus gehen");
                    return false;
                }
                return true; // Buchung ist möglich
            }
        }
        
        System.out.println("IBAN 'DE" + IBAN + "' wurde nicht gefunden");
        return false;
    }
    void Ueberweisung (int SenderIBAN, int EmpfangIBAN, double betrag) {
        if (betrag < 0) {
            System.out.println("Betrag darf nicht negativ sein");
            return;
        }
        
        // Schauen ob Buchungen Möglich sind
        if (!prüfeBuchungMöglich(SenderIBAN, -betrag) || !prüfeBuchungMöglich(EmpfangIBAN, betrag)) {
            System.out.println("Überweisung abgebrochen - eine der Buchungen ist nicht möglich");
            return;
        }
        
        // Buchungen machen
        führeBuchungDurch(SenderIBAN, -betrag);
        führeBuchungDurch(EmpfangIBAN, betrag);
        System.out.println("Überweisung erfolgreich");
    }
    
}
