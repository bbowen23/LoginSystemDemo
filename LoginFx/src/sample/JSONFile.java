package sample;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;

public class JSONFile {

    public static void save(ArrayList<User> users) {

        JSONArray userList = new JSONArray();

        if (users.size() > 0) {

            for (int x = 0; x < users.size(); x++) {

                JSONObject data = new JSONObject();
                data.put("username", users.get(x).getUsername());
                data.put("email", users.get(x).getEmail());
                data.put("name", users.get(x).getName());
                data.put("password", users.get(x).getPassword());
                data.put("salt", users.get(x).getSalt());

                userList.add(data);

            }

        }

        try {

            // NOTE: This is hardwired because IntelliJ is very unIntelliJent at finding files within projects.
            FileWriter file = new FileWriter("C:/Users/benja/IdeaProjects/LoginFx/src/sample/users.json");
            file.write(userList.toString());
            file.close();

        } catch(IOException ex) {
            ex.printStackTrace();
        }

    }

    public static ArrayList<User> load() {

        JSONParser parser = new JSONParser();
        ArrayList<User> _users = new ArrayList<>();

        try {

            // NOTE: This is hardwired because IntelliJ is very unIntelliJent at finding files within projects.
            FileReader file = new FileReader("C:/Users/benja/IdeaProjects/LoginFx/src/sample/users.json");

            Object data = parser.parse(file);
            JSONArray dataList = (JSONArray) data;

            for (int x = 0; x < dataList.size(); x++) {

                User user = new User();
                JSONObject record = (JSONObject) dataList.get(x);

                user.setUsername(record.get("username").toString());
                user.setEmail(record.get("email").toString());
                user.setName(record.get("name").toString());
                user.setPassword(record.get("password").toString());
                user.setSalt(record.get("salt").toString());

                _users.add(user);

            }

            return _users;

        } catch (IOException | ParseException ex) {

            ex.printStackTrace();
            return null;

        }

    }

}
