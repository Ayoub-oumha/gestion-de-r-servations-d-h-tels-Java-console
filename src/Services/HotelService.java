package Services;
import Model.Hotel;
import Repositories.HotelRepository;
import java.util.List;
public class HotelService {
    private HotelRepository hotelRepo;

    public HotelService(HotelRepository hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    public boolean createHotel(String id, String name, String address, int rooms, double rating) {
        if (rooms <= 0 || rating < 0 || hotelRepo.exists(id)) return false;
        Hotel hotel = new Hotel(id, name, address, rooms, rating);
        hotelRepo.save(hotel);
        return true;
    }

    public List<Hotel> listHotels() {
        return hotelRepo.findAll();
    }

    public boolean updateHotel(String id, String name, String address, int rooms) {
        Hotel hotel = hotelRepo.findById(id);
        if (hotel == null || rooms < 0) return false;
        hotel.setName(name);
        hotel.setAddress(address);
        hotel.setAvailableRooms(rooms);
        hotelRepo.save(hotel);
        return true;
    }

    public boolean deleteHotel(String id) {
        if (!hotelRepo.exists(id)) return false;
        hotelRepo.delete(id);
        return true;
    }
}
