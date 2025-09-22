package Repositories;
import Model.Reservation;
import java.util.List;
import java.util.UUID;
public interface ReservationRepository {
    void save(Reservation reservation);
    void delete(UUID reservationId);
    List<Reservation> findByClientId(UUID clientId);
    Reservation findById(UUID reservationId);
}
