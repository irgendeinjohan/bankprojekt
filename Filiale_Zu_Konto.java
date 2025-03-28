class Filiale_Zu_Konto{
    bank_filiale Filiale;
    Konto Konto;
    Filiale_Zu_Konto(bank_filiale bf, Konto ko) {
        Filiale = bf;
        Konto = ko;
    }
    void FilialeSetzen(bank_filiale bf) {
        Filiale = bf;
    }
    public bank_filiale FilialeHolen() {
        return Filiale;
    }
    void KontoSetzen(Konto ko) {
        Konto=ko;
    }
    public Konto KontoHolen() {
        return Konto;
    }
}