package UI;

import Services.AuthService;
import Model.Role;
import java.util.Scanner;

public class AuthUI {
    public static void showAuthMenu(Scanner scanner, AuthService authService) {
        System.out.println("\n=== MENU NON CONNECTÉ ===");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Choix : ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.print("Nom : ");
                String name = scanner.nextLine();
                System.out.print("Email : ");
                String email = scanner.nextLine();
                System.out.print("Mot de passe : ");
                String password = scanner.nextLine();
                System.out.print("Rôle (ADMIN/CLIENT) : ");
                String roleInput = scanner.nextLine().toUpperCase();
                Role role = roleInput.equals("ADMIN") ? Role.ADMIN : Role.CLIENT;

                boolean registered = authService.register(name, email, password, role);
                System.out.println(registered ? "Inscription réussie." : "Échec : email existant ou mot de passe invalide.");
                break;

            case "2":
                System.out.print("Email : ");
                String loginEmail = scanner.nextLine();
                System.out.print("Mot de passe : ");
                String loginPassword = scanner.nextLine();
                boolean loggedIn = authService.login(loginEmail, loginPassword);
                System.out.println(loggedIn ? "Connexion réussie." : "Échec de connexion.");
                break;

            case "3":
                System.out.println("Application terminée.");
                System.exit(0);
                break;

            default:
                System.out.println("Choix invalide.");
        }
    }
}
