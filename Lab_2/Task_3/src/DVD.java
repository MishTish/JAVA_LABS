class DVD extends Media {
    private String director;

    public DVD(String title, String id, String director) {
        super(title, id);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return super.toString() + ", Director: " + director;
    }
}