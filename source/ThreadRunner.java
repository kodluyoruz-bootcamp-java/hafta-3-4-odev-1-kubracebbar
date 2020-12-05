import Kodluyoruz.odevler.tümü.ucuncu.hafta.versiyon.iki.City;

public class ThreadRunner implements Runnable {
    private City city;

    public ThreadRunner(City city) {
        this.city = city;
    }

    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                city.showTime();
                try {
                    Thread.sleep(6000);
                } catch (Exception ex) {
                }
            }

        }
    }
}
