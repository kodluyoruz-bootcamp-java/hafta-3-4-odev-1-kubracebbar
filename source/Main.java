import Kodluyoruz.odevler.tümü.ucuncu.hafta.versiyon.iki.Berlin;
import Kodluyoruz.odevler.tümü.ucuncu.hafta.versiyon.iki.City;
import Kodluyoruz.odevler.tümü.ucuncu.hafta.versiyon.iki.London;
import Kodluyoruz.odevler.tümü.ucuncu.hafta.versiyon.iki.Moskow;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);
        City moscow = new Moskow("Moscow", "MOW", "GMT+3");
        City newyork = new Newyork("Newyork", "NYC", "GMT-5");
        City london = new London("London", "LON", "GMT");
        City berlin = new Berlin("Berlin", "BER", "GMT+1");
        City newDelhi = new NewDelhi("New Delhi", "DEL", "GMT+5");

        Map<String, City> map = new HashMap<String, City>();
        map.put(berlin.getCityCode(), berlin);
        map.put(moscow.getCityCode(), moscow);
        map.put(newyork.getCityCode(), newyork);
        map.put(london.getCityCode(), london);
        map.put(newDelhi.getCityCode(), newDelhi);

        List<City> sorted = new ArrayList<>(map.values());
        Collections.sort(sorted);

        for (City city : sorted) {

            for (Map.Entry<String, City> entry : map.entrySet()) {
                if (entry.getValue().equals(city)) {
                    System.out.println(entry.getKey() + " " + city.getName());
                }

            }
        }
        List<String> list = new ArrayList<String>();
        int value;
        while (true) {
            System.out.println("3 ile 5 arasında bir sayı girin");
            value = scanner.nextInt();
            if (value >= 3 && value <= 5) {
                break;
            } else {
                System.out.println("yanlış bir değer girdiniz lütfen doğru değer girin");
            }
        }
        System.out.println("şehir kodu giriniz");
        for (int i = 0; i <= value; i++) {
            String temp = scanner.nextLine().toUpperCase();
            if (map.containsKey(temp)) {
                list.add(temp);
            }
        }
        for (String key : list) {
            executor.execute(new ThreadRunner(map.get(key)));
        }
    }
}
