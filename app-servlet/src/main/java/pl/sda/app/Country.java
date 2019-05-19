package pl.sda.app;

import java.util.Arrays;

public enum Country {
    Germany(new City[]{City.Duesseldorf, City.Eschborn, City.Leinfelden_Echterdingen}),
    Spain(new City[]{City.Barcelona}),
    Hungary(new City[]{City.Pecs});

    private City[] cities;

    Country(City[] cities) {
        this.cities = cities;
    }

    public City[] getCities() {
        return cities;
    }

    public static String toJsArray() {
        StringBuilder sb = new StringBuilder();
        for (Country country : values()) {
            sb.append("'").append(country).append("'").append(": [");
            for (City city : country.cities){
                sb.append("'").append(city).append("'").append(",");
            }
            sb.append("],");
        }
        String result = sb.toString();
        System.out.println(result);
        System.out.println("'Germany': ['Duesseldorf', 'Leinfelden-Echterdingen', 'Eschborn',],\n" +
                "        'Spain': ['Barcelona',],\n" +
                "        'Hungary': ['Pecs',],");



        return result;
    }
}
