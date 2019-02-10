package sda.pizza;

import org.apache.commons.lang3.text.StrSubstitutor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PizzaOrder {

    private List<String> components;
    private PizzaSize size;
    private String address;
    private String phone;

    private static final String PIZZA_COMPONENTS = "PIZZA_COMPONENTS";
    public static final String PIZZA_ADDRESS = "PIZZA_ADDRESS";
    public static final String PIZZA_MOBILE = "PIZZA_MOBILE";
    private static String ORDER_TEMPLATE = "<speak><amazon:auto-breaths frequency=\"low\" volume=\"soft\" duration=\"x-short\">" +
            "Dzień Dobry. Chcielibyśmy zamówić pizzę z następującymi składnikami: <break time=\"1s\"/> " +
            placeholder(PIZZA_COMPONENTS) +
            "<break time=\"2s\"/>. Adres zamówienia to " +
            placeholder(PIZZA_ADDRESS) +
            "<break time=\"2s\"/>. Mój numer telefonu to " +
            placeholder(PIZZA_MOBILE) +
            "</amazon:auto-breaths></speak>";

    public PizzaOrder(List<String> components, String address, String phone) {
        this.components = components;
        this.address = address;
        this.phone = phone;
    }

    public String toTextOrder() {
        return StrSubstitutor.replace(ORDER_TEMPLATE, getPizzaOrderMap());
    }

    private Map<String, String> getPizzaOrderMap() {
        Map<String, String> data = new HashMap<String, String>();
        data.put(PIZZA_COMPONENTS, getComponentsAsString());
        data.put(PIZZA_ADDRESS, getAddress());
        data.put(PIZZA_MOBILE, getPhone().replaceAll("-", ". "));

        return data;
    }

    private String getComponentsAsString() {
        return getComponents().stream().collect(Collectors.joining(","));
    }

    private static String placeholder(String key) {
        return "${" + key + "}";
    }

    public List<String> getComponents() {
        return components;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "PizzaOrder{" +
                "components=" + getComponentsAsString() +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
