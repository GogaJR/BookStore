package am.project.repositories;

import am.project.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    @Query(value = "select * from author order by id desc limit 1", nativeQuery = true)
    Author getLastAuthor();
    Author findById(int id);
    Author findByNameAndSurname(String name, String surname);
    List<Author> getAuthorsByName(String name);
    List<Author> getAuthorsBySurname(String surname);
    List<Author> getAuthorsByNameAndSurname(String name, String surname);
}
