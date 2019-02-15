package mappers;

import model.Client;

import java.util.Map;

public class ClientMapper {
    public Client mapClient(Map<String, String> params) {
        Client client = new Client();

        client.setAge(Integer.valueOf(params.get("age")));
        client.setIin(params.get("iin"));
        client.setMail(params.get("mail"));
        client.setPhone(params.get("phone"));
        client.setName(params.get("name"));

        return client;
    }
}
