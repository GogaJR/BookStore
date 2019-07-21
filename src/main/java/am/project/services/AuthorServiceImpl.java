package am.project.services;

import am.project.models.Author;
import am.project.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void addAuthor(String name, String surname) {
        Author newAuthor = new Author();
        newAuthor.setName(name);
        newAuthor.setSurname(surname);
        authorRepository.save(newAuthor);
    }

    @Override
    public Author getLastAuthor() {
        return authorRepository.getLastAuthor();
    }

    @Override
    public Author getAuthorById(int id) {
        return authorRepository.findById(id);
    }

    @Override
    public void deleteAuthor(int id) {
        authorRepository.delete(id);
    }

    @Override
    public int isAuthorPresent(String authorName, String authorSurname) {
        Author author = authorRepository.findByNameAndSurname(authorName, authorSurname);
        if(author != null) {
            return author.getId();
        }

        return 0;
    }

    @Override
    public List<Author> getAuthorsByName(String name) {
        return authorRepository.getAuthorsByName(name);
    }

    @Override
    public List<Author> getAuthorsBySurname(String surname) {
        return authorRepository.getAuthorsBySurname(surname);
    }

    @Override
    public List<Author> getAuthorsByNameAndSurname(String name, String surname) {
        return authorRepository.getAuthorsByNameAndSurname(name, surname);
    }
}
