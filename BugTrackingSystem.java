import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Bug {
    private int id;
    private String description;
    private boolean resolved;

    public Bug(int id, String description) {
        this.id = id;
        this.description = description;
        this.resolved = false;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void resolve() {
        resolved = true;
    }

    @Override
    public String toString() {
        return "Bug #" + id + " - " + description + " (Resolved: " + resolved + ")";
    }
}

public class BugTrackingSystem {
    private List<Bug> bugs;
    private int nextBugId;

    public BugTrackingSystem() {
        bugs = new ArrayList<>();
        nextBugId = 1;
    }

    public void addBug(String description) {
        Bug bug = new Bug(nextBugId++, description);
        bugs.add(bug);
        System.out.println("Bug added: " + bug);
    }

    public void resolveBug(int bugId) {
        for (Bug bug : bugs) {
            if (bug.getId() == bugId) {
                bug.resolve();
                System.out.println("Bug resolved: " + bug);
                return;
            }
        }
        System.out.println("Bug not found with ID #" + bugId);
    }

    public void listBugs() {
        System.out.println("List of Bugs:");
        for (Bug bug : bugs) {
            System.out.println(bug);
        }
    }

    public static void main(String[] args) {
        BugTrackingSystem bugTrackingSystem = new BugTrackingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Bug\n2. Resolve Bug\n3. List Bugs\n4. Quit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Enter bug description:");
                    String description = scanner.nextLine();
                    bugTrackingSystem.addBug(description);
                    break;
                case 2:
                    System.out.println("Enter bug ID to resolve:");
                    int bugId = scanner.nextInt();
                    bugTrackingSystem.resolveBug(bugId);
                    break;
                case 3:
                    bugTrackingSystem.listBugs();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
