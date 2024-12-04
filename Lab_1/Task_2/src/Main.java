
import java.util.*;
import java.util.stream.Collectors;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text;
        System.out.println("==== Text tool ====");
        System.out.println("Enter your text:");
        text = scanner.nextLine();

        System.out.println("\nOriginal Text:\n" + text);


        List<String> words = Arrays.stream(text.split("\\W+"))
                .filter(word -> !word.isBlank())
                .collect(Collectors.toList());


        System.out.println("\nEnter a letter to filter words starting with it:");
        char filterLetter = scanner.next().toLowerCase().charAt(0);

        List<String> filteredWords = words.stream()
                .filter(word -> word.toLowerCase().startsWith(String.valueOf(filterLetter)))
                .collect(Collectors.toList());


        List<String> sortedWords = words.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toList());


        long uniqueWordCount = words.stream()
                .map(String::toLowerCase)
                .distinct()
                .count();


        System.out.printf("\nFiltered Words (start with '%s'): \n%s \n", filterLetter, filteredWords);
        System.out.printf("\nSorted Words Alphabetically:\n%s \n", sortedWords);
        System.out.printf("\nNumber of Unique Words: \n%s \n", uniqueWordCount);
    }
}