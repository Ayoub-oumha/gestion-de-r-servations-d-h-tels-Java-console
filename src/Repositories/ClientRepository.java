package Repositories;

import Model.Client;

public interface ClientRepository {
    void save(Client client) ;
    Client findByEmail(String email) ;
    boolean existsByEmail(String email) ;

}
