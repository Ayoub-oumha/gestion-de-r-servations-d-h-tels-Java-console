package Services;
import Model.Hotel;
import Model.Reservation;
import Repositories.HotelRepository;
import Repositories.ReservationRepository;

import java.util.List;
import java.util.UUID;
public class ReservationService {
    private ReservationRepository reservationRepo;
    private HotelRepository hotelRepo;

    public ReservationService(ReservationRepository reservationRepo, HotelRepository hotelRepo) {
        this.reservationRepo = reservationRepo;
        this.hotelRepo = hotelRepo;
    }

    public boolean reserveRoom(String hotelId, UUID clientId, int nights) {
        Hotel hotel = hotelRepo.findById(hotelId);
        if (hotel == null || hotel.getAvailableRooms() <= 0 || nights <= 0) return false;

        hotel.setAvailableRooms(hotel.getAvailableRooms() - 1);
        hotelRepo.save(hotel);

        Reservation reservation = new Reservation(hotelId, clientId, nights);
        reservationRepo.save(reservation);
        return true;
    }

    public boolean cancelReservation(UUID reservationId, UUID clientId) {
        Reservation reservation = reservationRepo.findById(reservationId);
        if (reservation == null || !reservation.getClientId().equals(clientId)) return false;

        Hotel hotel = hotelRepo.findById(reservation.getHotelId());
        if (hotel != null) {
            hotel.setAvailableRooms(hotel.getAvailableRooms() + 1);
            hotelRepo.save(hotel);
        }

        reservationRepo.delete(reservationId);
        return true;
    }

    public List<Reservation> getClientReservations(UUID clientId) {
        return reservationRepo.findByClientId(clientId);
    }
}
