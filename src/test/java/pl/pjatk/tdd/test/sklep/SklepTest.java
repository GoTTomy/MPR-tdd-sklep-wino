package pl.pjatk.tdd.test.sklep;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pl.pjatk.tdd.sklep.KartaKlienta;
import pl.pjatk.tdd.sklep.Sklep;
import pl.pjatk.tdd.sklep.ZnizkaKlienta;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SklepTest {

    @Parameterized.Parameter (value = 0)
    public double kwotaZakupu;

    @Parameterized.Parameter (value = 1)
    public int oczekiwanaIloscKuponow;

    @Parameterized.Parameter (value = 2)
    public double oczekiwanaZnizka;

    private ZnizkaKlienta znizka;
    private KartaKlienta karta;


    @Parameterized.Parameters (name = "[{index}] Przy zakupie za kwotę {0} oczekiwana ilość kuponów powinna wynieść {1} a znizka {2}")
    public static Collection<Object[]> dataProvider(){
        return Arrays.asList(new Object[][]{
                //TODO: Dokończ wypisanie przypadków brzegowych dla 80 zł i 120 zł
                {39.99, 0,0},
                {40.00, 1,0},
                {50.01,1,0.05},
                {80.00, 2,0.05},
                {100.01,2,0.1},
                {120.00,3,0.1}
        });
    }

    @Before
    public void setup(){
        karta = Sklep.wydajNowaKarte();
        znizka = Sklep.wydajNowaZnizke();
    }

    @Test
    public void klientPowinienDostacOdpowiedniaIloscKuponow(){
        Sklep.dokonajZakupu(karta, kwotaZakupu,znizka);
        assertEquals(oczekiwanaIloscKuponow, karta.getKupony());
    }

    @Test
    public void klientPowinienDostacOdpowiedniaZnizke(){
        Sklep.dokonajZakupu(karta, kwotaZakupu,znizka);
        assertEquals(oczekiwanaZnizka, znizka.getZnizka(),0.0001);
    }

    @Test
    public void klientPowinienMiecStatusStalegoKlienta(){
        Sklep.dokonajZakupu(karta, 120,znizka);
        Sklep.dokonajZakupu(karta, 120,znizka);
        Sklep.dokonajZakupu(karta, 120,znizka);
        Sklep.dokonajZakupu(karta, 120,znizka);

        assertTrue(karta.getStalyKlient());
    }

    @Test
    public void klientNiePowinienMiecStatusStalegoKlienta(){
        Sklep.dokonajZakupu(karta, 120,znizka);
        assertFalse(karta.getStalyKlient());
    }
}
