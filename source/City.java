import Kodluyoruz.odevler.tümü.ucuncu.hafta.versiyon.iki.Clock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class City implements Clock, Comparable<City> {

    String name;
    String gmt;
    String cityCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGmt() {
        return gmt;
    }

    public void setGmt(String gmt) {
        this.gmt = gmt;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }


    public City(String name, String cityCode, String gmt) {
        this.name = name;
        this.cityCode = cityCode;
        this.gmt = gmt;
    }

    @Override
    public int compareTo(City city) {
        return this.getName().compareTo(city.getName());
    }

    @Override
    public void showTime() {
        Date today = Calendar.getInstance().getTime();
        DateFormat dFormat = new SimpleDateFormat("dd-MM-yy HH:mm:SS z");
        dFormat.setTimeZone(TimeZone.getTimeZone(gmt));
        String formatter = dFormat.format(today);
        System.out.println(formatter);
    }
}
