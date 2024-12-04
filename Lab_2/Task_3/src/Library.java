import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


class Library<T extends Media> {
    private List<T> resources = new ArrayList<>();

    public void addMedia(T media) {
        resources.add(media);
        System.out.println("Added: " + media.getClass().getName() + " [" + media + "]");
    }

    public void removeMediaByID(String id) {
        if (resources.removeIf(media -> media.getId().equals(id))) {
            System.out.println("Removed media with ID: " + id);
        } else {
            System.out.println("Media with ID: " + id + " not found");
        }
    }
    public void removeMediaByTitle(String title) {
        if (resources.removeIf(media -> media.getTitle().equalsIgnoreCase(title))) {
            System.out.println("Removed media with Title: " + title);
        } else {
            System.out.println("Media with Title: " + title + " not found");
        }
    }

    public List<T> searchMediaByID(String ID) {
        return resources.stream()
                .filter(media -> media.getId().equals(ID))
                .collect(Collectors.toList());
    }

    public List<T> searchMediaByTitle(String keyword) {
        return resources.stream()
                .filter(media -> media.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }


    public void displayAll() {
        if (resources.isEmpty()) {
            System.out.println("No media in the library.");
        } else {
            List<T> IDsortedList = resources.stream().sorted(Comparator.comparing(Media::getId)).toList();
            for (T media : IDsortedList) {
                System.out.println(media.getClass().getName() + " [" + media + "]");

            }
        }
    }
}