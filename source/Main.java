import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        ExecutorService executor = Executors.newFixedThreadPool(5);


        City moscow = new City("Moscow", "MOW", "GMT+3");
        City newyork = new City("Newyork", "NYC", "GMT-5");
        City london = new City("London", "LON", "GMT");
        City berlin = new City("Berlin", "BER", "GMT+1");
        City newDelhi = new City("New Delhi", "DEL", "GMT+5");

      /*  for (Map.Entry<String, City> entry : City.cities.entrySet()) {


            String key = entry.getKey();
            City value = entry.getValue();
            System.out.println(key+value.getName());
        }*/
        Collections.sort(City.sorted);

        for (City city : City.sorted) {

            for (Map.Entry<String, City> entry : City.cities.entrySet()) {
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
            if (City.cities.containsKey(temp)) {
                list.add(temp);
            }

        }
        for (String key : list) {
            executor.execute(new ThreadRunner(City.cities.get(key)));
        }
    }


}
