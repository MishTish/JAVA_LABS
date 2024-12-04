package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("Enter your text:");
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        boolean loop = true;
        while (loop)
        {
            System.out.println("Choose operation:");
            System.out.println("1. Search");
            System.out.println("2. Replace");
            System.out.println("3. Count");
            System.out.println("4. View text");
            System.out.println("5. Enter new text");
            System.out.println("6. Exit");
            System.out.print("> ");
            String selection = scanner.nextLine();
            switch (selection) {
                case "1": {

                    Searchable LambdaSearch = (s, q) -> s.contains(q);

                    System.out.println("Enter text to be searched: ");
                    System.out.print("> ");
                    String query = scanner.nextLine();
                    boolean found = LambdaSearch.textSearch(text, query);
                    System.out.printf("Search result: '" + query + (found ?  "' Found \n" : "' Not Found \n"));
                    break;
                }
                case "2": {

                    Replaceable LambdaReplace = (s, from, to) -> s.replace(from, to);

                    System.out.println("replace: ");
                    System.out.print("> ");
                    String from = scanner.nextLine();
                    System.out.println("with: ");
                    System.out.print("> ");
                    String to = scanner.nextLine();
                    text = LambdaReplace.textReplace(text, from, to);
                    System.out.printf("Replace result: %s", text);
                    break;
                }
                case "3": {

                    Countable LambdaCount = (s, c) -> {
                        int result = 0;
                        int index = 0;
                        while ((index = s.indexOf(c, index)) != -1) {
                            result++;
                            index += c.length();
                        }
                        return result;
                    };

                    System.out.println("Enter text to count: ");
                    System.out.print("> ");
                    String count = scanner.nextLine();
                    int countResult = LambdaCount.textCount(text, count);
                    System.out.printf("Count result: '%s' appears %d time(s) \n", count, countResult);
                    break;
                }
                case "4": {
                    System.out.println("Your text: ");
                    System.out.println(text);
                    break;
                }

                case "5": {
                    System.out.println("Enter new text: ");
                    text = scanner.nextLine();
                    break;
                }
                case "6": {
                    loop = false;
                    break;
                }
                default: {
                    System.out.println("Invalid choice");
                    break;
                }
            }
        }

    }
}