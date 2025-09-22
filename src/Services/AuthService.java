package Services;

import Model.Client;
import Model.Role;
import Repositories.ClientRepository;

public class AuthService {
    private final ClientRepository clientRepo;
    private Client currentUser;

    public AuthService(ClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }

    public boolean register(String name, String email, String password, Role role) {
        if (clientRepo.existsByEmail(email) || password.length() < 6 || email.isEmpty()) {
            return false;
        }
        Client client = new Client(name, email, password, role);
        clientRepo.save(client);
        return true;
    }

    public boolean login(String email, String password) {
        Client client = clientRepo.findByEmail(email);
        if (client != null && client.getPassword().equals(password)) {
            currentUser = client;
            return true;
        }
        return false;
    }

    public void logout() {
        currentUser = null;
    }

    public Client getCurrentUser() {
        return currentUser;
    }

    public boolean isAdmin() {
        return currentUser != null && currentUser.getRole() == Role.ADMIN;
    }
}
