package com.example.app;

import com.example.model.Person;
import com.example.service.PersonService;

import java.util.*;


public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {


        PersonService personService = new PersonService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n== Person Manager ==");
            System.out.println("1. Add a new Person");
            System.out.println("2. Delete by ID");
            System.out.println("3. Search by ID");
            System.out.println("4. Show all persons");
            System.out.println("5. Exit");
            System.out.println();
            System.out.println("-- Enter your choice: ");
            System.out.print("> ");

            String selector = scanner.next();

            switch (selector) {
                case "1":
                    System.out.println("-- Enter ID of the new person: ");
                    System.out.print("> ");
                    int id = 0;
                    while (true) {
                        try {
                            id = scanner.nextInt();
                            break;
                        }
                        catch (InputMismatchException e) {
                            System.out.println(ANSI_RED + "Invalid input" + ANSI_RESET);
                            System.out.println("Enter ID: ");
                            System.out.print("> ");
                            if (scanner.next().isEmpty()) {
                                break;
                            }
                        }
                    }
                    scanner.nextLine();
                    System.out.println("-- Enter name of the new person: ");
                    System.out.print("> ");
                    String name = scanner.nextLine();

                    System.out.println("-- Enter age of the new person: ");
                    System.out.print("> ");
                    int age = 0;
                    while (true) {
                        try {
                            age = scanner.nextInt();
                            break;
                        }
                        catch (InputMismatchException e) {
                            System.out.println(ANSI_RED + "Invalid input" + ANSI_RESET);
                            System.out.print("Enter Age: ");
                            if (scanner.next().isEmpty()) {
                                break;
                            }
                        }
                    }
                    Person newPerson = new Person(id, name, age);
                    personService.addPerson(newPerson);
                    System.out.println("-- Person " + newPerson + " added successfully.");
                    break;
                case "2":
                    System.out.println("-- Enter ID to delete: ");
                    System.out.print("> ");
                    int deleteId = 0;
                    while (true) {
                        try {
                            deleteId = scanner.nextInt();
                            break;
                        }
                        catch (InputMismatchException e) {
                            System.out.println(ANSI_RED + "Invalid input" + ANSI_RESET);
                            System.out.println("-- Enter ID to delete: ");
                            System.out.print("> ");
                            if (scanner.next().isEmpty()) {
                                break;
                            }
                        }
                    }
                    if (personService.deletePersonById(deleteId)) {
                        System.out.println("-- Person with ID: " + deleteId + " deleted successfully.");
                    } else {
                        System.out.println("-- Person with ID: " + deleteId + " not found.");
                    }
                    break;
                case "3":
                    System.out.println("-- Enter ID to search: ");
                    System.out.print("> ");
                    int searchId = 0;
                    while (true) {
                        try {
                            searchId = scanner.nextInt();
                            break;
                        }
                        catch (InputMismatchException e) {
                            System.out.println(ANSI_RED + "Invalid input" + ANSI_RESET);
                            System.out.println("-- Enter ID to search: ");
                            System.out.print("> ");
                            if (scanner.next().isEmpty()) {
                                break;
                            }
                        }
                    }
                    Person person = personService.searchPersonById(searchId);
                    if (person != null) {
                        System.out.println("-- Person with ID: " + searchId + " found: " + person);
                    } else {
                        System.out.println("-- Person with ID: " + searchId + " not found.");
                    }
                    break;
                case "4":
                    System.out.println("-- Person list:");
                    List<Person> persons = personService.getAllPersons();
                    if (persons.isEmpty())
                    {
                        System.out.println("Empty.");
                        break;
                    }
                    else
                    {
                        persons.sort(Comparator.comparing(Person::getId));
                        persons.forEach(System.out::println);
                        break;
                    }

                case "5":
                    System.out.println("-- Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println(ANSI_RED + "Invalid input" + ANSI_RESET);
            }
        }
    }
}
