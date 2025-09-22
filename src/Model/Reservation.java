package Model;

import java.time.Instant;
import java.util.UUID;

public class Reservation {
    private UUID id;
    private Instant timestamp;
    private String hotelId;
    private UUID clientId;
    private int nights;

    public Reservation(String hotelId, UUID clientId, int nights) {
        this.id = UUID.randomUUID();
        this.timestamp = Instant.now();
        this.hotelId = hotelId;
        this.clientId = clientId;
        this.nights = nights;
    }

    public UUID getId() { return id; }
    public Instant getTimestamp() { return timestamp; }
    public String getHotelId() { return hotelId; }
    public UUID getClientId() { return clientId; }
    public int getNights() { return nights; }
}
