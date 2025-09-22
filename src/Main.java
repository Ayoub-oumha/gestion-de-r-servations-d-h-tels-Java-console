

import Services.AuthService;
import Utils.RepositoryManager;
import UI.AdminUI;
import UI.AuthUI;
import UI.ClientUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthService(RepositoryManager.getClientRepository());

        while (true) {
            if (authService.getCurrentUser() == null) {
                AuthUI.showAuthMenu(scanner, authService);
            } else if (authService.isAdmin()) {
                AdminUI.showAdminMenu(scanner, authService);
            } else {
                ClientUI.showClientMenu(scanner, authService);
            }
        }
    }
}
