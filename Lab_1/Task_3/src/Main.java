import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User(1, "Alice", 30));
        users.add(new User(2, "Charlie", 27));
        users.add(new User(3, "Fred", 23));
        users.add(new User(5, "John", 26));
        users.add(new User(8, "Michael", 30));


        // for testing purposes
        List<Integer> searchIDs = new LinkedList<>();
        for (int i = 0; i < 11; i++) {
            searchIDs.add(i);
        }

        searchIDs.forEach(searchID -> {
            Optional<User> foundUser = UserFinder.FindUserByID(users, searchID);
            foundUser.ifPresentOrElse(
                    user -> System.out.printf("\n User with id: %d :: found. name: %s, age: %d", searchID, user.getName(), user.getAge()),
                    () -> System.out.printf("\n User with id: %d :: not found.", searchID));
        });
    }
}