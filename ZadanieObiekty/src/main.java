import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) throws FileNotFoundException {

        Pracownik pierwszy = new Pracownik("Agata", "Malinska", "kobieta", 2600, 4);
        Pracownik drugi = new Pracownik("Michal", "Nowak", "mezczyzna", 1800, 4);
        Pracownik trzeci = new Pracownik("Przemyslaw", "Kotonski", "mezczyna", 5900, 1);
        Pracownik czwarty = new Pracownik("Patrycja", "Fredro", "kobieta", 6600, 1);
        Pracownik piaty = new Pracownik("Malgorzata", "Kalinowska", "kobieta", 5700, 1);
        Pracownik szosty = new Pracownik("Tomasz", "Ogon", "mezczyzna", 3400, 4);

        List<Pracownik> pracownicy = new ArrayList<>();
        pracownicy.addAll(Arrays.asList(pierwszy, drugi, trzeci, czwarty, piaty, szosty));
        Pracownik.zapisDoPliku("pracownicy.txt", pracownicy);

        List<Pracownik> odczytaniPracownicy = new ArrayList<>();
        odczytaniPracownicy = Pracownik.wczytajZPliku("pracownicy.txt", odczytaniPracownicy);
        for (Pracownik odczytany: odczytaniPracownicy) {
            System.out.println(odczytany);
        }

        System.out.println(Pracownik.srednieZarobki(odczytaniPracownicy, "kobieta", 1));
        System.out.println(Pracownik.srednieZarobki(odczytaniPracownicy, "mezczyzna", 4));

        System.out.println(pierwszy.czyPracujeWDziale(4));
    }
}