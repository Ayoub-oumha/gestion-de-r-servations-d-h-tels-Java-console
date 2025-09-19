package Model;

public class Reservation {
    private int id;
    private String timestamp;  // ou LocalDateTime si tu veux un vrai type date/heure
    private int hotelId;
    private int clientId;
    private int nights;

    //  Getter et Setter pour id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //  Getter et Setter pour timestamp
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    //  Getter et Setter pour hotelId
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    //  Getter et Setter pour clientId
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    //  Getter et Setter pour nights
    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }
}
