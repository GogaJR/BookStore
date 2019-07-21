package am.project.services;

import am.project.forms.BookFormWithAuthor;
import am.project.models.Author;
import am.project.models.Book;
import am.project.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    @Override
    public void addBook(BookFormWithAuthor bookForm) {
        Book newBook = new Book();
        newBook.setTitle(bookForm.getTitle());

        String authorName = bookForm.getAuthorName();
        String authorSurname = bookForm.getAuthorSurname();
        int authorId = authorService.isAuthorPresent(authorName, authorSurname);
        if(authorId == 0) {
            authorService.addAuthor(authorName, authorSurname);

            Author lastAddedAuthor = authorService.getLastAuthor();
            newBook.setAuthor(lastAddedAuthor);
        } else {
            Author existedAuthor = authorService.getAuthorById(authorId);
            newBook.setAuthor(existedAuthor);
        }

        bookRepository.save(newBook);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public void deleteBook(int id) {
        Book book = bookRepository.findById(id);
        bookRepository.delete(id);
        Author author = authorService.getAuthorById(book.getAuthor().getId());
        if(author.getBooks().isEmpty()) {
            authorService.deleteAuthor(author.getId());
        }
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        return bookRepository.getBooksByAuthor(author);
    }
}
