package am.project.controllers;

import am.project.forms.BookFormWithAuthor;
import am.project.models.Author;
import am.project.models.Book;
import am.project.services.AuthorService;
import am.project.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/addBook")
    public String getAddPage() {
        return "addBook";
    }

    @PostMapping("/addBook")
    public String addBook(BookFormWithAuthor bookForm) {
        bookService.addBook(bookForm);
        return "redirect:/";
    }

    @GetMapping("/bookInfo")
    public String getBookPage(@RequestParam(name = "bookId") String id, ModelMap modelMap) {
        int bookId = Integer.parseInt(id);
        Book book = bookService.getBookById(bookId);
        BookFormWithAuthor bookForm = BookFormWithAuthor.from(book);
        modelMap.addAttribute("book", bookForm);

        return "bookInfo";
    }

    @GetMapping("/search")
    public String getSearchResults(@ModelAttribute("authorName") Object authorName,
                                   @ModelAttribute("authorSurname") Object authorSurname, ModelMap modelMap) {
        List<Author> authors = new ArrayList<>();
        Map<Author, List<Book>> authorBooks = new HashMap<>();
        Class firstAttributeClass = authorName.getClass();
        Class secondAttributeClass = authorSurname.getClass();
        if(firstAttributeClass.getName().equals("java.lang.String")) {
            if(secondAttributeClass.getName().equals("java.lang.String")) {
                authors = authorService.getAuthorsByNameAndSurname(authorName.toString(), authorSurname.toString());
            } else {
                authors = authorService.getAuthorsByName(authorName.toString());
            }

        } else if(secondAttributeClass.getName().equals("java.lang.String")) {
            authors = authorService.getAuthorsBySurname(authorSurname.toString());
        }

        for(Author author : authors) {
            List<Book> books = bookService.getBooksByAuthor(author);
            authorBooks.put(author, books);
        }

        modelMap.addAttribute("authorBooks", authorBooks);
        return "searchResults";
    }
}
