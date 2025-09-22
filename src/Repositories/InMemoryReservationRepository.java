package Repositories;
import Model.Reservation;
import java.util.*;
public class InMemoryReservationRepository implements   ReservationRepository {
    private Map<UUID, Reservation> reservations = new HashMap<>();

    @Override
    public void save(Reservation reservation) {
        reservations.put(reservation.getId(), reservation);
    }

    @Override
    public void delete(UUID reservationId) {
        reservations.remove(reservationId);
    }

    @Override
    public List<Reservation> findByClientId(UUID clientId) {
        List<Reservation> result = new ArrayList<>();
        for (Reservation r : reservations.values()) {
            if (r.getClientId().equals(clientId)) {
                result.add(r);
            }
        }
        result.sort(Comparator.comparing(Reservation::getTimestamp));
        return result;
    }

    @Override
    public Reservation findById(UUID reservationId) {
        return reservations.get(reservationId);
    }
}
