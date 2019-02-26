package stepDefs;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Response;
import model.User;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserRequester {
    private final String URL = "http://qaguru.lv:8089/getUsers.php";

    public List<User> requestUsers() throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForEntity(URL, String.class).getBody();

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response, List.class);
    }
}
