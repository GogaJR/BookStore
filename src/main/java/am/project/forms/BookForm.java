package am.project.forms;

import am.project.models.Book;

public class BookForm {
    private int id;
    private String title;

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

    public static BookForm from(Book book) {
        BookForm bookForm = new BookForm();
        bookForm.setId(book.getId());
        bookForm.setTitle(book.getTitle());

        return bookForm;
    }
}
