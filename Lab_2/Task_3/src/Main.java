import java.util.*;

public class Main {
    public static void main(String[] args) {
        Library<Media> library = new Library<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Media");
            System.out.println("2. Remove Media");
            System.out.println("3. Search Media");
            System.out.println("4. Display All Media");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": {
                    while (true) {
                        System.out.println("\nWhat type of media to add?");
                        System.out.println("1. Book");
                        System.out.println("2. Magazine");
                        System.out.println("3. DVD");
                        System.out.println("4. Back to main menu");
                        System.out.print("Enter your choice: ");
                        String type = scanner.nextLine();

                        switch (type) {
                            case "1": {
                                System.out.print("Enter book title: ");
                                String title = scanner.nextLine();
                                System.out.print("Enter book ID: ");
                                String id = scanner.nextLine();
                                System.out.print("Enter author: ");
                                String author = scanner.nextLine();
                                library.addMedia(new Book(title, id, author));
                                continue;
                            }
                            case "2": {
                                System.out.print("Enter magazine title: ");
                                String title = scanner.nextLine();
                                System.out.print("Enter magazine ID: ");
                                String id = scanner.nextLine();
                                System.out.print("Enter issue: ");
                                String issue = scanner.nextLine();
                                library.addMedia(new Magazine(title, id, issue));
                                continue;
                            }
                            case "3": {
                                System.out.print("Enter DVD title: ");
                                String title = scanner.nextLine();
                                System.out.print("Enter DVD ID: ");
                                String id = scanner.nextLine();
                                System.out.print("Enter director: ");
                                String director = scanner.nextLine();
                                library.addMedia(new DVD(title, id, director));
                                continue;
                            }
                            case "4": {
                                break;
                            }
                            default: {
                                System.out.println("Invalid input.");
                                continue;
                            }
                        }
                        break;
                    }
                    break;
                }
                case "2": {
                    System.out.println("Remove by:");
                    System.out.println("1. Keyword");
                    System.out.println("2. ID");
                    System.out.print("Enter your choice: ");
                    String type = scanner.nextLine();

                    switch (type) {
                        case "1": {
                            System.out.print("Enter media keyword to remove: ");
                            String keyword = scanner.nextLine();
                            library.removeMediaByTitle(keyword);
                            break;
                        }
                        case "2": {
                            System.out.print("Enter media ID to remove: ");
                            String id = scanner.nextLine();
                            library.removeMediaByID(id);
                            break;
                        }
                        default: {
                            System.out.println("Invalid input");
                            break;
                        }
                    }
                    break;
                }

                case "3": {
                    System.out.println("Search by: ");
                    System.out.println("1. Keyword");
                    System.out.println("2. ID");
                    System.out.print("Enter your choice: ");
                    String type = scanner.nextLine();

                    switch (type) {
                        case "1": {
                            System.out.print("Enter search keyword: ");
                            String keyword = scanner.nextLine();
                            List<Media> results = library.searchMediaByTitle(keyword);
                            if (results.isEmpty()) {
                                System.out.println("No media found.");
                            }
                            else {
                                System.out.println("Media found:");
                                results.forEach(System.out::println);
                            }
                            break;
                        }
                        case "2": {
                            System.out.print("Enter search ID: ");
                            String searchID = scanner.nextLine();
                            List<Media> results = library.searchMediaByID(searchID);
                            if (results.isEmpty()) {
                                System.out.println("No media found.");
                            }
                            else {
                                System.out.println("Media found:");
                                results.forEach(System.out::println);
                            }
                            break;
                        }
                        default: {
                            System.out.println("Invalid input");
                            break;
                        }
                    }
                    break;
                }
                case "4": {
                    library.displayAll();
                    break;
                }
                case "5": {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default: {
                    System.out.println("Invalid input.");
                }
            }
        }
    }
}
