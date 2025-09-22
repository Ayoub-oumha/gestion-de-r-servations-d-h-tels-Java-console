package Repositories;

import Model.Hotel;

import java.util.List;

public interface HotelRepository {
    void save(Hotel hotel);
    Hotel findById(String hotelId);
    List<Hotel> findAll();
    void delete(String hotelId);
    boolean exists(String hotelId);
}
