package Utils;

import Repositories.*;

public class RepositoryManager {
    private static InMemoryHotelRepository hotelRepository = new InMemoryHotelRepository();
    private static InMemoryReservationRepository reservationRepository = new InMemoryReservationRepository();
    private static InMemoryClientRepository clientRepository = new InMemoryClientRepository();
    
    public static InMemoryHotelRepository getHotelRepository() {
        return hotelRepository;
    }
    
    public static InMemoryReservationRepository getReservationRepository() {
        return reservationRepository;
    }
    
    public static InMemoryClientRepository getClientRepository() {
        return clientRepository;
    }
}