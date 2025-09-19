package Model;

public class Hotel {
    private int hotelId;
    private String name;
    private String address;
    private int availableRooms;
    private double rating;

    //  Getter et Setter pour hotelId
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
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
}
