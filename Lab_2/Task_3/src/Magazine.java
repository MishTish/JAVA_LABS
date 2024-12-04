class Magazine extends Media {
    private String issue;

    public Magazine(String title, String id, String issue) {
        super(title, id);
        this.issue = issue;
    }

    public String getIssue() {
        return issue;
    }

    @Override
    public String toString() {
        return super.toString() + ", Issue: " + issue;
    }
}