package pl.pjatk.tdd.sklep;

public class KartaKlienta {
    private int dostepneKupony,zrealizowaneKupony;
    private boolean czyStalyKlient;

    KartaKlienta(){
        this.dostepneKupony = 0;
        this.zrealizowaneKupony = 0;
        this.czyStalyKlient = false;
    }

    public void setKupony(int dostepneKupony) {
        this.dostepneKupony = dostepneKupony;
    }

    public int getKupony() {
        return dostepneKupony;
    }

    void dodajKupony(int ilośćKuponów) {
        this.dostepneKupony += ilośćKuponów;
        this.zrealizowaneKupony += ilośćKuponów;
    }

    public int getZrealizowaneKupony(){
        return zrealizowaneKupony;
    }

    public boolean getStalyKlient() {
         return czyStalyKlient;
    }

    public void setStalyKlient(){
        this.czyStalyKlient=true;
    }
}
