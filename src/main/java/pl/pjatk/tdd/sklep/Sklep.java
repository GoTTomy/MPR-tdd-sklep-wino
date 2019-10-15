package pl.pjatk.tdd.sklep;

public class Sklep {
    public static void dokonajZakupu(KartaKlienta karta, double kwotaZakupu, ZnizkaKlienta znizka) {
        //TODO: dodaj algorytm na liczenie ilości kuponów jakie należą się za zakupu
        if(kwotaZakupu>=40.00){
            if(kwotaZakupu >50 & kwotaZakupu<100){
                if(znizka.getZnizka()!=0.05){
                    znizka.setZnizka(0.05);
                }
            }
            else if(kwotaZakupu > 100){
                if(znizka.getZnizka()!=0.1){
                    znizka.setZnizka(0.1);
                }
            }
            String z = String.valueOf(kwotaZakupu/40);
            int x = Integer.parseInt(z.substring(0,z.indexOf(".")));
            if(x>=3) x = 3;
            for(int i =0; i < x; i++){
                karta.dodajKupony(1);
                //Jezeli ilosc zrealizowanych kuponów >=10 ustawiamy stan Stalego Klienta.
                if(karta.getZrealizowaneKupony()>=10){
                    karta.setStalyKlient();
                }
            }
        }
    }

    public static KartaKlienta wydajNowaKarte(){
        return new KartaKlienta();
    }

    public static ZnizkaKlienta wydajNowaZnizke(){
        return new ZnizkaKlienta();
    }
}
