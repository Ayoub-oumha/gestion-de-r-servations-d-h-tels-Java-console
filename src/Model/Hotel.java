package Model;

public class Hotel {
    private String hotelId;
    private String name;
    private String address;
    private int availableRooms;
    private double rating;

    //  Getter et Setter pour hotelId
    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    //  Getter et Setter pour name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //  Getter et Setter pour address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //  Getter et Setter pour availableRooms
    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    //  Getter et Setter pour rating
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Hotel(String hotelId, String name, String address, int availableRooms, double rating) {
        this.hotelId = hotelId;
        this.name = name;
        this.address = address;
        this.availableRooms = availableRooms;
        this.rating = rating;
    }
}
