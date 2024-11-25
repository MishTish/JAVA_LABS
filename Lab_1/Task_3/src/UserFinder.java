
import java.util.List;
import java.util.Optional;



public class UserFinder {

    public static Optional<User> FindUserByID(List<User> users, int id) {

        Optional<User> foundUser = users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();

        if (foundUser.isPresent()) {
            return foundUser;
        } else {
            return Optional.empty();
        }

    }
}
