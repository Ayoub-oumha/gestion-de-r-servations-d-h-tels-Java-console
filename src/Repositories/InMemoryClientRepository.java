package Repositories;

import Model.Client;

import java.util.HashMap;
import java.util.Map;

public class InMemoryClientRepository implements   ClientRepository {
    private Map<String, Client> clients = new HashMap<>();

    @Override
    public void save(Client client) {
        clients.put(client.getEmail(), client);
    }

    @Override
    public Client findByEmail(String email) {
        return clients.get(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        return clients.containsKey(email);
    }
}
