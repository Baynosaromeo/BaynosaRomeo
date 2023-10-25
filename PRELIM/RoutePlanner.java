import java.util.*;

public class RoutePlanner {
    private static Map<String, Map<String, Integer>> graph = new HashMap<>();

    public static void main(String[] args) {
        // Build the graph with route connections and distances.
        buildGraph();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Starting from Cebu City.");

        // Check if the Default Route is obstructed.
        System.out.print("Is the Default Route obstructed? (yes/no): ");
        String isDefaultRouteObstructed = scanner.nextLine().toLowerCase();

        if (isDefaultRouteObstructed.equals("yes")) {
            // Find the best/optimum route.
            List<String> bestRoute = findBestRoute();

            if (bestRoute != null) {
                System.out.println("The best/optimum route to Moalboal is:");
                for (String location : bestRoute) {
                    System.out.print(location + " -> ");
                }
                System.out.println("Moalboal (End)");
            } else {
                System.out.println("No alternative route available. You cannot proceed to Moalboal.");
            }
        } else {
            System.out.println("You can proceed to Moalboal via the Default Route.");
        }

        scanner.close();
    }

    private static void buildGraph() {
        addRoute("Cebu City", "Minglanilla", 10);
        addRoute("Minglanilla", "San Fernando", 15);
        addRoute("San Fernando", "Carcar", 12);
        addRoute("Carcar", "Barili", 20);
        addRoute("Barili", "Dumanjug", 15);
        addRoute("Dumanjug", "Alcantara", 10);
        addRoute("Alcantara", "Moalboal", 5);
        addRoute("Barili", "Sibonga", 18);
        addRoute("Dumanjug", "Alcantara", 12);
        addRoute("Sibonga", "Moalboal", 8);
        addRoute("Dumanjug", "Moalboal", 14);
        addRoute("Argao", "Ronda", 20);
        addRoute("Ronda", "Alcantara", 10);
        addRoute("Alcantara", "Moalboal", 5);
    }

    private static void addRoute(String source, String destination, int distance) {
        graph.computeIfAbsent(source, k -> new HashMap<>()).put(destination, distance);
        graph.computeIfAbsent(destination, k -> new HashMap<>()).put(source, distance); // Bidirectional
    }

    private static List<String> findBestRoute() {
        String start = "Cebu City";
        String end = "Moalboal";

        Map<String, Integer> distance = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        Set<String> visited = new HashSet<>();

        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distance::get));

        distance.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.equals(end)) {
                return reconstructPath(previous, current);
            }

            if (visited.contains(current)) {
                continue;
            }

            visited.add(current);

            for (Map.Entry<String, Integer> neighbor : graph.get(current).entrySet()) {
                String neighborNode = neighbor.getKey();
                int weight = neighbor.getValue();

                if (!visited.contains(neighborNode)) {
                    int alt = distance.get(current) + weight;
                    if (alt < distance.getOrDefault(neighborNode, Integer.MAX_VALUE)) {
                        distance.put(neighborNode, alt);
                        previous.put(neighborNode, current);
                        queue.add(neighborNode);
                    }
                }
            }
        }

        return null; // No path found
    }

    private static List<String> reconstructPath(Map<String, String> previous, String current) {
        List<String> path = new ArrayList<>();
        while (current != null) {
            path.add(current);
            current = previous.get(current);
        }
        Collections.reverse(path);
        return path;
    }
}
