package am.project.repositories;

import am.project.models.Author;
import am.project.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "select * from book", nativeQuery = true)
    List<Book> getAll();
    Book findById(int id);
    List<Book> getBooksByAuthor(Author author);
}
