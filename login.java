import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.io.*;

public class login {

    String username;
    String password;

    static Map<String, String> userPass = new HashMap<String, String>();
    Properties properties = new Properties();

    void getData() throws IOException {
        properties.load(new FileInputStream("data.properties"));
        for (String key : properties.stringPropertyNames()) {
            userPass.put(key, properties.get(key).toString());
        }
    }

    void saveData() throws IOException {
        properties.putAll(userPass);
        properties.store(new FileOutputStream("data.properties"), null);
    }

    public boolean checkKey(String string) {
        return (userPass.containsKey(string));
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void putInfo() throws IOException {
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
