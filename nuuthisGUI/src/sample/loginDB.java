package sample;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.io.*;


public class loginDB {

    static String username;
    static String password;

    static Map<String, String> userPass = new HashMap<String, String>();
    static Properties properties = new Properties();

    public static void getData() throws IOException {
        properties.load(new FileInputStream("data.properties"));
        for (String key : properties.stringPropertyNames()) {
            userPass.put(key, properties.get(key).toString());
        }
    }

    public static void saveData() throws IOException {
        properties.putAll(userPass);
        properties.store(new FileOutputStream("data.properties"), null);
    }

    public static boolean checkKey(String string) {
        return (userPass.containsKey(string));
    }

    public static void setUsername(String username1) {
        username = username1;
    }
    public static void setPassword(String password1) {
        password = password1;
    }

    public static void putInfo() throws IOException {
        userPass.put(username, password);
        saveData();
        System.out.println(userPass);
    }

    public boolean checkCreds(String user, String pass) {
        if (userPass.containsKey(user)) {
            if (userPass.get(user).equals(pass)) {
                // login success
                //return boolean value to tell gui
                //to go to menu
                return true;
            } else {
                //password wrong, throw error
                return false;
            }
        } else {
            //username wrong, throw error
            return false;
        }
    }

}

