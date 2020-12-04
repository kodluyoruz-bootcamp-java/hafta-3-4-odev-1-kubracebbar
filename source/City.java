import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class City implements Clock, Comparable<City> {

    private String name;
    private String cityCode;
    private String gmt;
    public static Map<String, City> cities = new HashMap<String, City>();
    public static List<City> sorted;

    public Map<String, City> getCities() {
        return cities;
    }

    public void setCities(Map<String, City> cities) {
        this.cities = cities;
    }

    public City(String name, String cityCode, String gmt) {
        this.name = name;
        this.cityCode = cityCode;
        this.gmt = gmt;
        cities.put(cityCode, this);
        sorted = new ArrayList<>(cities.values());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getGmt() {
        return gmt;
    }

    public void setGmt(String gmt) {
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
