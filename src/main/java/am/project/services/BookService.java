package am.project.services;

import am.project.forms.BookFormWithAuthor;
import am.project.models.Author;
import am.project.models.Book;

import java.util.List;

public interface BookService {
    void addBook(BookFormWithAuthor bookFormWithAuthor);
    void updateBook(Book book);
    void deleteBook(int id);
    Book getBookById(int id);
    List<Book> getAllBooks();
    List<Book> getBooksByAuthor(Author author);
}
