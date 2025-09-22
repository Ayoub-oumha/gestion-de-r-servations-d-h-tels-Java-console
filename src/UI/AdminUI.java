package UI;

import Services.AuthService;
import Services.HotelService;
import Model.Hotel;
import Utils.RepositoryManager;
import java.util.Scanner;

public class AdminUI {
    private static HotelService hotelService = new HotelService(RepositoryManager.getHotelRepository());

    public static void showAdminMenu(Scanner scanner, AuthService authService) {
        System.out.println("\n=== MENU ADMIN ===");
        System.out.println("1. Créer hôtel");
        System.out.println("2. Modifier hôtel");
        System.out.println("3. Supprimer hôtel");
        System.out.println("4. Lister hôtels");
        System.out.println("5. Logout");
        System.out.print("Choix : ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.print("ID hôtel : ");
                String id = scanner.nextLine();
                System.out.print("Nom : ");
                String name = scanner.nextLine();
                System.out.print("Adresse : ");
                String address = scanner.nextLine();
                System.out.print("Chambres disponibles : ");
                int rooms = Integer.parseInt(scanner.nextLine());
                System.out.print("Note : ");
                double rating = Double.parseDouble(scanner.nextLine());
                boolean created = hotelService.createHotel(id, name, address, rooms, rating);
                System.out.println(created ? "Hôtel créé." : "Erreur : ID existant ou données invalides.");
                break;

            case "2":
                // idem pour modifier
                break;

            case "3":
                // idem pour supprimer
                break;

            case "4":
                for (Hotel h : hotelService.listHotels()) {
                    System.out.println(h.getHotelId() + " | " + h.getName() + " | " + h.getAddress());
                }
                break;

            case "5":
                authService.logout();
                break;

            default:
                System.out.println("Choix invalide.");
        }
    }
}
