package UI;

import Services.AuthService;
import Services.ReservationService;
import Services.HotelService;
import Model.Reservation;
import Model.Hotel;
import Utils.RepositoryManager;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class ClientUI {
    private static ReservationService reservationService =   new ReservationService(
        RepositoryManager.getReservationRepository(), 
        RepositoryManager.getHotelRepository()
    );
    private static HotelService hotelService = new HotelService(RepositoryManager.getHotelRepository());

    public static void showClientMenu(Scanner scanner, AuthService authService) {
        System.out.println("\n=== MENU CLIENT ===");
        System.out.println("1. Voir tous les hôtels");
        System.out.println("2. Réserver une chambre");
        System.out.println("3. Annuler une réservation");
        System.out.println("4. Historique des réservations");
        System.out.println("5. Logout");
        System.out.print("Choix : ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                displayAllHotels();
                break;

            case "2":
                // Show available hotels first
                displayAllHotels();
                System.out.print("\nID hôtel pour la réservation : ");
                String hotelId = scanner.nextLine();
                System.out.print("Nombre de nuits : ");
                int nights = Integer.parseInt(scanner.nextLine());
                boolean reserved = reservationService.reserveRoom(hotelId, authService.getCurrentUser().getId(), nights);
                System.out.println(reserved ? "Réservation réussie." : "Erreur : hôtel indisponible ou données invalides.");
                break;

            case "3":
                System.out.print("ID réservation : ");
                UUID resId = UUID.fromString(scanner.nextLine());
                boolean cancelled = reservationService.cancelReservation(resId, authService.getCurrentUser().getId());
                System.out.println(cancelled ? "Annulée." : "Erreur.");
                break;

            case "4":
                List<Reservation> history = reservationService.getClientReservations(authService.getCurrentUser().getId());
                for (Reservation r : history) {
                    System.out.println(r.getId() + " | Hôtel: " + r.getHotelId() + " | Nuits: " + r.getNights());
                }
                break;

            case "5":
                authService.logout();
                break;

            default:
                System.out.println("Choix invalide.");
        }
    }

    private static void displayAllHotels() {
        System.out.println("\n=== HÔTELS DISPONIBLES ===");
        List<Hotel> hotels = hotelService.listHotels();
        
        if (hotels.isEmpty()) {
            System.out.println("Aucun hôtel disponible.");
            return;
        }
        
        System.out.printf("%-10s %-20s %-30s %-15s %-10s %-10s%n", 
                         "ID", "Nom", "Adresse", "Chambres Dispo", "Rating", "Statut");
        System.out.println("─".repeat(100));
        
        for (Hotel hotel : hotels) {
            String status = hotel.getAvailableRooms() > 0 ? "Disponible" : "Complet";
            System.out.printf("%-10s %-20s %-30s %-15d %-10.1f %-10s%n",
                             hotel.getHotelId(),
                             hotel.getName(),
                             hotel.getAddress(),
                             hotel.getAvailableRooms(),
                             hotel.getRating(),
                             status);
        }
        System.out.println("─".repeat(100));
    }
}
