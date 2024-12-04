class Book extends Media {
    private String author;

    public Book(String title, String id, String author) {
        super(title, id);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return super.toString() + ", Author: " + author;
    }
}