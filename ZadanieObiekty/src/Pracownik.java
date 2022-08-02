import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pracownik {

    public String imie;
    public String nazwisko;
    private String plec;
    private Integer placa;
    private Integer dzial;

    public Pracownik(String imie, String nazwisko, String plec, Integer placa, Integer dzial){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.placa = placa;
        this.dzial = dzial;
    }

    public static List<Pracownik> wczytajZPliku(String nazwaPliku, List<Pracownik> pracownicy) throws FileNotFoundException {
        File file = new File(nazwaPliku);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] liniaPracownik = line.split(" ");
            List<String> pracownik = Arrays.asList(line.split(" "));
            Pracownik nowy = new Pracownik(pracownik.get(0), pracownik.get(1),
                    pracownik.get(2), Integer.valueOf(pracownik.get(3)), Integer.valueOf(pracownik.get(4)));
            pracownicy.add(nowy);
        }
        return pracownicy;
    }

    public static Integer srednieZarobki (List<Pracownik> pracownicy, String plec, Integer dzial){
        Integer liczba = 0;
        Integer suma = 0;
        for (Pracownik pracownik: pracownicy) {
            if (pracownik.plec.equals(plec) && pracownik.dzial.equals(dzial)){
                liczba++;
                suma += pracownik.placa;
            }
        }
        Integer srednia = suma/liczba;
        return srednia;
    }

    public static void zapisDoPliku(String nazwaPliku, List<Pracownik> pracownicy) throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter(nazwaPliku);
        for (Pracownik pracownik: pracownicy) {
            zapis.println(pracownik.imie + " " + pracownik.nazwisko + " "
                    + pracownik.plec + " " + pracownik.placa + " " + pracownik.dzial);
        }
        zapis.close();
    }
    @Override
    public String toString() {
        String message = "Pracownik: " + this.imie + " " + this.nazwisko + "\n"
                + "Plec: " + this.plec + "\n"
                + "Zarobki: " + this.placa + "\n"
                + "Dzial: " + this.dzial;
        return message;
    }

    public Boolean czyPracujeWDziale(Integer dzial) {
        if (this.dzial.equals(dzial)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

}




//PRACOWNICY
//
//        Napisać program do zarządzania danymi pracowników. W tym celu należy utworzyć klasę
//        Pracownik z następującymi polami:
//        imię – typu String;
//        nazwisko – typu String;
//        placa – typu Integer;
//        plec – typu String;
//        dzial – typu Integer;
//        1. Klasę tą wyposażyć w konstruktor, którego parametry umożliwią przypisanie wartości
//        wszystkim polom klasy.
//        2. W klasie Pracownik stworzyć statyczną funkcję wczytajZPlikuTekstowego, której zadaniem
//        jest odczytanie danych pracowników zapisanych w pliku tekstowym i utworzenie dla nich
//        obiektów klasy Pracownik. Dane zapisane są w formacie:
//        Imię Nazwisko Płaca Płeć Nr działu
//        Przykład
//        Jan Kowalski 2010 M 3
//        Agnieszka Cuber 2900 K 3
//        Adam Nowak 1100 M 4
//        Sylwia Zych 2100 K 3
//        Beata Dudek 1900 K 4
//        Metoda wczytajZPlikuTekstowego przyjmuje 2 parametry:
//        – nazwę pliku tekstowego z danymi pracowników,
//        – Liste do przechowywania wczytanych obiektów klasy Pracownik
//        Metoda powinna zwrocic Liste pracownikow odczytanych. (Integer) (List.size())
//        3. Napisać metodę statyczną o nazwie srednieZarobki, której parametrem jest tablica
//        pracowników, numer działu oraz płeć, a wynikiem średnia płaca osób pracujących w dziale
//        o podanym numerze oraz o podanej płci
//        Przykładowo wynikiem metody srednieZarobki dla kobiet z działu 3 w podanym
//        przykładzie powinna być wartość 2500.
//        4. Napisać statyczną metodę zapiszDoPliku, której zadaniem będzie zapisanie obiektów
//        (serializacja) typu pracownik do pliku o nazwie podanej jako pierwszy parametr. Drugim
//        parametrem jest tablica obiektów typu Pracownik, które powinny zapisane do pliku.
//        5. Napisać statyczną metodę odczytZPliku, której zadaniem będzie wczytanie tablicy
//        obiektów z pliku (zapisanych metodą zapiszDoPliku).
//        String.split(" ")
//        6. Napisac metodę toString (nadpisanie metody z klasy Object), która zwraca łańcuch zawierający dane
//        pracownika;
//        7. Napisac metodę czyPracujeWDziale, która zwraca true, jeżeli pracownik pracuje w dziale o
//        podanym numerze