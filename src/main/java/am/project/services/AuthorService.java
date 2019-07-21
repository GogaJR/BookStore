package am.project.services;

import am.project.models.Author;

import java.util.List;

public interface AuthorService {
    void addAuthor(String name, String surname);
    void deleteAuthor(int id);
    int isAuthorPresent(String authorName, String authorSurname);
    Author getLastAuthor();
    Author getAuthorById(int id);
    List<Author> getAuthorsByName(String name);
    List<Author> getAuthorsBySurname(String surname);
    List<Author> getAuthorsByNameAndSurname(String name, String surname);
}
