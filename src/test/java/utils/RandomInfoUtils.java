package utils;

import com.github.javafaker.Faker;

public class RandomInfoUtils {
    private RandomInfoUtils() {

    }

    public static String getFirstName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }
    public static String getLastName() {
        Faker faker = new Faker();
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
        return ""+generateRandomNumber(100, 500);
    }
}
