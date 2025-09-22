package Repositories;

import Model.Hotel;

import java.util.*;

public class InMemoryHotelRepository implements HotelRepository {
    private Map<String, Hotel> hotels = new HashMap<>();

    @Override
    public void save(Hotel hotel) {
        hotels.put(hotel.getHotelId(), hotel);
    }

    @Override
    public Hotel findById(String hotelId) {
        return hotels.get(hotelId);
    }

    @Override
    public List<Hotel> findAll() {
        return new ArrayList<>(hotels.values());
    }

    @Override
    public void delete(String hotelId) {
        hotels.remove(hotelId);
    }

    @Override
    public boolean exists(String hotelId) {
        return hotels.containsKey(hotelId);
    }
}
