package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    private ConfigReader() {

    }

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("./src/main/resources/config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static String getUrl(){
        return properties.getProperty("baseUrl");
    }

    public static int getTimeOuts(){
        return Integer.parseInt(properties.getProperty("timeouts"));
    }

    public static String getBrowserMode(){
        return properties.getProperty("browser_mode");
    }
}
