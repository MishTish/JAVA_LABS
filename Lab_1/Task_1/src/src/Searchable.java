package src;

@FunctionalInterface
public interface Searchable {

    public boolean textSearch(String source, String query);
}
