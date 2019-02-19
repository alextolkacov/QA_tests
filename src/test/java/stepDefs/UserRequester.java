package stepDefs;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserRequester {
    private final String URL = "http://qaguru.lv:8089/getUsers.php";

    public List<User> requestUsers() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<User> users = new ArrayList<>();

//        users = mapper.readValue(URL, List.class);

        return users;
    }
}
