package am.project.forms;

import am.project.models.Book;

public class BookFormWithAuthor {
    private int id;
    private String title;
    private String authorName;
    private String authorSurname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public static BookFormWithAuthor from(Book book) {
        BookFormWithAuthor bookForm = new BookFormWithAuthor();
        bookForm.setId(book.getId());
        bookForm.setTitle(book.getTitle());
        bookForm.setAuthorName(book.getAuthor().getName());
        bookForm.setAuthorSurname(book.getAuthor().getSurname());

        return bookForm;
    }
}
