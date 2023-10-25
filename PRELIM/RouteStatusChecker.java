import java.util.Scanner;

public class RouteStatusChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Starting from Cebu City.");
        System.out.print("Is Route 4 (Barili) obstructed? (yes/no): ");
        String route4Obstructed = scanner.nextLine().toLowerCase();

        if (route4Obstructed.equals("yes")) {
            System.out.print("Is Route 4 1.1 (Dumanjug) obstructed? (yes/no): ");
            String route4_1_1Obstructed = scanner.nextLine().toLowerCase();

            if (route4_1_1Obstructed.equals("yes")) {
                System.out.println("You cannot proceed to Moalboal via Route 4.");
            } else {
                System.out.print("Is Route 4 2.2 (Alcantara) obstructed? (yes/no): ");
                String route4_2_2Obstructed = scanner.nextLine().toLowerCase();

                if (route4_2_2Obstructed.equals("yes")) {
                    System.out.println("You cannot proceed to Moalboal via Route 4.");
                } else {
                    System.out.println("You can proceed to Moalboal via the default Route 4:");
                    System.out.println("Cebu City (Start) -> Minglanilla (Route 1) -> San Fernando (Route 2) -> Carcar (Route 3) -> Barili (Route 4) -> Dumanjug (Route 4.1) -> Alcantara (Route 4 1.1) -> Moalboal (End)");
                }
            }
        } else {
            System.out.print("Is Route 5 (Argao) obstructed? (yes/no): ");
            String route5Obstructed = scanner.nextLine().toLowerCase();

            if (route5Obstructed.equals("yes")) {
                System.out.print("Is Route 5.1 (Ronda) obstructed? (yes/no): ");
                String route5_1Obstructed = scanner.nextLine().toLowerCase();

                if (route5_1Obstructed.equals("yes")) {
                    System.out.println("You cannot proceed to Moalboal via Route 5.");
                } else {
                    System.out.print("Is Route 5.2 (Alcantara) obstructed? (yes/no): ");
                    String route5_2Obstructed = scanner.nextLine().toLowerCase();

                    if (route5_2Obstructed.equals("yes")) {
                        System.out.println("You cannot proceed to Moalboal via Route 5.");
                    } else {
                        System.out.println("You can proceed to Moalboal via the default Route 5:");
                        System.out.println("Cebu City (Start) -> Minglanilla (Route 1)" );                         System.out.println("San Fernando (Route 2)" );
                        System.out.println(" Carcar (Route 3) ");
                        System.out.println("Argao (Route 5) ");
                        System.out.println("Ronda (Route 5.1) ");
                        System.out.println("Alcantara (Route 5.2)" );
                }       System.out.println(" Moalboal (End) ");
                }
            } else {
                System.out.println("You can proceed to Moalboal via the default route:");
                System.out.println("Cebu City (Start) -> Minglanilla (Route 1) -> San Fernando (Route 2) -> Carcar (Route 3) -> Argao (Route 5) -> Moalboal (End)");
            }
        }

        scanner.close();
    }
}
