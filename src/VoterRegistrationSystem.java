package voterregistration;

import java.util.*;

public class VoterRegistrationSystem {

    private static HashSet<Voter> voterSet = new HashSet<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== UNIQUE VOTER REGISTRATION SYSTEM ===");
            System.out.println("1. Register Voter");
            System.out.println("2. View All Voters");
            System.out.println("3. Search Voter By ID");
            System.out.println("4. Delete Voter");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    registerVoter();
                    break;

                case 2:
                    viewVoters();
                    break;

                case 3:
                    searchVoter();
                    break;

                case 4:
                    deleteVoter();
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void registerVoter() {
        System.out.print("Enter Voter ID: ");
        String voterId = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        if (age < 18) {
            System.out.println("Registration failed. Age must be 18 or above.");
            return;
        }

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        Voter v = new Voter(voterId, name, age, address);

        boolean added = voterSet.add(v);

        if (added) {
            System.out.println("Voter registered successfully.");
        } else {
            System.out.println("Duplicate entry! Voter already registered.");
        }
    }

    private static void viewVoters() {
        if (voterSet.isEmpty()) {
            System.out.println("No voters registered.");
            return;
        }

        System.out.println("\n--- REGISTERED VOTERS ---");
        for (Voter v : voterSet) {
            System.out.println(v);
        }
    }

    private static void searchVoter() {
        System.out.print("Enter Voter ID to search: ");
        String searchId = sc.nextLine();

        for (Voter v : voterSet) {
            if (v.getVoterId().equals(searchId)) {
                System.out.println("Voter found: " + v);
                return;
            }
        }
        System.out.println("Voter not found.");
    }

    private static void deleteVoter() {
        System.out.print("Enter Voter ID to delete: ");
        String deleteId = sc.nextLine();

        Iterator<Voter> it = voterSet.iterator();
        while (it.hasNext()) {
            Voter v = it.next();
            if (v.getVoterId().equals(deleteId)) {
                it.remove();
                System.out.println("Voter deleted successfully.");
                return;
            }
        }

        System.out.println("Voter not found.");
    }
}
