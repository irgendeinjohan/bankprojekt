class Kunde_Zu_Konto{
    Kunden Kunden;
    Konto Konto;
    Kunde_Zu_Konto(Kunden ku, Konto ko) {
        Kunden = ku;
        Konto = ko;
    }
    void KundenSetzen(Kunden ku) {
        Kunden = ku;
    }
    public Kunden KundenHolen() {
        return Kunden;
    }
    void KontoSetzen(Konto ko) {
        Konto=ko;
    }
    public Konto KontoHolen() {
        return Konto;
    }
}