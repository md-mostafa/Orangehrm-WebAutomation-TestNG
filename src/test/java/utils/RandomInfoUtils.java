package utils;

import com.github.javafaker.Faker;

public class RandomInfoUtils {
    private static Faker faker = new Faker();
    private RandomInfoUtils() {

    }

    public static String getFirstName() {
        return faker.name().firstName();
    }
    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getUserName() {
        return getFirstName()+""+generateRandomNumber(100, 400);
    }

    public static int generateRandomNumber(int min, int max) {
        return (int) Math.round(Math.random()*(max-min)+min);
    }

    public static String getPassword(){
        return "P@ssword123"+generateRandomNumber(100, 500);
    }

    public static String getUserId() {
        return ""+generateRandomNumber(100, 9000);
    }

    public static String getStreetAddress() {
        return faker.address().streetAddress();
    }
    public static String getCity() {
        return faker.address().city();
    }

    public static String getState() {
        return faker.address().state();
    }

    public static String getZipCode() {
        return faker.address().zipCode();
    }

    public static String getCountry(){
        return faker.address().country();
    }

    public static String getEmail() {
        String firstName = getFirstName();
        String lastName = getLastName();
        return firstName+""+lastName+"@gmail.com";
    }
}
