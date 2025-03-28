public class KommandozeilenApp
{
    public static void main() {
       boolean appStoppen = false;
       int menüwahl;
       int senIBAN;
       int empIBAN;
       double Betrag;
       String Vorname;
       String Nachname;
       String Geburtsdatum;
       String Adresse;
       Methoden Methoden = new Methoden(); // Ganzen Befehle her holen
       System.out.println("Herzlich Willkommen beim Menü der Gnedl Bank");
       while(!appStoppen) {
           System.out.print("\u000C"); // Konsole leer machen
           System.out.println("Was wollen sie tun?");
           System.out.println("------------------------------------------");
           System.out.println("(1) Konten ausgeben");
           System.out.println("(2) Überweisung ausführen");
           System.out.println("(3) Konto anlegen");
           System.out.println("(4) Kunden ausgeben");
           System.out.println("(5) Kunden anlegen");
           System.out.println("(6) Kunde Konto Verbinden");
           System.out.println("(7) Filialen ausgeben");
           System.out.println("(8) Filiale Konto Verbinden");
           System.out.println("(9) Geldautomat Öffnen");
           System.out.println("(99) App beenden");
           menüwahl = Eingabe.readInt("Was wollen Sie tun: ");
           
           if (menüwahl == 1) {
               while (menüwahl != 0) {
                   if(menüwahl == 1) { // automatisch, weil wegen MainMenü menüwahl=1/
                       System.out.print("\u000C"); // Konsole leer machen
                       Methoden.KontenAusgeben();
                   }
                   if (menüwahl == 2) {
                       System.out.println("");
                       System.out.println("------------------------------------------");
                       System.out.println("");
                       senIBAN = Eingabe.readInt("Bitte geben Sie die Sender IBAN ein (ohne DE)");
                       empIBAN = Eingabe.readInt("Bitte geben Sie die Empfänger IBAN ein (ohne DE)");
                       Betrag = Eingabe.readDouble("Bitte Betrag eingeben");
                   
                       Methoden.Ueberweisung(senIBAN, empIBAN, Betrag);
                   }
                   System.out.println("(0) Zurück zum Menü");
                   System.out.println("(1) Liste aktualisieren");
                   System.out.println("(2) Überweisung ausführen");
                   menüwahl = Eingabe.readInt("Was wollen Sie tun: ");
               }              
           }
           else if (menüwahl == 2) {
               System.out.print("\u000C"); // Konsole leer
               senIBAN = Eingabe.readInt("Bitte geben Sie die Sender IBAN ein (ohne DE)");
               empIBAN = Eingabe.readInt("Bitte geben Sie die Empfänger IBAN ein (ohne DE)");
               Betrag = Eingabe.readDouble("Bitte Betrag eingeben");
               
               Methoden.Ueberweisung(senIBAN, empIBAN, Betrag);
               System.out.println("------------------------------------------");
               System.out.println("(0) Zurück zum Menü");
               while(Eingabe.readInt() != 0) {}
           }
           else if (menüwahl == 3) {
               System.out.print("\u000C"); //Konsole leer
               Methoden.KontoErstellen();
               System.out.println("------------------------------------------");
               System.out.println("(0) Zurück zum Menü");
               while(Eingabe.readInt() != 0) {}
           }
           else if (menüwahl == 4) {
               System.out.print("\u000C"); //Konsole leer
               Methoden.KundenAusgeben();
               System.out.println("------------------------------------------");
               System.out.println("(0) Zurück zum Menü");
               while(Eingabe.readInt() != 0) {}
           }
           else if (menüwahl == 5) {
               System.out.print("\u000C"); //Konsole leer
               System.out.println("Erstellung eines neuen Kunden");
               Vorname = Eingabe.readString("Vorname: ");
               Nachname = Eingabe.readString("Nachname: ");
               Geburtsdatum = Eingabe.readString("Geburtsdatum");
               Adresse = Eingabe.readString("Adresse: ");
               Methoden.KundenErstellen(Vorname, Nachname, Geburtsdatum, Adresse);
               System.out.println("------------------------------------------");
               System.out.println("(0) Zurück zum Menü");
               while(Eingabe.readInt() != 0) {}
           }
           else if (menüwahl == 6) {
               System.out.print("\u000C"); //Konsole leer
               System.out.println("Zuweisung von Kunde und Konto");
               int kundenid = Eingabe.readInt("KundenID eingeben");
               int kontoIBAN = Eingabe.readInt("IBAN eingeben (ohne DE)");
               Methoden.KundeKontoVer(kundenid, kontoIBAN);
               System.out.println("------------------------------------------");
               System.out.println("(0) Zurück zum Menü");
               while(Eingabe.readInt() != 0) {}
           }
           else if (menüwahl == 7) {
               System.out.print("\u000C"); //Konsole leer
               System.out.println("ALLE FILIALEN WERDEN GELISTET");
               Methoden.FilialenAusgeben();
               System.out.println("------------------------------------------");
               System.out.println("(0) Zurück zum Menü");
               while(Eingabe.readInt() != 0) {}
           }
           else if (menüwahl == 8) {
               System.out.print("\u000C"); //Konsole leer
               System.out.println("KONTO MIT FILIALE VERBINDEN");
               String filialenName = Eingabe.readString("Name der Filiale: ");
               int iban = Eingabe.readInt("Iban eingeben (ohne DE): ");
               Methoden.FilialeKontoVer(filialenName, iban);
               System.out.println("------------------------------------------");
               System.out.println("(0) Zurück zum Menü");
               while(Eingabe.readInt() != 0) {}
           }
           else if (menüwahl == 9) {
               boolean kgefunden = false;
               boolean exit = false;
               double gsvermögen = 0;
               while(!kgefunden) {
                   System.out.print("\u000C"); //Konsole leer
                   System.out.println("WILLKOMMEN BEIM GELDAUTOMAT");
                   System.out.println("BITTE IDENTIFIZIEREN SIE SICH");
                   int kundenNr = Eingabe.readInt("Ihre KundenNummer: ");
                   for (Kunden k : Methoden.kundenListe) {
                       if (k.IDHolen() == kundenNr) {
                           kgefunden = true;
                           while (!exit) {
                               System.out.print("\u000C");
                               System.out.println("Willkommen auf der Bank " + k.VornameHolen() + " " + k.NachnameHolen() + "!");
                               System.out.println("Sie haben bei uns insgesamt: " + Methoden.GesamtVermögen(k) + "€");
                               System.out.println("Das sind ihre Konten");
                               int bzahl=0;
                               for (Kunde_Zu_Konto k2k : Methoden.kundeZuKontoListe) {
                                    if (k2k.KundenHolen() == k) {
                                       bzahl++;// Konten zählen
                                       System.out.println("   " + bzahl + ". DE" + k2k.KontoHolen().IBAN() + "-> " + k2k.KontoHolen().KontoStand() + "€"); 
                                    }              
                               }
                               System.out.println("");
                               System.out.println("------------------------------------------");
                               System.out.println("");
                               System.out.println("(0) Geldautomat schließen");
                               System.out.println("(1) Geld abheben");
                               System.out.println("(2) Geld einzahlen");
                               menüwahl = Eingabe.readInt("Was möchten Sie tun: ");
                               if(menüwahl == 0) {
                                   exit = true;
                               }
                               else if (menüwahl == 1 || menüwahl == 2) {
                                   int iban = Eingabe.readInt("Welches deiner Konten möchtest du benutzen: ");
                                   boolean kontogehörtkunde = false;
                                   for (Kunde_Zu_Konto k2k : Methoden.kundeZuKontoListe) {
                                       if (k2k.KundenHolen() == k && k2k.KontoHolen().IBAN() == iban) {
                                           kontogehörtkunde = true;
                                           
                                       }
                                   }
                                   if(kontogehörtkunde) {
                                       double betrag = Eingabe.readDouble("Um welchen Betrag geht es: ");
                                       if (menüwahl ==1) {
                                           if(Methoden.prüfeBuchungMöglich(iban, -betrag)) {
                                               Methoden.führeBuchungDurch(iban, -betrag);
                                               while (Eingabe.readInt("(0) Bestätigen Sie den Empfang des Geldes") != 0) {}
                                               
                                           }
                                           else {
                                               System.out.println("Abheben abgebrochen");
                                               while (Eingabe.readInt("(0) Zurück") != 0) {}
                                           }
                                       }
                                       else {
                                           Methoden.führeBuchungDurch(iban, betrag);
                                           System.out.println("Geld erfolgreich eingezahlt");
                                           while (Eingabe.readInt("(0) Zurück") != 0) {}
                                       }
                                   }
                                   else {
                                       System.out.println("Das Konto gehört nicht Ihnen");
                                       while (Eingabe.readInt("(0) Zurück") != 0) {}
                                   }
                               }
                           }
                       }
                   }
                   if (!kgefunden) {
                       System.out.print("\u000C");
                       System.out.println("Kunden-Nummer Falsch");
                       System.out.println("(0) Zurück zum Menü");
                       System.out.println("(1) Nochmal probieren");
                       menüwahl = Eingabe.readInt("Was wollen sie tun: ");
                       if (menüwahl == 0) {
                           kgefunden = true;
                       }
                   }
               }
           }
           
           
           if(menüwahl == 99){
               appStoppen = true;
           }
       }
    }
}
