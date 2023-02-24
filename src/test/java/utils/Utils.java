package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static void doScroll(WebDriver driver, int heightPixel) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollBy(0, "+heightPixel+")");
    }

    public static JSONObject loadJsonFile(String fileLocation){
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            Object obj = jsonParser.parse(new FileReader(fileLocation));
            jsonObject = (JSONObject) obj;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return jsonObject;
    }
    public static int generateRandomNumber(int min, int max) {
        return (int) Math.round(Math.random()*(max-min)+min);
    }

    public static JSONArray getJsonArray(String fileLocation) {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = null;

        try {
            Object obj = jsonParser.parse(new FileReader(fileLocation));
            jsonArray = (JSONArray) obj;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jsonArray;
    }

    public static JSONObject getJsonObjFromJsonArray(String fileLocation, int idx){
        JSONArray jsonArray = getJsonArray(fileLocation);
        JSONObject jsonObj = (JSONObject) jsonArray.get(idx);
        return jsonObj;
    }

    public static String getProperty(String fileLocation, int idx, String propertyName){
        JSONObject jsonObj = getJsonObjFromJsonArray(fileLocation, idx);
        String property = (String) jsonObj.get(propertyName);
        return property;
    }

    public static void updateProperty(String fileLocation, int idx, String propertyName, String propertyVal){
        JSONArray arr = getJsonArray(fileLocation);
        JSONObject obj = (JSONObject) arr.get(idx);
        obj.put(propertyName, propertyVal);
        try {
            FileWriter file = new FileWriter(fileLocation);
            file.write(arr.toJSONString());
            file.flush();
            file.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Successfully updated");
    }


    public static void addJsonArray(String firstName, String lastName, String username, String password) {
        String fileName = "./src/test/resources/NewUser.json";
        JSONParser jsonParser = new JSONParser();
        JSONObject userObj;
        JSONArray jsonArray;
        try {
            Object obj = jsonParser.parse(new FileReader(fileName));
            userObj = new JSONObject();
            jsonArray = (JSONArray) obj;


            userObj.put("firstname", firstName);
            userObj.put("lastname", lastName);
            userObj.put("username", username);
            userObj.put("password", password);

            jsonArray.add(userObj);

            FileWriter file = new FileWriter(fileName);
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        String id = ""+generateRandomNumber(1000, 5000);
        updateProperty("./src/test/resources/NewUser.json", 0, "userid", id);
    }
}
